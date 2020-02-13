package practices.practice8.parsers;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import practices.practice8.instances.Employee;
import practices.practice8.instances.Railway;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMParser {
    @NotNull
    public static Railway parseXmlDom(String xmlPath) {
        Railway railway = new Railway();
        try {
            int depotNumber = 0;
            String trainName = null;
            String elementName = null;
            String info;
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(xmlPath);
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();

            for (int i = 0; i < books.getLength(); i++) {
                boolean boolB = true;
                Node a = books.item(i);
                if (a.getNodeType() != Node.TEXT_NODE) {
                    NodeList a1 = a.getChildNodes();
                    for (int j = 0; j < a1.getLength(); j++) {
                        boolean boolC = true;
                        Node b = a1.item(j);
                        if (b.getNodeType() != Node.TEXT_NODE) {
                            if (boolB) {
                                depotNumber = Integer.parseInt(b.getChildNodes().item(0).getTextContent());
                                railway.addDepot(depotNumber);
                                boolB = false;
                            }
                            NodeList b1 = b.getChildNodes();
                            for (int k = 0; k < b1.getLength(); k++) {
                                boolean boolD = true;
                                Node c = b1.item(k);
                                if (c.getNodeType() != Node.TEXT_NODE) {
                                    NodeList c1 = c.getChildNodes();
                                    if (boolC) {
                                        trainName = c.getChildNodes().item(0).getTextContent();
                                        railway.addTrain(depotNumber, trainName);
                                        boolC = false;
                                    }
                                    for (int l = 0; l < c1.getLength(); l++) {
                                        Node d = c1.item(l);
                                        if (d.getNodeType() != Node.TEXT_NODE) {
                                            NodeList d1 = d.getChildNodes();
                                            if (boolD) {
                                                elementName = d.getChildNodes().item(0).getTextContent();
                                                railway.addCompositionElement(depotNumber, trainName, elementName);
                                                boolD = false;
                                            }
                                            Employee employee = new Employee();
                                            for (int m = 0; m < d1.getLength(); m++) {
                                                Node e = d1.item(m);

                                                if (e.getNodeType() != Node.TEXT_NODE) {
                                                    info = e.getChildNodes().item(0).getTextContent();
                                                    switch (m) {
                                                        case 1 -> employee.setId(Integer.parseInt(info));
                                                        case 3 -> employee.setGender(info);
                                                        case 5 -> employee.setFirstName(info);
                                                        case 7 -> employee.setLastName(info);
                                                        case 9 -> employee.setMiddleName(info);
                                                        case 11 -> employee.setRole(info);
                                                    }
                                                }
                                            }
                                            if (employee.getId() != 0)
                                                railway.addEmployee(depotNumber, trainName, elementName, employee);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }
        return railway;
    }
}


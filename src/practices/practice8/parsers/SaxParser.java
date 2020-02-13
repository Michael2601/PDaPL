package practices.practice8.parsers;

import org.jetbrains.annotations.NotNull;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import practices.practice8.instances.Employee;
import practices.practice8.instances.Railway;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxParser {
    @NotNull
    public static Railway parseXmlSax(String xmlPath) {
        Railway railway = new Railway();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {
                boolean depot = false, train = false, element = false, id = false, gender = false, first = false,
                        middle = false, last = false, role = false;

                @Override
                public void startElement(String uri, String localName, @NotNull String qName, Attributes attributes) {
                    if (qName.equalsIgnoreCase("DepotNumber")) depot = true;
                    if (qName.equalsIgnoreCase("TrainName")) train = true;
                    if (qName.equalsIgnoreCase("CompositionElementName")) element = true;
                    if (qName.equalsIgnoreCase("Id")) id = true;
                    if (qName.equalsIgnoreCase("Gender")) gender = true;
                    if (qName.equalsIgnoreCase("FirstName")) first = true;
                    if (qName.equalsIgnoreCase("LastName")) middle = true;
                    if (qName.equalsIgnoreCase("MiddleName")) last = true;
                    if (qName.equalsIgnoreCase("EmployeeRole")) role = true;

                }

                int depotNum;
                String trainName;
                String elementName;
                String info;
                Employee employee = new Employee();

                @Override
                public void characters(char[] ch, int start, int length) {
                    info = new String(ch, start, length);
                    if (depot) {
                        depotNum = Integer.parseInt(info);
                        railway.addDepot(depotNum);
                        depot = false;
                    }
                    if (train) {
                        trainName = info;
                        railway.addTrain(depotNum, trainName);
                        train = false;
                    }
                    if (element) {
                        elementName = info;
                        railway.addCompositionElement(depotNum, trainName, elementName);
                        element = false;
                    }
                    if (id) {
                        employee.setId(Integer.parseInt(info));
                        id = false;
                    }
                    if (gender) {
                        employee.setGender(info);
                        gender = false;
                    }
                    if (first) {
                        employee.setFirstName(info);
                        first = false;
                    }
                    if (middle) {
                        employee.setMiddleName(info);
                        middle = false;
                    }
                    if (last) {
                        employee.setLastName(info);
                        last = false;
                    }
                    if (role) {
                        employee.setRole(info);
                        railway.addEmployee(depotNum, trainName, elementName, employee);
                        employee = new Employee();
                        role = false;
                    }
                }
            };
            saxParser.parse(xmlPath, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return railway;
    }
}

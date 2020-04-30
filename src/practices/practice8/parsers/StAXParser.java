package practices.practice8.parsers;

import org.jetbrains.annotations.NotNull;
import practices.practice8.instances.Employee;
import practices.practice8.instances.Railway;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
/**
 * @author Michael Sheshilov
 */
public class StAXParser {
    @NotNull
    public static Railway parseXmlStAX(String xmlPath) {
        Railway railway = new Railway();
        try {
            XMLStreamReader xml = XMLInputFactory.newInstance().createXMLStreamReader(xmlPath, new FileInputStream(xmlPath));
            boolean depot = false, train = false, element = false, id = false, gender = false, first = false,
                    middle = false, last = false, role = false;
            int depotNum = 0;
            String trainName = "";
            String elementName = "";
            String info;
            Employee employee = new Employee();

            while (xml.hasNext()) {
                xml.next();
                if (xml.isStartElement()) {
                    if (xml.getLocalName().equalsIgnoreCase("DepotNumber")) depot = true;
                    if (xml.getLocalName().equalsIgnoreCase("TrainName")) train = true;
                    if (xml.getLocalName().equalsIgnoreCase("CompositionElementName")) element = true;
                    if (xml.getLocalName().equalsIgnoreCase("Id")) id = true;
                    if (xml.getLocalName().equalsIgnoreCase("Gender")) gender = true;
                    if (xml.getLocalName().equalsIgnoreCase("FirstName")) first = true;
                    if (xml.getLocalName().equalsIgnoreCase("LastName")) middle = true;
                    if (xml.getLocalName().equalsIgnoreCase("MiddleName")) last = true;
                    if (xml.getLocalName().equalsIgnoreCase("EmployeeRole")) role = true;
                } else if (xml.hasText() && xml.getText().trim().length() > 0) {
                    info = xml.getText();
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
            }
            xml.close();
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }
        return railway;
    }
}

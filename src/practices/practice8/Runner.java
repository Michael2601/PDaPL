package practices.practice8;

import practices.practice8.parsers.DOMParser;
import practices.practice8.parsers.SaxParser;
import practices.practice8.parsers.StAXParser;
import practices.practice8.utils.XslConverter;
import utils.GlobalUtil;

import java.io.FileWriter;

import static practices.practice8.utils.XsdValidator.validateXMLSchema;

public class Runner {
    public static void main(String[] args) {
        String xsdPath = "files/practice8/in/railwayXSD.xsd";
        String xslPath = "files/practice8/in/railwayXSL.xsl";
        String xmlPath = "files/practice8/in/railway.xml";
        String htmlPath = "files/practice8/out/railway.html";

        boolean answer = validateXMLSchema(xsdPath, xmlPath);
        System.out.println("Result of validate XML by XSD:" + answer);
        if(answer) {
            System.out.println(DOMParser.parseXmlDom(xmlPath));
            System.out.println(SaxParser.parseXmlSax(xmlPath));
            System.out.println(StAXParser.parseXmlStAX(xmlPath));
            XslConverter c = new XslConverter();
            try (FileWriter writer = new FileWriter(htmlPath, false)) {
                String result = c.xmlToString(xmlPath, xslPath);
                writer.write(result);
                System.out.println("HTML file rewrite. Open it in browser to check");
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
            GlobalUtil.postScriptum("Michael Sheshilov", "13.02.2020 22:30");
        }

    }
}

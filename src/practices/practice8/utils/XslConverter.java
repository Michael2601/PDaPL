package practices.practice8.utils;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class XslConverter {

    public String xmlToString(String xmlFile, String xslFile) throws Exception {
        InputStream xml = new FileInputStream(xmlFile);
        InputStream xsl = new FileInputStream(xslFile);
        StreamSource xmlSource = new StreamSource(xml);
        StreamSource styleSource = new StreamSource(xsl);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        StreamResult xmlOutput = new StreamResult(bos);
        Transformer transformer = TransformerFactory.newInstance().newTransformer(styleSource);
        transformer.transform(xmlSource, xmlOutput);
        return bos.toString();
    }
}

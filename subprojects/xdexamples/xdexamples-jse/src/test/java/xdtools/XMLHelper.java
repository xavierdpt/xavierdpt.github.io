package xdtools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class XMLHelper {

    public static Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.newDocument();
    }

    public static String documentToString(Document document) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StringWriter sw = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(sw));
        return sw.toString();
    }

    public static void addBooleanElement(Document document, Element parent, String name, boolean value) {
        if (value) {
            parent.appendChild(document.createElement(name));
        }
    }

    public static void addTextElement(Document document, Element parent, String name, String value) {
        if (value != null && value.length() > 0) {
            Element element = document.createElement(name);
            element.appendChild(document.createTextNode(value));
            parent.appendChild(element);
        }
    }

    public static Element createRootElement(Document document, String name) {
        Element root = document.createElement(name);
        document.appendChild(root);
        return root;
    }

    public static Element addElement(Document document, Element parent, String name) {
        Element element = document.createElement(name);
        parent.appendChild(element);
        return element;
    }
}

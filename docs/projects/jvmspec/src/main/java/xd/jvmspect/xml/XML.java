package xd.jvmspect.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;

public class XML {

    private static DocumentBuilder documentBuilder;
    private static Transformer transformer;

    static {
        try {
            documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", 2);
            transformer = transformerFactory.newTransformer();
            transformer.setParameter(OutputKeys.INDENT, "yes");
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Document createDocument() {
        Document document = documentBuilder.newDocument();
        document.setXmlStandalone(true);
        return document;
    }

    public static void writeDocument(Document document, OutputStream outputStream) throws TransformerException {
        transformer.transform(new DOMSource(document), new StreamResult(outputStream));
    }

    public static Element createRootElement(Document document, String tagName) {
        Element element = document.createElement(tagName);
        document.appendChild(element);
        return element;
    }

    public static Element createChild(Document document, Element parent, String tagName) {
        Element element = document.createElement(tagName);
        parent.appendChild(element);
        return element;
    }

    public static Element createChild(Document document, Element parent, String tagName, String text) {
        Element element = document.createElement(tagName);
        element.appendChild(document.createTextNode(text));
        parent.appendChild(element);
        return element;
    }

    public static Document readDocument(Reader reader) throws IOException, SAXException {
        return documentBuilder.parse(new InputSource(reader));
    }
}

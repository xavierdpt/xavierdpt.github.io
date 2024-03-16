package com.github.xavierdpt.jvmspect.utils;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.constants.Constant;
import com.github.xavierdpt.jvmspect.input.constants.ConstantUtf8;
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
import java.util.TreeSet;

public class XML {

    private static final DocumentBuilder DOCUMENT_BUILDER;
    private static final Transformer TRANSFORMER;
    private static final TreeSet<Integer> FORBIDDEN_CHARACTERS = new TreeSet<>();
    private static final TreeSet<Integer> ACCEPTED_CHARACTERS = new TreeSet<>();

    static {
        try {
            DOCUMENT_BUILDER = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", 2);
            TRANSFORMER = transformerFactory.newTransformer();
            TRANSFORMER.setParameter(OutputKeys.INDENT, "yes");
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    public static Document createDocument() {
        Document document = DOCUMENT_BUILDER.newDocument();
        document.setXmlStandalone(true);
        return document;
    }

    public static void writeDocument(Document document, OutputStream outputStream) throws TransformerException {
        TRANSFORMER.transform(new DOMSource(document), new StreamResult(outputStream));
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
        return DOCUMENT_BUILDER.parse(new InputSource(reader));
    }

    // If the value is text, set attribute with that value, otherwise append the corresponding element
    public static void constantAttribute(Document document, Element result, String attributeName, ConstantResolver constantResolver, int index) {
        Constant constant = constantResolver.resolve(index);
        if (constant instanceof ConstantUtf8) {
            result.setAttribute(attributeName, ((ConstantUtf8) constant).getUTF8String());
        } else {
            Element element = document.createElement(attributeName);
            element.appendChild(constant.toXMLRef(document, constantResolver));
            result.appendChild(element);
        }
    }

    // If the value is text, append the text as a text node, otherwise append the corresponding element
    public static void constantText(Document document, Element result, String attributeName, ConstantResolver constantResolver, int index) {
        Constant constant = constantResolver.resolve(index);
        if (constant instanceof ConstantUtf8) {
            ConstantUtf8 constantUtf8 = (ConstantUtf8) constant;
            result.appendChild(document.createTextNode(constantUtf8.getUTF8String()));
        } else {
            Element element = document.createElement(attributeName);
            element.appendChild(constant.toXMLRef(document, constantResolver));
            result.appendChild(element);
        }
    }

    // Create a new element, and if the value is text, append the text to that element, or append the element corresponding to that value to the element
    public static void constantElement(Document document, Element result, String attributeName, ConstantResolver constantResolver, int index) {
        Constant constant = constantResolver.resolve(index);
        if (constant instanceof ConstantUtf8) {
            ConstantUtf8 constantUtf8 = (ConstantUtf8) constant;
            Element element = document.createElement(attributeName);
            element.appendChild(document.createTextNode(constantUtf8.getUTF8String()));
            result.appendChild(element);
        } else {
            Element element = document.createElement(attributeName);
            element.appendChild(constant.toXMLRef(document, constantResolver));
            result.appendChild(element);
        }
    }

    public static void createAttribute(
            @SuppressWarnings("unused") Document document,
            Element result, String name, String value) {
        result.setAttribute(name, value);
    }

    public static void appendConstant(Document document, Element parent, ConstantResolver constantResolver, int index) {
        parent.appendChild(constantResolver.resolve(index).toXMLRef(document, constantResolver));
    }


    public static boolean isForbidden(Character left, char right) {
        return false;
    }




}

package xdtools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class ClassDumper {
    public static String dump(Class<?> clazz) throws ParserConfigurationException, TransformerException {
        Document document = XMLHelper.createDocument();
        Element root = XMLHelper.createRootElement(document, "class");
        root.setAttribute("name", clazz.getName());
        dumpInterfaces(document, root, clazz);
        dumpSuperClass(document, root, clazz.getSuperclass());
        return XMLHelper.documentToString(document);
    }

    private static void dumpSuperClass(Document document, Element parent, Class<?> clazz) {
        if (clazz != null) {
            Element superXML = XMLHelper.addElement(document, parent, "super");
            superXML.setAttribute("name", clazz.getName());
            dumpInterfaces(document, superXML, clazz);
            dumpSuperClass(document, superXML, clazz.getSuperclass());
        }
    }

    private static void dumpInterfaces(Document document, Element parent, Class<?> clazz) {
        Class<?>[] interfaces = clazz.getInterfaces();
        if (interfaces.length > 0) {
            Element interfacesXML = XMLHelper.addElement(document, parent, "interfaces");
            interfacesXML.setAttribute("size", String.valueOf(interfaces.length));
            for (Class<?> intf : interfaces) {
                Element interfaceXML = XMLHelper.addElement(document, interfacesXML, "interface");
                interfaceXML.setAttribute("name", intf.getName());
            }
        }
    }
}

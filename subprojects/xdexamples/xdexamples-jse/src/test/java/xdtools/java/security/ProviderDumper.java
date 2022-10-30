package xdtools.java.security;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xdtest.SeeAlso;
import xdtest.java.security.ProviderTest;
import xdtest.java.security.SecurityTest;
import xdtools.XMLHelper;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.security.Provider;
import java.security.Security;
import java.util.Map;
import java.util.Set;

@SeeAlso({SecurityTest.class, ProviderTest.class})
public class ProviderDumper {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        Document document = XMLHelper.createDocument();
        Element root = XMLHelper.createRootElement(document, "providers");
        for (Provider provider : Security.getProviders()) {
            dumpProviders(document, root, provider);
        }
        System.out.println(XMLHelper.documentToString(document));
    }

    private static void dumpProviders(Document document, Element parent, Provider provider) {
        Element element = XMLHelper.addElement(document, parent, "provider");
        element.setAttribute("name", provider.getName());
        element.setAttribute("version", provider.getVersionStr());
        XMLHelper.addTextElement(document, element, "info", provider.getInfo());
        XMLHelper.addBooleanElement(document, element, "configured", provider.isConfigured());
        Element properties = XMLHelper.addElement(document, element, "properties");
        properties.setAttribute("size", String.valueOf(provider.size()));
        for (Map.Entry<Object, Object> entry : provider.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            Element property = XMLHelper.addElement(document, properties, "property");
            if (key != null) {
                if (String.class.equals(key.getClass())) {
                    property.setAttribute("key", (String) key);
                } else {
                    property.setAttribute("keyClass", key.getClass().getName());
                }
            }
            if (value != null) {
                if (String.class.equals(value.getClass())) {
                    property.setAttribute("value", (String) value);
                } else {
                    property.setAttribute("valueClass", value.getClass().getName());
                }
            }
        }
        Set<Provider.Service> services = provider.getServices();
        Element servicesXML = XMLHelper.addElement(document, element, "services");
        servicesXML.setAttribute("size", String.valueOf(services.size()));
        for (Provider.Service service : services) {
            Element serviceXML = XMLHelper.addElement(document, servicesXML, "service");
            serviceXML.setAttribute("type", service.getType());
            serviceXML.setAttribute("algorithm", service.getAlgorithm());
            serviceXML.setAttribute("className", service.getClassName());
        }

    }
}

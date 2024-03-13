package xd.jvmspect;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.attributes.RawAttributeInfo;
import xd.jvmspect.xml.XML;

public record MethodInfo(int accessFlags, int nameIndex, int descriptorIndex, RawAttributeInfo[] attributeInfos) {
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element element = document.createElement("method");

        Element name = XML.createChild(document, element, "name");
        name.setAttribute("index", String.valueOf(nameIndex));
        name.appendChild(document.createTextNode(constantResolver.resolveString(nameIndex)));

        Element descriptor = XML.createChild(document, element, "descriptor");
        descriptor.setAttribute("index", String.valueOf(descriptorIndex));
        descriptor.appendChild(document.createTextNode(constantResolver.resolveString(descriptorIndex)));

        XML.createChild(document, element, "accessFlags", Integer.toHexString(accessFlags));

        Element attributes = document.createElement("attributes");
        for (RawAttributeInfo attributeInfo : attributeInfos) {
            attributes.appendChild(attributeInfo.toXML(document, constantResolver));
        }
        element.appendChild(attributes);
        return element;
    }
}

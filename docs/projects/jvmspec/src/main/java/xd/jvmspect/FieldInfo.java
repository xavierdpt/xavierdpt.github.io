package xd.jvmspect;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.attributes.RawAttributeInfo;
import xd.jvmspect.xml.XML;

public record FieldInfo(int accessFlags, int nameIndex, int descriptorIndex, RawAttributeInfo[] attributeInfos) {
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element element = document.createElement("field");
        XML.createChild(document,element,"accessFlags",Integer.toHexString(accessFlags));
        XML.createChild(document,element,"nameIndex", String.valueOf(nameIndex));
        XML.createChild(document,element,"descriptorIndex", String.valueOf(descriptorIndex));
        Element attributes = document.createElement("attributes");
        for (RawAttributeInfo attributeInfo : attributeInfos) {
            attributes.appendChild(attributeInfo.toXML(document, constantResolver));
        }
        element.appendChild(attributes);
        return element;
    }
}

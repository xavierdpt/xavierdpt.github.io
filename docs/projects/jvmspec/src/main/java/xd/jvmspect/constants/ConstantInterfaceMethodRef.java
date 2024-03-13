package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record ConstantInterfaceMethodRef(int classIndex, int nameAndTypeIndex) implements ConstantObject {
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        XML.createChild(document, constant, "classIndex", String.valueOf(classIndex));
        XML.createChild(document, constant, "nameAndTypeIndex", String.valueOf(nameAndTypeIndex));
    }

    @Override
    public Element toXMLForCode(Document document, ConstantResolver constantResolver) {
        Element element = document.createElement("interfaceMethodRef");
        element.appendChild(constantResolver.resolve(classIndex).toXMLForCode(document, constantResolver));
        element.appendChild(constantResolver.resolve(nameAndTypeIndex).toXMLForCode(document, constantResolver));
        return element;
    }
}

package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record ConstantMethodRef(int classIndex, int nameAndTypeIndex) implements ConstantObject {
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        XML.createChild(document, constant, "classIndex", String.valueOf(classIndex));
        XML.createChild(document, constant, "nameAndTypeIndex", String.valueOf(nameAndTypeIndex));
    }

    @Override
    public Element toXMLForCode(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("methodRef");
        result.appendChild(constantResolver.resolve(this.classIndex).toXMLForCode(document, constantResolver));
        result.appendChild(constantResolver.resolve(this.nameAndTypeIndex).toXMLForCode(document, constantResolver));
        return result;
    }
}

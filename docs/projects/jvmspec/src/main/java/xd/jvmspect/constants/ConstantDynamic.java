package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record ConstantDynamic(int boostrapMethodAttrIndex, int nameAndTypeIndex) implements ConstantObject {
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        XML.createChild(document, constant, "boostrapMethodAttrIndex", String.valueOf(boostrapMethodAttrIndex));
        XML.createChild(document, constant, "nameAndTypeIndex", String.valueOf(nameAndTypeIndex));
    }
}

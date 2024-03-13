package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record ConstantModule(int nameIndex) implements ConstantObject{
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        XML.createChild(document,constant,"nameIndex", String.valueOf(nameIndex));
    }
}

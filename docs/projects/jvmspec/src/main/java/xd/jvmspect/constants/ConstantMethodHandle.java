package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record ConstantMethodHandle(int referenceKind, int referenceIndex) implements ConstantObject {
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        XML.createChild(document, constant, "referenceKind", String.valueOf(referenceKind));
        XML.createChild(document, constant, "referenceIndex", String.valueOf(referenceIndex));
    }
}

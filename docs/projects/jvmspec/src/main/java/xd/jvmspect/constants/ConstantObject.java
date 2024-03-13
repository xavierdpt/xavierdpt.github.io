package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public interface ConstantObject {

    default int getNEntries() {
        return 1;
    }

    default Element toXML(Document document, int constantIndex, ConstantResolver constantResolver) {
        Element constant = document.createElement("constant");
        constant.setAttribute("index", String.valueOf(constantIndex));
        constant.setAttribute("type", this.getClass().getSimpleName());
        customizeXML(document, constant, constantResolver);
        return constant;
    }

    default void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {

    }

    default Element toXMLForCode(Document document, ConstantResolver constantResolver) {
        throw new RuntimeException("TODO");
    }
}

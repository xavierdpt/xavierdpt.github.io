package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public record ConstantFloat(float value) implements ConstantObject {
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        constant.appendChild(document.createTextNode(String.valueOf(value)));
    }
}

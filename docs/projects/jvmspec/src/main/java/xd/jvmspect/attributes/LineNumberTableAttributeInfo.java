package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public record LineNumberTableAttributeInfo(LineNumber[] lineNumbers) implements IAttributeInfo {
    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("lineNumbers");
        for (LineNumber lineNumber : lineNumbers) {
            result.appendChild(lineNumber.toXML(document));
        }
        return result;
    }
}

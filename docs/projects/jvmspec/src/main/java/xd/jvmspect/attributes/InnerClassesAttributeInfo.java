package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public record InnerClassesAttributeInfo(InnerClass[] innerClasses) implements IAttributeInfo {
    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("innerClasses");
        for (InnerClass innerClass : innerClasses) {
            result.appendChild(innerClass.toXML(document,constantResolver));
        }
        return result;
    }
}

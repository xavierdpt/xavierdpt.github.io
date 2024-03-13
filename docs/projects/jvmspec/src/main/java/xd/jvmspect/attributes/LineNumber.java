package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public record LineNumber(int codeOffset, int lineNumber) {
    public Element toXML(Document document) {
        Element element = document.createElement("lineNumber");
        element.setAttribute("codeOffset", String.valueOf(codeOffset));
        element.setAttribute("lineNumber", String.valueOf(lineNumber));
        return element;
    }
}

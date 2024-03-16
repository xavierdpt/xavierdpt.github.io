package com.github.xavierdpt.jvmspect.input.attributes.ln;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class LineNumber {

    private final int codeOffset;
    private final int lineNumber;

    public LineNumber(int codeOffset, int lineNumber) {
        this.codeOffset = codeOffset;
        this.lineNumber = lineNumber;
    }

    public Element toXML(Document document) {
        Element element = document.createElement("lineNumber");
        element.setAttribute("codeOffset", String.valueOf(codeOffset));
        element.setAttribute("lineNumber", String.valueOf(lineNumber));
        return element;
    }


}

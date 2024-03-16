package com.github.xavierdpt.jvmspect.input.attributes.code;

import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class ExceptionInfo {
    private final int startPc;
    private final int endPc;
    private final int handlerPc;
    private final int catchType;

    public ExceptionInfo(int startPc, int endPc, int handlerPc, int catchType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }


    public Node toXML(Document document) {
        Element exception = document.createElement("exception");
        XML.createAttribute(document, exception, "startPc", String.valueOf(startPc));
        XML.createAttribute(document, exception, "endPc", String.valueOf(endPc));
        XML.createAttribute(document, exception, "handlerPc", String.valueOf(handlerPc));
        XML.createAttribute(document, exception, "catchType", String.valueOf(catchType));
        return exception;
    }
}

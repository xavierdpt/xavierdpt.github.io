package xd.jvmspect;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xd.jvmspect.xml.XML;

public record ExceptionInfo(int startPc, int endPc, int handlerPc, int catchType) {
    public Node toXML(Document document) {
        Element exception = document.createElement("exception");
        XML.createChild(document,exception,"startPc", String.valueOf(startPc));
        XML.createChild(document,exception,"endPc", String.valueOf(endPc));
        XML.createChild(document,exception,"handlerPc", String.valueOf(handlerPc));
        XML.createChild(document,exception,"catchType", String.valueOf(catchType));
        return exception;
    }
}

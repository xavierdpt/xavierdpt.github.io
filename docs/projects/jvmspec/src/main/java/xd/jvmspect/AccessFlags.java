package xd.jvmspect;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public record AccessFlags(int accessFlags) {
    public Node toXML(Document document) {
        Element xml = document.createElement("accessFlags");
        xml.appendChild(document.createTextNode(Integer.toHexString(accessFlags)));
        return xml;
    }
}

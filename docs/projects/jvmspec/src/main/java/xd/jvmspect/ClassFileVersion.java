package xd.jvmspect;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.xml.XML;

public record ClassFileVersion(int majorVersion, int minorVersion) {
    public Element toXML(Document document) {
        Element version = document.createElement("version");
        XML.createChild(document,version,"major", String.valueOf(majorVersion));
        XML.createChild(document,version,"minor", String.valueOf(minorVersion));
        return version;
    }
}

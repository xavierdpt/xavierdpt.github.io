package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record LocalVariable(int codeOffset, int length, int nameIndex, int descriptorIndex, int index) {
    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("localVariable");
        XML.createChild(document, result, "codeOffset", String.valueOf(codeOffset));
        XML.createChild(document, result, "length", String.valueOf(length));
        XML.createChild(document, result, "name", constantResolver.resolveString(nameIndex));
        XML.createChild(document, result, "descriptor", constantResolver.resolveString(descriptorIndex));
        XML.createChild(document, result, "index", String.valueOf(index));
        return result;
    }
}

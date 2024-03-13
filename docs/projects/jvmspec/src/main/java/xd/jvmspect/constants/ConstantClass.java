package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record ConstantClass(int nameIndex) implements ConstantObject {
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        Element element = document.createElement("name");
        element.setAttribute("index", String.valueOf(nameIndex));
        element.appendChild(document.createTextNode(constantResolver.resolveString(nameIndex)));
        constant.appendChild(element);
    }

    @Override
    public Element toXMLForCode(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("class");
        XML.createChild(document, result, "name", constantResolver.resolveString(nameIndex));
        return result;
    }
}

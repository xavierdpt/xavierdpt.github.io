package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;
import xd.jvmspect.xml.XML;

public record ConstantNameAndType(int nameIndex, int descriptorIndex) implements ConstantObject {
    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        Element name = document.createElement("name");
        name.setAttribute("index", String.valueOf(nameIndex));
        name.appendChild(document.createTextNode(constantResolver.resolveString(nameIndex)));
        constant.appendChild(name);

        Element descriptor = document.createElement("descriptor");
        descriptor.setAttribute("index", String.valueOf(descriptorIndex));
        descriptor.appendChild(document.createTextNode(constantResolver.resolveString(descriptorIndex)));
        constant.appendChild(descriptor);
    }

    @Override
    public Element toXMLForCode(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("nameAndType");
        XML.createChild(document, result, "name", constantResolver.resolveString(nameIndex));
        XML.createChild(document, result, "descriptor", constantResolver.resolveString(descriptorIndex));
        return result;
    }
}

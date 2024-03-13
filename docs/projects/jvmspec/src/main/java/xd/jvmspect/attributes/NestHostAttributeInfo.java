package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public record NestHostAttributeInfo(int hostClassIndex) implements IAttributeInfo {

    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("nestHost");
        result.appendChild(constantResolver.resolve(hostClassIndex).toXMLForCode(document, constantResolver));
        return result;
    }
}

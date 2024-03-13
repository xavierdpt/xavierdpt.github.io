package xd.jvmspect.attributes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public interface IAttributeInfo {
    Element toXML(Document document, ConstantResolver constantResolver);
}

package xd.jvmspect.bytecode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public interface Instruction {
    Element toXML(Document document, ConstantResolver constantResolver);
}

package xd.jvmspect.bytecode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

import java.util.List;

public record LookupSwitchInstruction(int defaultOffset, List<LookupSwitchPair> pairs) implements Instruction {
    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        return document.createElement("lookupswitch");
    }
}

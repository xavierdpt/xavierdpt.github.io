package xd.jvmspect.bytecode;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

public record TableSwitchInstruction(int defaultOffset, int[] offsets) implements Instruction {
    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        return document.createElement("tableswitch");
    }
}

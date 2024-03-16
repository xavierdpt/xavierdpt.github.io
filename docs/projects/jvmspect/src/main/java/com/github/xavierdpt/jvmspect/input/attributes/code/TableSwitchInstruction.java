package com.github.xavierdpt.jvmspect.input.attributes.code;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class TableSwitchInstruction extends Instruction {
    private final int defaultOffset;
    private final int[] offsets;

    public TableSwitchInstruction(int defaultOffset, int[] offsets) {
        this.defaultOffset = defaultOffset;
        this.offsets = offsets;
    }

    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("tableswitch");
        result.setAttribute("defaultOffset", String.valueOf(defaultOffset));
        for (int offset : offsets) {
            Element offsetElement = document.createElement("offset");
            offsetElement.appendChild(document.createTextNode(String.valueOf(offset)));
        }
        return result;
    }


}

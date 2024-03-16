package com.github.xavierdpt.jvmspect.input.attributes.code;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public final class LookupSwitchInstruction extends Instruction {

    private final int defaultOffset;
    private final List<LookupSwitchPair> pairs;

    public LookupSwitchInstruction(int defaultOffset, List<LookupSwitchPair> pairs) {
        this.defaultOffset = defaultOffset;
        this.pairs = pairs;
    }

    @Override
    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("lookupswitch");
        result.setAttribute("defaultOffset", String.valueOf(defaultOffset));
        for (LookupSwitchPair pair : pairs) {
            result.appendChild(pair.toXML(document));
        }
        return result;
    }


}

package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SameFrame extends StackMapFrame {
    private final int offsetDelta;

    public SameFrame(int offsetDelta) {
        this.offsetDelta = offsetDelta;
    }

    @Override
    protected String getFrameType() {
        return "SAME";
    }

    @Override
    protected void fillXml(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("offsetDelta", String.valueOf(offsetDelta));
    }
}

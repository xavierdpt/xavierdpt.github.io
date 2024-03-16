package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Chop extends StackMapFrame {
    private final int k;
    private final int offsetDelta;

    public Chop(int k, int offsetDelta) {
        this.k = k;
        this.offsetDelta = offsetDelta;
    }

    @Override
    protected String getFrameType() {
        return "CHOP";
    }

    @Override
    protected void fillXml(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("k", String.valueOf(k));
        result.setAttribute("offsetDelta", String.valueOf(offsetDelta));
    }
}

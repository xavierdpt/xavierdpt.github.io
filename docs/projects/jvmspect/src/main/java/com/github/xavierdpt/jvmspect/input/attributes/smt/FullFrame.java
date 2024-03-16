package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FullFrame extends StackMapFrame {
    private final int offsetDelta;
    private final VerificationTypeInfo[] locals;
    private final VerificationTypeInfo[] stack;

    public FullFrame(int offsetDelta, VerificationTypeInfo[] locals, VerificationTypeInfo[] stack) {
        this.offsetDelta = offsetDelta;
        this.locals = locals;
        this.stack = stack;
    }

    @Override
    protected String getFrameType() {
        return "FULL_FRAME";
    }


    @Override
    protected void fillXml(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("offsetDelta", String.valueOf(offsetDelta));
        Element localsXml = XML.createChild(document, result, "locals");
        for (VerificationTypeInfo local : locals) {
            localsXml.appendChild(local.toXML(document, constantResolver));
        }
        Element stackXml = XML.createChild(document, result, "stack");
        for (VerificationTypeInfo st : stack) {
            stackXml.appendChild(st.toXML(document, constantResolver));
        }
    }
}

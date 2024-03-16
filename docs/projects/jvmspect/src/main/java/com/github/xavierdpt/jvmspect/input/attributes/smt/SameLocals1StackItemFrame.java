package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SameLocals1StackItemFrame extends StackMapFrame {

    private final int offsetDelta;
    private final VerificationTypeInfo verificationTypeInfo;

    public SameLocals1StackItemFrame(int offsetDelta, VerificationTypeInfo verificationTypeInfo) {
        this.offsetDelta = offsetDelta;
        this.verificationTypeInfo = verificationTypeInfo;
    }

    @Override
    protected String getFrameType() {
        return "SAME_LOCALS_1_STACK_ITEM";
    }

    @Override
    protected void fillXml(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("offsetDelta", String.valueOf(offsetDelta));
        result.appendChild(verificationTypeInfo.toXML(document, constantResolver));
    }
}

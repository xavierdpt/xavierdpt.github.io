package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AppendFrame extends StackMapFrame {
    private final int offsetDelta;
    private final VerificationTypeInfo[] verificationTypeInfos;

    public AppendFrame(int offsetDelta, VerificationTypeInfo[] verificationTypeInfos) {
        this.offsetDelta = offsetDelta;
        this.verificationTypeInfos = verificationTypeInfos;
    }

    @Override
    protected String getFrameType() {
        return "APPEND";
    }


    @Override
    protected void fillXml(Document document, Element result, ConstantResolver constantResolver) {
        XML.createChild(document, result, "offsetDelta", String.valueOf(offsetDelta));
        Element verificationTypeInfos1 = XML.createChild(document, result, "verificationTypeInfos");
        for (VerificationTypeInfo verificationTypeInfo : verificationTypeInfos) {
            verificationTypeInfos1.appendChild(verificationTypeInfo.toXML(document, constantResolver));
        }
    }
}

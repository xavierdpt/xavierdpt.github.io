package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class StackMapTableAttributeInfo extends AttributeInfo {
    private final StackMapFrame[] stackMapFrames;

    public StackMapTableAttributeInfo(StackMapFrame[] stackMapFrames) {
        this.stackMapFrames = stackMapFrames;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (StackMapFrame stackMapFrame : stackMapFrames) {
            result.appendChild(stackMapFrame.toXML(document, constantResolver));
        }
    }
}

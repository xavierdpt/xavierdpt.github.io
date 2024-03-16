package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EnclosingMethodAttributeInfo extends AttributeInfo {
    private final int classIndex;
    private final int methodIndex;

    public EnclosingMethodAttributeInfo(int classIndex, int methodIndex) {
        this.classIndex = classIndex;
        this.methodIndex = methodIndex;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        XML.appendConstant(document, result, constantResolver, classIndex);
        if (methodIndex!=0) {
            XML.appendConstant(document, result, constantResolver, methodIndex);
        }

    }
}

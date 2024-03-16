package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConstantValueAttributeInfo extends AttributeInfo {
    private final int constantValueIndex;

    public ConstantValueAttributeInfo(int constantValueIndex) {
        this.constantValueIndex = constantValueIndex;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolve(constantValueIndex).toXMLRef(document, constantResolver));
    }
}

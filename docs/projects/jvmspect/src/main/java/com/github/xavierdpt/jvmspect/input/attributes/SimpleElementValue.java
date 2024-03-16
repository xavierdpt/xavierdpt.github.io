package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.ElementValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SimpleElementValue extends ElementValue {
    private final int constValueIndex;

    public SimpleElementValue(int constValueIndex) {
        this.constValueIndex = constValueIndex;
    }

    @Override
    protected String getTypeXX() {
        return "const";
    }


    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolve(constValueIndex).toXMLRef(document, constantResolver));
    }
}

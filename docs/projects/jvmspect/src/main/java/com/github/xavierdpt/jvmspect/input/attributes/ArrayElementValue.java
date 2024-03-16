package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.ElementValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ArrayElementValue extends ElementValue {
    private final ElementValue[] elementValues;

    public ArrayElementValue(ElementValue[] elementValues) {
        this.elementValues = elementValues;
    }

    @Override
    protected String getTypeXX() {
        return "array";
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (ElementValue elementValue : elementValues) {
            result.appendChild(elementValue.toXML(document, constantResolver));
        }
    }
}

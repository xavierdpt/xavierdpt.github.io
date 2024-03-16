package com.github.xavierdpt.jvmspect.input.attributes.annotations;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AnnotationDefaultAttributeInfo extends AttributeInfo {
    private final ElementValue elementValue;

    public AnnotationDefaultAttributeInfo(ElementValue elementValue) {
        this.elementValue = elementValue;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(elementValue.toXML(document, constantResolver));
    }
}

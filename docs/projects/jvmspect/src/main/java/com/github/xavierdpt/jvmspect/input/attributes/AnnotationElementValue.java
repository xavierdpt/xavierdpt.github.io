package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.AnnotationInfo;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.ElementValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AnnotationElementValue extends ElementValue {
    private final AnnotationInfo annotation;

    public AnnotationElementValue(AnnotationInfo annotation) {
        this.annotation = annotation;
    }

    @Override
    protected String getTypeXX() {
        return "annotation";
    }


    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(annotation.toXML(document, constantResolver));
    }
}

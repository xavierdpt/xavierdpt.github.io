package com.github.xavierdpt.jvmspect.input.attributes.annotations;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class RuntimeInvisibleAnnotationsAttributeInfo extends AttributeInfo {
    private final AnnotationInfo[] annotations;

    public RuntimeInvisibleAnnotationsAttributeInfo(AnnotationInfo[] annotations) {
        this.annotations = annotations;
    }
    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (AnnotationInfo annotation : annotations) {
            result.appendChild(annotation.toXML(document, constantResolver));
        }
    }
}

package com.github.xavierdpt.jvmspect.input.attributes.annotations;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class AnnotationInfo {
    private final int typeIndex;
    private final ElementValuePair[] elementValuePairs;

    public AnnotationInfo(int typeIndex, ElementValuePair[] elementValuePairs) {
        this.typeIndex = typeIndex;
        this.elementValuePairs = elementValuePairs;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("annotation");
        result.setAttribute("typeIndex", String.valueOf(typeIndex));
        for (ElementValuePair elementValuePair : elementValuePairs) {
            result.appendChild(elementValuePair.toXML(document, constantResolver));
        }
        return result;
    }
}

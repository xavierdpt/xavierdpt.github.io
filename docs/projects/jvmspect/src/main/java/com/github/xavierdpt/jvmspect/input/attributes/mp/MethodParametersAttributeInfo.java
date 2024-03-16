package com.github.xavierdpt.jvmspect.input.attributes.mp;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class MethodParametersAttributeInfo extends AttributeInfo {
    private final MethodParameter[] methodParameters;

    public MethodParametersAttributeInfo(MethodParameter[] methodParameters) {
        this.methodParameters = methodParameters;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (MethodParameter methodParameter : methodParameters) {
            result.appendChild(methodParameter.toXML(document, constantResolver));
        }
    }
}

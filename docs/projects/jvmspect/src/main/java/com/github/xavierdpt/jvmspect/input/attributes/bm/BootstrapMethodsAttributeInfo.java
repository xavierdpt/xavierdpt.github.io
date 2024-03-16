package com.github.xavierdpt.jvmspect.input.attributes.bm;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class BootstrapMethodsAttributeInfo extends AttributeInfo {
    private final BootstrapMethod[] bootstrapMethods;

    public BootstrapMethodsAttributeInfo(BootstrapMethod[] bootstrapMethods) {
        this.bootstrapMethods = bootstrapMethods;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (BootstrapMethod bootstrapMethod : bootstrapMethods) {
            result.appendChild(bootstrapMethod.toXML(document, constantResolver));
        }
    }

    public BootstrapMethod getBoostrapMethod(int index) {
        return bootstrapMethods[index];
    }
}

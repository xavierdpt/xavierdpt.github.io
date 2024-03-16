package com.github.xavierdpt.jvmspect.input.attributes.lvt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class LocalVariableTableAttributeInfo extends AttributeInfo {
    private final LocalVariable[] localVariables;

    public LocalVariableTableAttributeInfo(LocalVariable[] localVariables) {
        this.localVariables = localVariables;
    }


    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (LocalVariable localVariable : localVariables) {
            result.appendChild(localVariable.toXML(document, constantResolver));
        }
    }
}

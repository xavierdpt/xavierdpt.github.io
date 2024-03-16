package com.github.xavierdpt.jvmspect.input.attributes.lvtt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class LocalVariableTypeTableAttributeInfo extends AttributeInfo {
    private final LocalVariableType[] localVariableTypes;

    public LocalVariableTypeTableAttributeInfo(LocalVariableType[] localVariableTypes) {
        this.localVariableTypes = localVariableTypes;
    }

    public LocalVariableType[] localVariableTypes() {
        return localVariableTypes;
    }


    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (LocalVariableType localVariableType : localVariableTypes) {
            result.appendChild(localVariableType.toXML(document, constantResolver));
        }
    }
}

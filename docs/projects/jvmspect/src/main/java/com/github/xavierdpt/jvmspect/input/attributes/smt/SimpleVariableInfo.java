package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SimpleVariableInfo extends VerificationTypeInfo {
    private final SimpleVariableInfoType type;

    public SimpleVariableInfo(SimpleVariableInfoType type) {
        this.type = type;
    }

    @Override
    protected String getTypeName() {
        return type.name();
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {

    }
}

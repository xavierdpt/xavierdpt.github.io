package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ObjectVariableInfo extends VerificationTypeInfo {

    private final int constantIndex;

    public ObjectVariableInfo(int constantIndex) {
        this.constantIndex = constantIndex;
    }

    @Override
    protected String getTypeName() {
        return "OBJECT";
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolve(constantIndex).toXMLRef(document, constantResolver));
    }
}

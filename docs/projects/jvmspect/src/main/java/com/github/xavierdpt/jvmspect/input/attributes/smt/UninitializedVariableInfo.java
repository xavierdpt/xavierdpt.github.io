package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class UninitializedVariableInfo extends VerificationTypeInfo {
    private final int offset;

    public UninitializedVariableInfo(int offset) {
        this.offset = offset;
    }

    @Override
    protected String getTypeName() {
        return "UNINITIALIZED";
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("offset", String.valueOf(offset));
    }
}

package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class VerificationTypeInfo {

    public final Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("verificationType");
        result.setAttribute("type", getTypeName ());
        fillXML(document, result, constantResolver);
        return result;
    }

    protected abstract String getTypeName();

    protected abstract void fillXML(Document document, Element result, ConstantResolver constantResolver);
}

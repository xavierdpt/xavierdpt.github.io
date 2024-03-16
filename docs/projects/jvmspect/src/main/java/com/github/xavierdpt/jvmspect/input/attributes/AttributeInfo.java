package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class AttributeInfo {

    private String attributeName;

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    final public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("attribute");
        result.setAttribute("type", attributeName);
        fillXML(document, result, constantResolver);
        return result;
    }

    protected abstract void fillXML(Document document, Element result, ConstantResolver constantResolver);
}

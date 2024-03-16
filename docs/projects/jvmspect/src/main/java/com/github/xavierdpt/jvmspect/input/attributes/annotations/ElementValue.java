package com.github.xavierdpt.jvmspect.input.attributes.annotations;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public abstract class ElementValue {

    protected abstract String getTypeXX();

    public final Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("elementValue");
        result.setAttribute("type", getTypeXX());
        fillXML(document, result, constantResolver);
        return result;
    }

    protected abstract void fillXML(Document document, Element result, ConstantResolver constantResolver);

    @Deprecated
    protected Element createBaseXMLElement(Document document, String type) {
        Element result = document.createElement("elementValue");
        result.setAttribute("type", type);
        return result;
    }
}

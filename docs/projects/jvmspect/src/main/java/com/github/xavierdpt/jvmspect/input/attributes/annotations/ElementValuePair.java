package com.github.xavierdpt.jvmspect.input.attributes.annotations;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class ElementValuePair {
    private final int nameIndex;
    private final ElementValue elementValue;

    public ElementValuePair(int nameIndex, ElementValue elementValue) {

        this.nameIndex = nameIndex;
        this.elementValue = elementValue;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public ElementValue getElementValue() {
        return elementValue;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("elementValuePair");
        result.setAttribute("nameIndex", String.valueOf(nameIndex));
        result.appendChild(elementValue.toXML(document, constantResolver));
        return result;
    }
}

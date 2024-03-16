package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.ElementValue;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EnumElementValue extends ElementValue {
    private final int typeNameIndex;
    private final int constNameIndex;

    public EnumElementValue(int typeNameIndex, int constNameIndex) {
        this.typeNameIndex = typeNameIndex;
        this.constNameIndex = constNameIndex;
    }

    @Override
    protected String getTypeXX() {
        return "enum";
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "name", constantResolver, constNameIndex);
        XML.constantAttribute(document, result, "type", constantResolver, typeNameIndex);
    }
}

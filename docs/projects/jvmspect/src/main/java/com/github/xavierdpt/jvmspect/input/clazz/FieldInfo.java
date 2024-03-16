package com.github.xavierdpt.jvmspect.input.clazz;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.flags.FieldAccessFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class FieldInfo {
    private final FieldAccessFlags accessFlags;
    private final int nameIndex;
    private final int descriptorIndex;
    private final AttributeInfo[] attributes;

    public FieldInfo(FieldAccessFlags accessFlags, int nameIndex, int descriptorIndex, AttributeInfo[] attributes) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributes = attributes;
    }

    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("field");
        result.appendChild(accessFlags.toXML(document));
        XML.constantAttribute(document, result, "name", constantResolver, nameIndex);
        XML.constantAttribute(document, result, "descriptorIndex", constantResolver, descriptorIndex);
        Element attributesXML = XML.createChild(document, result, "attributes");
        for (AttributeInfo attributeInfo : attributes) {
            attributesXML.appendChild(attributeInfo.toXML(document, constantResolver));
        }
        return result;
    }


}

package com.github.xavierdpt.jvmspect.input.clazz;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.flags.MethodAccessFlags;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class MethodInfo {

    private final MethodAccessFlags accessFlags;
    private final int nameIndex;
    private final int descriptorIndex;
    private final AttributeInfo[] attributeInfos;

    public MethodInfo(MethodAccessFlags accessFlags, int nameIndex, int descriptorIndex, AttributeInfo[] attributeInfos) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributeInfos = attributeInfos;
    }

    public Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("method");
        XML.constantAttribute(document, result, "name", constantResolver, nameIndex);
        XML.constantAttribute(document, result, "descripor", constantResolver, descriptorIndex);
        result.appendChild(accessFlags.toXML(document));


        Element attributes = document.createElement("attributes");
        for (AttributeInfo attributeInfo : attributeInfos) {
            attributes.appendChild(attributeInfo.toXML(document, constantResolver));
        }
        result.appendChild(attributes);
        return result;
    }

}

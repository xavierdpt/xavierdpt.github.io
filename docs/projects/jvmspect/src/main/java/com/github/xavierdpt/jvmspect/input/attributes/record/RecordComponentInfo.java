package com.github.xavierdpt.jvmspect.input.attributes.record;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RecordComponentInfo {
    private final int nameIndex;
    private final int descriptorIndex;
    private final AttributeInfo[] attributeInfos;

    public RecordComponentInfo(int nameIndex, int descriptorIndex, AttributeInfo[] attributeInfos) {
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributeInfos = attributeInfos;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public Node toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("recordComponentInfo");
        result.setAttribute("nameIndex", constantResolver.resolveString(nameIndex));
        result.setAttribute("descriptorIndex", constantResolver.resolveString(descriptorIndex));
        for (AttributeInfo attributeInfo : attributeInfos) {
            result.appendChild(attributeInfo.toXML(document, constantResolver));
        }
        return result;
    }
}

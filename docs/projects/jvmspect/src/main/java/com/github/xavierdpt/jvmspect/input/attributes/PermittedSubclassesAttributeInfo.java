package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PermittedSubclassesAttributeInfo extends AttributeInfo {
    private final int[] classIndexes;

    public PermittedSubclassesAttributeInfo(int[] classIndexes) {
        this.classIndexes = classIndexes;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (int classIndex : classIndexes) {
            result.appendChild(constantResolver.resolve(classIndex).toXMLRef(document, constantResolver));
        }
    }
}

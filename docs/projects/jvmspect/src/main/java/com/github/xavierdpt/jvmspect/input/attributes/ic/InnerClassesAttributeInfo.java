package com.github.xavierdpt.jvmspect.input.attributes.ic;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class InnerClassesAttributeInfo extends AttributeInfo {
    private final InnerClass[] innerClasses;

    public InnerClassesAttributeInfo(InnerClass[] innerClasses) {
        this.innerClasses = innerClasses;
    }

    public InnerClass[] innerClasses() {
        return innerClasses;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (InnerClass innerClass : innerClasses) {
            result.appendChild(innerClass.toXML(document, constantResolver));
        }
    }

}

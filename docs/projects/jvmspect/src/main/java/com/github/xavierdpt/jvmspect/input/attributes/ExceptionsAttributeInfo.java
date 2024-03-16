package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExceptionsAttributeInfo extends AttributeInfo {
    private final int[] exceptionIndexes;

    public ExceptionsAttributeInfo(int[] exceptionIndexes) {
        this.exceptionIndexes = exceptionIndexes;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        for (int exceptionIndex : exceptionIndexes) {
            result.appendChild(constantResolver.resolve(exceptionIndex).toXMLRef(document, constantResolver));
        }
    }
}

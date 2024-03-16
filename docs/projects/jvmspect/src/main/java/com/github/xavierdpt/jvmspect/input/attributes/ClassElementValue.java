package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.ElementValue;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ClassElementValue extends ElementValue {
    private final int classInfoIndex;

    public ClassElementValue(int classInfoIndex) {
        this.classInfoIndex = classInfoIndex;
    }

    @Override
    protected String getTypeXX() {
        return "class";
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolve(classInfoIndex).toXMLRef(document, constantResolver));
    }
}

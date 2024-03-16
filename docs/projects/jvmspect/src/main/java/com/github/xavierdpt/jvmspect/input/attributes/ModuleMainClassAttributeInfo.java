package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ModuleMainClassAttributeInfo extends AttributeInfo {
    private final int mainClassIndex;

    public ModuleMainClassAttributeInfo(int mainClassIndex) {
        this.mainClassIndex = mainClassIndex;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolve(mainClassIndex).toXMLRef(document, constantResolver));
    }
}

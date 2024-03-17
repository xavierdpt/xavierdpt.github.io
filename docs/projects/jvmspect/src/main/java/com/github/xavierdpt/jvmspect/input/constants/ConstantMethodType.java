package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantMethodType extends Constant {

    private final int descriptorIndex;

    public ConstantMethodType(int descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }

    @Override
    protected String getTypeName() {
        return "MethodType";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("descriptorIndex", String.valueOf(descriptorIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "descriptor", constantResolver, descriptorIndex);
    }

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        String descriptor = constantResolver.resolve(descriptorIndex).toTextDetails(constantResolver);
        return getTypeName() + "(" + descriptor + ")";
    }

}

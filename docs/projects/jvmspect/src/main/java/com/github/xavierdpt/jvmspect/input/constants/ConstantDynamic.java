package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantDynamic extends Constant {

    private final int boostrapMethodAttrIndex;
    private final int nameAndTypeIndex;

    public ConstantDynamic(int boostrapMethodAttrIndex, int nameAndTypeIndex) {
        this.boostrapMethodAttrIndex = boostrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    protected String getTypeName() {
        return "Dynamic";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("boostrapMethodAttrIndex", String.valueOf(boostrapMethodAttrIndex));
        result.setAttribute("nameAndTypeIndex", String.valueOf(nameAndTypeIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "boostrapMethodAttrIndex", constantResolver, boostrapMethodAttrIndex);
        XML.constantAttribute(document, result, "nameAndTypeIndex", constantResolver, nameAndTypeIndex);
    }

}

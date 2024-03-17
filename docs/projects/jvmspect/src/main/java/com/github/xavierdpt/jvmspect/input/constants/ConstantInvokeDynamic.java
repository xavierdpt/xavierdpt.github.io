package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantInvokeDynamic extends Constant {

    private final int boostrapMethodAttrIndex;
    private final int nameAndTypeIndex;

    public ConstantInvokeDynamic(int boostrapMethodAttrIndex, int nameAndTypeIndex) {
        this.boostrapMethodAttrIndex = boostrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    protected String getTypeName() {
        return "InvokeDynamic";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("boostrapMethodAttrIndex", String.valueOf(boostrapMethodAttrIndex));
        result.setAttribute("nameAndTypeIndex", String.valueOf(nameAndTypeIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolveBoostrapMethod(boostrapMethodAttrIndex).toXML(document, constantResolver));
        result.appendChild(constantResolver.resolve(nameAndTypeIndex).toXMLRef(document, constantResolver));
    }

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        String bootstrapMethod = constantResolver.resolveBoostrapMethod(boostrapMethodAttrIndex).toTextDetails(constantResolver);
        String nameAndType = constantResolver.resolve(nameAndTypeIndex).toTextDetails(constantResolver);
        return getTypeName() + "(" + bootstrapMethod + "," + nameAndType + ")";
    }

}

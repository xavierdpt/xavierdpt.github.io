package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantInterfaceMethodRef extends Constant {

    private final int classIndex;
    private final int nameAndTypeIndex;

    public ConstantInterfaceMethodRef(int classIndex, int nameAndTypeIndex) {
        this.classIndex = classIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    @Override
    protected String getTypeName() {
        return "InterfaceMethodRef";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("classIndex", String.valueOf(classIndex));
        result.setAttribute("nameAndTypeIndex", String.valueOf(nameAndTypeIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "classIndex", constantResolver, classIndex);
        XML.constantAttribute(document, result, "nameAndTypeIndex", constantResolver, nameAndTypeIndex);
    }

}

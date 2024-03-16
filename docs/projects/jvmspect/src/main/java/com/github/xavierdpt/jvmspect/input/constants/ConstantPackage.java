package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantPackage extends Constant {

    private final int nameIndex;

    public ConstantPackage(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    @Override
    protected String getTypeName() {
        return "Package";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("nameIndex", String.valueOf(nameIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "name", constantResolver, nameIndex);
    }

}

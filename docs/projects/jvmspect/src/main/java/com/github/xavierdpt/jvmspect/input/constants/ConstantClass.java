package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantClass extends Constant {

    private final int nameIndex;

    public ConstantClass(int nameIndex) {
        this.nameIndex = nameIndex;
    }

    public int getNameIndex() {
        return nameIndex;
    }

    @Override
    protected String getTypeName() {
        return "Class";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("nameIndex", String.valueOf(nameIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantAttribute(document, result, "name", constantResolver, nameIndex);
    }

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        String text = constantResolver.resolve(nameIndex).toTextDetails(constantResolver);
        return getTypeName() + "(" + text + ")";
    }


}

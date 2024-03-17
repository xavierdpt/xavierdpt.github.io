package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantString extends Constant {

    private final int stringIndex;

    public ConstantString(int stringIndex) {
        this.stringIndex = stringIndex;
    }

    public int stringIndex() {
        return stringIndex;
    }

    @Override
    protected String getTypeName() {
        return "String";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("stringIndex", String.valueOf(stringIndex));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(document.createTextNode(constantResolver.resolveString(stringIndex)));
    }

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        String string = constantResolver.resolve(stringIndex).toTextDetails(constantResolver);
        return getTypeName() + "(" + string + ")";
    }

}

package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantInteger extends Constant {

    private final int value;

    public ConstantInteger(int value) {
        this.value = value;
    }

    @Override
    protected String getTypeName() {
        return "Integer";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("value", String.valueOf(value));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("value", String.valueOf(value));
    }


}

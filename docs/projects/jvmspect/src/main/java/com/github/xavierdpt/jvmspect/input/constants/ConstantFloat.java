package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantFloat extends Constant {
    private final float value;

    public ConstantFloat(float value) {
        this.value = value;
    }

    @Override
    protected String getTypeName() {
        return "Float";
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

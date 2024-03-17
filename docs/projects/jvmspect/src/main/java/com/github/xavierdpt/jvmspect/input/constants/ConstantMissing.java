package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ConstantMissing extends Constant {

    private final int index;

    public ConstantMissing(int index) {
        this.index = index;
    }

    @Override
    protected String getTypeName() {
        return "missing";
    }

    @Override
    protected void fillXml(Document document, Element result) {
        result.setAttribute("index", String.valueOf(index));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("index", String.valueOf(index));
    }

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        return "?(" + index + ")";
    }
}

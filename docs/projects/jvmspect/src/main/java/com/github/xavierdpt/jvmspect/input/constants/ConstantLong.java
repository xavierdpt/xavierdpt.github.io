package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantLong extends Constant {

    private final long value;

    public ConstantLong(long value) {
        this.value = value;
    }

    @Override
    public int getNEntries() {
        return 2;
    }

    @Override
    protected String getTypeName() {
        return "Long";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("value", String.valueOf(value));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        result.setAttribute("value", String.valueOf(value));
    }

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        return getTypeName() + "(" + value + ")";
    }

}

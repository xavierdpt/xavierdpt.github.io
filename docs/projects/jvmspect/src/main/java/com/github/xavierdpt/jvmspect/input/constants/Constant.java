package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class Constant {

    public int getNEntries() {
        return 1;
    }

    protected abstract String getTypeName();

    public final Element toXML(Document document, int constantIndex) {
        Element constant = document.createElement("constant");
        constant.setAttribute("index", String.valueOf(constantIndex));
        constant.setAttribute("type", getTypeName());
        fillXml(document, constant);
        return constant;
    }

    protected abstract void fillXml(Document document, Element constant);

    public final Element toXMLRef(Document document, ConstantResolver constantResolver) {
        Element constant = document.createElement("constant");
        constant.setAttribute("type", getTypeName());
        fillXmlRef(document, constant, constantResolver);
        return constant;
    }

    protected abstract void fillXmlRef(Document document, Element result, ConstantResolver constantResolver);

}

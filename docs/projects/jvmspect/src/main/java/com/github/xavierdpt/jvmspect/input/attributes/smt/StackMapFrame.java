package com.github.xavierdpt.jvmspect.input.attributes.smt;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class StackMapFrame {
    protected abstract String getFrameType();

    public final Element toXML(Document document, ConstantResolver constantResolver) {
        Element result = document.createElement("stackMapFrame");
        result.setAttribute("type", getFrameType());
        fillXml(document,result,constantResolver);
        return result;
    }

    protected abstract void fillXml(Document document, Element result, ConstantResolver constantResolver);
}

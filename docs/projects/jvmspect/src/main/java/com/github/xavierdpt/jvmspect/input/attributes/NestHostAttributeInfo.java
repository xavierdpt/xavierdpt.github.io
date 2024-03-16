package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class NestHostAttributeInfo extends AttributeInfo {
    private final int hostClassIndex;

    public NestHostAttributeInfo(int hostClassIndex) {
        this.hostClassIndex = hostClassIndex;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(constantResolver.resolve(hostClassIndex).toXMLRef(document, constantResolver));
        XML.constantText(document, result, "hostClass", constantResolver, hostClassIndex);
    }


}

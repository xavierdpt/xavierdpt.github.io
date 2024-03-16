package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class SignatureAttributeInfo extends AttributeInfo {
    private final int signatureIndex;

    public SignatureAttributeInfo(int signatureIndex) {
        this.signatureIndex = signatureIndex;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        XML.constantText(document, result, "signature", constantResolver, signatureIndex);
    }


}

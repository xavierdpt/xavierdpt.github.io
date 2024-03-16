package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.constants.StringUtils;
import com.github.xavierdpt.jvmspect.utils.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class RawAttributeInfo extends AttributeInfo {
    private final byte[] bytes;

    public RawAttributeInfo(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    protected void fillXML(Document document, Element result, ConstantResolver constantResolver) {
        StringBuilder hexSb = new StringBuilder();
        for (byte b : bytes) {
            hexSb.append(Integer.toHexString(Byte.toUnsignedInt(b)));
        }
        XML.createChild(document, result, "hex", hexSb.toString().toUpperCase());
        XML.createChild(document, result, "ascii", StringUtils.magic(bytes));
    }


}

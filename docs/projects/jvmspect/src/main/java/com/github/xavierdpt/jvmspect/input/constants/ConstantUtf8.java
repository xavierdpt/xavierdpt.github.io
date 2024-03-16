package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public final class ConstantUtf8 extends Constant {
    private final byte[] bytes;

    public ConstantUtf8(byte[] bytes) {
        this.bytes = bytes;
    }

    private String utf8String;

    @Override
    protected String getTypeName() {
        return "Utf8";
    }

    @Override
    public void fillXml(Document document, Element result) {
        result.setAttribute("length", String.valueOf(bytes.length));
        result.appendChild(document.createTextNode(getUTF8String()));
    }

    @Override
    protected void fillXmlRef(Document document, Element result, ConstantResolver constantResolver) {
        result.appendChild(document.createTextNode(getUTF8String()));
    }

    public String getUTF8String() {
        if (utf8String == null) {
            utf8String = StringUtils.magic(bytes);
        }
        return utf8String;
    }

}

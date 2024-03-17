package com.github.xavierdpt.jvmspect.input.constants;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.owasp.encoder.Encode;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.nio.charset.StandardCharsets;

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

    @Override
    public String toTextDetails(ConstantResolver constantResolver) {
        String encoded = Encode.forJava(new String(bytes, StandardCharsets.UTF_8));
        return getTypeName() + "(\"" + encoded + "\")";
    }

    public String getUTF8String() {
        // FIXME: Better use OWASP Encode ?
        if (utf8String == null) {
            utf8String = StringUtils.magic(bytes);
        }
        return utf8String;
    }

    public String getJavaString() {
        return Encode.forJava(new String(bytes, StandardCharsets.UTF_8));
    }
}

package xd.jvmspect.constants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import xd.jvmspect.ConstantResolver;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

public final class ConstantUtf8 implements ConstantObject {
    private final byte[] bytes;

    public ConstantUtf8(byte[] bytes) {
        this.bytes = bytes;
    }

    private String utf8String;

    @Override
    public void customizeXML(Document document, Element constant, ConstantResolver constantResolver) {
        constant.setAttribute("length", String.valueOf(bytes.length));
        String string = StringUtils.toXMLTextNodeContent(bytes);
        constant.appendChild(document.createTextNode(string));
    }

    public String getUTF8String() {
        if (utf8String == null) {
            utf8String = new String(bytes, StandardCharsets.UTF_8);
        }
        return utf8String;
    }

    public byte[] bytes() {
        return bytes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ConstantUtf8) obj;
        return Objects.equals(this.bytes, that.bytes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bytes);
    }

    @Override
    public String toString() {
        return "ConstantUtf8[" +
                "bytes=" + bytes + ']';
    }

}

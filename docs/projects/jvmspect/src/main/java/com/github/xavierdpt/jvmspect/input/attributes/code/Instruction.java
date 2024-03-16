package com.github.xavierdpt.jvmspect.input.attributes.code;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class Instruction {
    public abstract Element toXML(Document document, ConstantResolver constantResolver);

    public int toUnsignedInt(byte[] bytes, int offset, int count) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result <<= 8;
            result |= Byte.toUnsignedInt(bytes[offset + i]);
        }
        return result;
    }

    public int toSignedInt(byte[] bytes, int offset, int count) {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result <<= 8;
            if (i == 0) {
                result = bytes[offset + i];
            } else {
                result |= Byte.toUnsignedInt(bytes[offset + i]);
            }
        }
        return result;
    }
}

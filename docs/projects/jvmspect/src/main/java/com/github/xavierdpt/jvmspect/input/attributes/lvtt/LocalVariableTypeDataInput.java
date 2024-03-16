package com.github.xavierdpt.jvmspect.input.attributes.lvtt;

import java.io.DataInputStream;
import java.io.IOException;

public class LocalVariableTypeDataInput {
    public static LocalVariableType parse(DataInputStream dis) throws IOException {
        int startPc = dis.readUnsignedShort();
        int length = dis.readUnsignedShort();
        int nameIndex = dis.readUnsignedShort();
        int signatureIndex = dis.readUnsignedShort();
        int index = dis.readUnsignedShort();
        return new LocalVariableType(startPc, length, nameIndex, signatureIndex, index);
    }
}

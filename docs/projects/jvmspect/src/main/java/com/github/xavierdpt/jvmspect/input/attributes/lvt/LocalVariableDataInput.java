package com.github.xavierdpt.jvmspect.input.attributes.lvt;

import java.io.DataInputStream;
import java.io.IOException;

public class LocalVariableDataInput {
    public static LocalVariable read(DataInputStream dis) throws IOException {
        int codeOffset = dis.readUnsignedShort();
        int length = dis.readUnsignedShort();
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        int index = dis.readUnsignedShort();
        return new LocalVariable(codeOffset, length, nameIndex, descriptorIndex, index);
    }
}

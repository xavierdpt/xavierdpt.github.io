package com.github.xavierdpt.jvmspect.input.attributes.smt;

import java.io.DataInputStream;
import java.io.IOException;

public class VerificationTypeInfoDataInput {
    public static VerificationTypeInfo read(DataInputStream dis) throws IOException {
        int tag = dis.readUnsignedByte();
        switch (tag) {
            case 0, 1, 2, 3, 4, 5, 6 -> {
                return new SimpleVariableInfo(SimpleVariableInfoType.ofTag(tag));
            }
            case 7 -> {
                int index = dis.readUnsignedShort();
                return new ObjectVariableInfo(index);
            }
            case 8 -> {
                int offset = dis.readUnsignedShort();
                return new UninitializedVariableInfo(offset);
            }
            default -> throw new IllegalStateException("Unexpected verification type info tag: " + tag);
        }
    }

}

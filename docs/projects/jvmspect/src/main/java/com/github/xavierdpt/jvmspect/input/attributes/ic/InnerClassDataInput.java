package com.github.xavierdpt.jvmspect.input.attributes.ic;

import com.github.xavierdpt.jvmspect.input.clazz.AccessFlagsDataInput;
import com.github.xavierdpt.jvmspect.input.flags.InnerClassAccessFlags;

import java.io.DataInputStream;
import java.io.IOException;

public class InnerClassDataInput {
    public static InnerClass read(DataInputStream dis) throws IOException {
        int innerClassInfoIndex = dis.readUnsignedShort();
        int outerClassInfoIndex = dis.readUnsignedShort();
        int innerNameIndex = dis.readUnsignedShort();
        InnerClassAccessFlags accessFlags = AccessFlagsDataInput.readInnerClassFlags(dis);
        return new InnerClass(innerClassInfoIndex, outerClassInfoIndex, innerNameIndex, accessFlags);
    }
}

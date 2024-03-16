package com.github.xavierdpt.jvmspect.input.clazz;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.flags.MethodAccessFlags;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodInfoDataInput {
    public static MethodInfo read(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        MethodAccessFlags accessFlags = AccessFlagsDataInput.readMethodFlags(dis);
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        AttributeInfo[] attributes = ClassInfoDataInput.readAttributes(dis, constantResolver);
        return new MethodInfo(accessFlags, nameIndex, descriptorIndex, attributes);
    }
}

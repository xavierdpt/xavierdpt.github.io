package com.github.xavierdpt.jvmspect.input.attributes.mp;

import com.github.xavierdpt.jvmspect.input.clazz.AccessFlagsDataInput;
import com.github.xavierdpt.jvmspect.input.flags.MethodParameterAccessFlags;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodParameterDataInput {
    public static MethodParameter read(DataInputStream dis) throws IOException {
        int nameIndex = dis.readUnsignedShort();
        MethodParameterAccessFlags accessFlags = AccessFlagsDataInput.readMethodParameterFlags(dis);
        return new MethodParameter(nameIndex, accessFlags);
    }
}

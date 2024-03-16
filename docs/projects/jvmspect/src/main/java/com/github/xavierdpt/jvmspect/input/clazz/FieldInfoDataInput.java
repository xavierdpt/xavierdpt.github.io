package com.github.xavierdpt.jvmspect.input.clazz;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.flags.FieldAccessFlags;

import java.io.DataInputStream;
import java.io.IOException;

public class FieldInfoDataInput {
    public static FieldInfo read(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        FieldAccessFlags accessFlags = AccessFlagsDataInput.readFieldFlags(dis);
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        AttributeInfo[] attributeInfos = ClassInfoDataInput.readAttributes(dis, constantResolver);
        return new FieldInfo(accessFlags, nameIndex, descriptorIndex, attributeInfos);
    }
}

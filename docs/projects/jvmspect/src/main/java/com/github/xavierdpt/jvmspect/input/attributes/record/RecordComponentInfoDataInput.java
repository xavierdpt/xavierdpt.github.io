package com.github.xavierdpt.jvmspect.input.attributes.record;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfoDataInput;

import java.io.DataInputStream;
import java.io.IOException;

public class RecordComponentInfoDataInput {
    public static RecordComponentInfo read(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        int attributesCount = dis.readUnsignedShort();
        AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributeInfos[i] = AttributeInfoDataInput.readAttribute(dis, constantResolver);
        }
        return new RecordComponentInfo(nameIndex, descriptorIndex, attributeInfos);
    }
}

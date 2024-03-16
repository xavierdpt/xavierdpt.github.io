package com.github.xavierdpt.jvmspect.input.attributes.annotations;

import java.io.DataInputStream;
import java.io.IOException;

public class AnnotationInfoDataInput {
    public static AnnotationInfo readAnnotationInfo(DataInputStream dis) throws IOException {
        int typeIndex = dis.readUnsignedShort();
        int count = dis.readUnsignedShort();
        ElementValuePair[] elementValuePairs = new ElementValuePair[count];
        for (int i = 0; i < count; i++) {
            elementValuePairs[i] = readElementValuePair(dis);
        }
        return new AnnotationInfo(typeIndex, elementValuePairs);

    }

    public static ElementValuePair readElementValuePair(DataInputStream dis) throws IOException {
        int nameIndex = dis.readUnsignedShort();
        ElementValue parse = ElementValueDataInput.read(dis);
        return new ElementValuePair(nameIndex, parse);
    }
}

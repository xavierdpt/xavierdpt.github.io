package com.github.xavierdpt.jvmspect.input.attributes.annotations;

import com.github.xavierdpt.jvmspect.input.attributes.AnnotationElementValue;
import com.github.xavierdpt.jvmspect.input.attributes.ArrayElementValue;
import com.github.xavierdpt.jvmspect.input.attributes.ClassElementValue;
import com.github.xavierdpt.jvmspect.input.attributes.EnumElementValue;
import com.github.xavierdpt.jvmspect.input.attributes.SimpleElementValue;

import java.io.DataInputStream;
import java.io.IOException;

public class ElementValueDataInput {
    public static ElementValue read(DataInputStream dis) throws IOException {
        int tag = dis.readUnsignedByte();
        switch (tag) {
            case 'B', 'C', 'D', 'F', 'I', 'J', 'S', 'Z', 's' -> {
                int constValueIndex = dis.readUnsignedShort();
                return new SimpleElementValue(constValueIndex);
            }
            case 'e' -> {
                int typeNameIndex = dis.readUnsignedShort();
                int constNameIndex = dis.readUnsignedShort();
                return new EnumElementValue(typeNameIndex, constNameIndex);
            }
            case 'c' -> {
                int classInfoIndex = dis.readUnsignedShort();
                return new ClassElementValue(classInfoIndex);
            }
            case '@' -> {
                AnnotationInfo annotation = AnnotationInfoDataInput.readAnnotationInfo(dis);
                return new AnnotationElementValue(annotation);
            }
            case '[' -> {
                int count = dis.readUnsignedShort();
                ElementValue[] elementValues = new ElementValue[count];
                for (int i = 0; i < count; i++) {
                    elementValues[i] = read(dis);
                }
                return new ArrayElementValue(elementValues);
            }
            default -> throw new IllegalStateException("Unexpected value: " + tag);
        }
    }

}

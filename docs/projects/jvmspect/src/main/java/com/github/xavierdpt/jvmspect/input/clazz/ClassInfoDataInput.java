package com.github.xavierdpt.jvmspect.input.clazz;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.AttributeInfoDataInput;
import com.github.xavierdpt.jvmspect.input.constants.Constant;
import com.github.xavierdpt.jvmspect.input.constants.ConstantDataInput;
import com.github.xavierdpt.jvmspect.input.flags.ClassAccessFlags;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassInfoDataInput {

    public static ClassInfo read(DataInputStream dis) throws IOException {
        int minorVersion = dis.readUnsignedShort();
        int majorVersion = dis.readUnsignedShort();
        Constant[] constantObjects = readConstantPool(dis);
        ConstantResolver constantResolver = new ConstantResolver(constantObjects);
        ClassAccessFlags accessFlags = AccessFlagsDataInput.readClassFlags(dis);
        int thisClassIndex = dis.readUnsignedShort();
        int superClassIndex = dis.readUnsignedShort();
        int[] interfaceIndexes = readInterfaces(dis);
        FieldInfo[] fieldInfos = readFields(dis, constantResolver);
        MethodInfo[] methodInfos = readMethodInfos(dis, constantResolver);
        AttributeInfo[] attributeInfos = readAttributes(dis, constantResolver);
        constantResolver.setBoostrapMethods(attributeInfos);
        return new ClassInfo(
                minorVersion, majorVersion,
                constantObjects, constantResolver,
                accessFlags,
                thisClassIndex, superClassIndex,
                interfaceIndexes, fieldInfos, methodInfos, attributeInfos
        );
    }

    public static Constant[] readConstantPool(DataInputStream dis) throws IOException {
        int constantPoolCount = dis.readUnsignedShort() - 1;
        Constant[] constantObjects = new Constant[constantPoolCount];
        int i = 0;
        while (i < constantPoolCount) {
            Constant nextObject = ConstantDataInput.read(dis);
            constantObjects[i] = nextObject;
            i += nextObject.getNEntries();
        }
        return constantObjects;
    }

    public static int[] readInterfaces(DataInputStream dis) throws IOException {
        int interfacesCount = dis.readUnsignedShort();
        int[] result = new int[interfacesCount];
        for (int i = 0; i < interfacesCount; i++) {
            result[i] = dis.readUnsignedShort();
        }
        return result;
    }

    public static FieldInfo[] readFields(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        int fieldsCount = dis.readUnsignedShort();
        FieldInfo[] fieldInfos = new FieldInfo[fieldsCount];
        for (int i = 0; i < fieldsCount; i++) {
            fieldInfos[i] = FieldInfoDataInput.read(dis, constantResolver);
        }
        return fieldInfos;
    }

    public static MethodInfo[] readMethodInfos(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        int methodCount = dis.readUnsignedShort();
        MethodInfo[] methodInfos = new MethodInfo[methodCount];
        for (int i = 0; i < methodCount; i++) {
            methodInfos[i] = MethodInfoDataInput.read(dis, constantResolver);
        }
        return methodInfos;
    }

    public static AttributeInfo[] readAttributes(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        int attributeCount = dis.readUnsignedShort();
        AttributeInfo[] attributes = new AttributeInfo[attributeCount];
        for (int i = 0; i < attributeCount; i++) {
            AttributeInfo attribute = AttributeInfoDataInput.readAttribute(dis, constantResolver);
            attributes[i] = attribute;
        }
        return attributes;
    }
}

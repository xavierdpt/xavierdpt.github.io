package com.github.xavierdpt.jvmspect.input.constants;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class ConstantDataInput {

    public static Constant[] readAll(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        int count = dis.readUnsignedShort();
        Constant[] constants = new Constant[count];
        for (int i = 0; i < count; i++) {
            constants[i] = ConstantDataInput.read(dis);
        }
        return constants;
    }

    public static Constant[] readAll(byte[] bytes, int count) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        Constant[] constants = new Constant[count];
        for (int i = 0; i < count; i++) {
            try {
                constants[i] = ConstantDataInput.read(dis);
            } catch (EOFException e) {
                constants[i] = new ConstantMissing(i);
            }
        }
        return constants;
    }

    public static Constant read(DataInputStream dis) throws IOException {
        int tag = dis.readUnsignedByte();
        return switch (tag) {
            case 7 -> readConstant(dis);
            case 9 -> readConstantFieldRef(dis);
            case 10 -> readConstantMethodRef(dis);
            case 11 -> readConstantInterfaceMethodRef(dis);
            case 8 -> readConstantString(dis);
            case 3 -> readConstantInteger(dis);
            case 4 -> readConstantFloat(dis);
            case 5 -> readConstantLong(dis);
            case 6 -> readConstantDouble(dis);
            case 12 -> readConstantNameAndType(dis);
            case 1 -> readConstantUtf8(dis);
            case 15 -> readConstantMethodHandle(dis);
            case 16 -> readConstantMethodType(dis);
            case 17 -> readConstantDynamic(dis);
            case 18 -> readConstantInvokeDynamic(dis);
            case 19 -> readConstantModule(dis);
            case 20 -> readConstantPackage(dis);
            default -> throw new IllegalStateException("Unexpected value for constant pool tag: " + tag);
        };
    }

    public static ConstantClass readConstant(DataInputStream dis) throws IOException {
        int nameIndex = dis.readUnsignedShort();
        return new ConstantClass(nameIndex);
    }

    public static ConstantFieldRef readConstantFieldRef(DataInputStream dis) throws IOException {
        int classIndex = dis.readUnsignedShort();
        int nameAndTypeIndex = dis.readUnsignedShort();
        return new ConstantFieldRef(classIndex, nameAndTypeIndex);
    }

    public static ConstantMethodRef readConstantMethodRef(DataInputStream dis) throws IOException {
        int classIndex = dis.readUnsignedShort();
        int nameAndTypeIndex = dis.readUnsignedShort();
        return new ConstantMethodRef(classIndex, nameAndTypeIndex);
    }

    public static ConstantInterfaceMethodRef readConstantInterfaceMethodRef(DataInputStream dis) throws IOException {
        int classIndex = dis.readUnsignedShort();
        int nameAndTypeIndex = dis.readUnsignedShort();
        return new ConstantInterfaceMethodRef(classIndex, nameAndTypeIndex);
    }

    public static ConstantString readConstantString(DataInputStream dis) throws IOException {
        int stringIndex = dis.readUnsignedShort();
        return new ConstantString(stringIndex);
    }

    public static ConstantInteger readConstantInteger(DataInputStream dis) throws IOException {
        int value = dis.readInt();
        return new ConstantInteger(value);
    }

    public static ConstantFloat readConstantFloat(DataInputStream dis) throws IOException {
        float value = dis.readFloat();
        return new ConstantFloat(value);
    }

    public static ConstantLong readConstantLong(DataInputStream dis) throws IOException {
        long value = dis.readLong();
        return new ConstantLong(value);

    }

    public static ConstantDouble readConstantDouble(DataInputStream dis) throws IOException {
        double value = dis.readDouble();
        return new ConstantDouble(value);
    }

    public static ConstantNameAndType readConstantNameAndType(DataInputStream dis) throws IOException {
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        return new ConstantNameAndType(nameIndex, descriptorIndex);

    }

    public static ConstantUtf8 readConstantUtf8(DataInputStream dis) throws IOException {
        int length = dis.readUnsignedShort();
        byte[] bytes = dis.readNBytes(length);
        return new ConstantUtf8(bytes);
    }

    public static ConstantMethodHandle readConstantMethodHandle(DataInputStream dis) throws IOException {
        int referenceKind = dis.readUnsignedByte();
        int referenceIndex = dis.readUnsignedShort();
        return new ConstantMethodHandle(referenceKind, referenceIndex);
    }

    public static ConstantMethodType readConstantMethodType(DataInputStream dis) throws IOException {
        int descriptorIndex = dis.readUnsignedShort();
        return new ConstantMethodType(descriptorIndex);
    }

    public static ConstantDynamic readConstantDynamic(DataInputStream dis) throws IOException {
        int boostrapMethodAttrIndex = dis.readUnsignedShort();
        int nameAndTypeIndex = dis.readUnsignedShort();
        return new ConstantDynamic(boostrapMethodAttrIndex, nameAndTypeIndex);


    }

    public static ConstantInvokeDynamic readConstantInvokeDynamic(DataInputStream dis) throws IOException {
        int boostrapMethodAttrIndex = dis.readUnsignedShort();
        int nameAndTypeIndex = dis.readUnsignedShort();
        return new ConstantInvokeDynamic(boostrapMethodAttrIndex, nameAndTypeIndex);
    }

    public static ConstantModule readConstantModule(DataInputStream dis) throws IOException {
        int nameIndex = dis.readUnsignedShort();
        return new ConstantModule(nameIndex);
    }

    public static ConstantPackage readConstantPackage(DataInputStream dis) throws IOException {
        int nameIndex = dis.readUnsignedShort();
        return new ConstantPackage(nameIndex);
    }


}

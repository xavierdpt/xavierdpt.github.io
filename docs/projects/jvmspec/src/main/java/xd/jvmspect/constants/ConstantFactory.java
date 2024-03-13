package xd.jvmspect.constants;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantFactory {
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

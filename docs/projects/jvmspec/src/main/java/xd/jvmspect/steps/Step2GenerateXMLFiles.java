package xd.jvmspect.steps;

import org.w3c.dom.Document;
import xd.jvmspect.AccessFlags;
import xd.jvmspect.ClassFileVersion;
import xd.jvmspect.ClassInfo;
import xd.jvmspect.FieldInfo;
import xd.jvmspect.FileHelper;
import xd.jvmspect.MethodInfo;
import xd.jvmspect.XConstants;
import xd.jvmspect.XMLJavaFileSupplier;
import xd.jvmspect.attributes.RawAttributeInfo;
import xd.jvmspect.constants.ConstantDynamic;
import xd.jvmspect.constants.ConstantFactory;
import xd.jvmspect.constants.ConstantInvokeDynamic;
import xd.jvmspect.constants.ConstantObject;
import xd.jvmspect.constants.ConstantPackage;
import xd.jvmspect.constants.ConstantUtf8;
import xd.jvmspect.xml.XML;

import javax.xml.transform.TransformerException;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Step2GenerateXMLFiles {

    public static void main(String[] args) throws IOException, TransformerException {
        File extractDir = new File(XConstants.LOCAL_DIR, XConstants.MODULES_EXTRACTED);
        File xmlDir = new File(XConstants.LOCAL_DIR, XConstants.JAVAXML);
        FileHelper.ensureDir(xmlDir);
        FileHelper.cleanDir(xmlDir);
        XMLJavaFileSupplier xmlJavaFileNameSupplier = new XMLJavaFileSupplier(xmlDir);
        goThrough(extractDir, xmlJavaFileNameSupplier);
    }

    private static void goThrough(File file, XMLJavaFileSupplier xmlJavaFileNameSupplier) throws IOException, TransformerException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    goThrough(f, xmlJavaFileNameSupplier);
                }
            }
        } else {
            handleFile(file, xmlJavaFileNameSupplier);
        }
    }

    private static void handleFile(File file, XMLJavaFileSupplier xmlJavaFileSupplier) throws IOException, TransformerException {
        try (FileInputStream fis = new FileInputStream(file)) {
            DataInputStream dis = new DataInputStream(fis);
            if (readMagic(dis)) {
                ClassFileVersion version = readVersion(dis);
                ConstantObject[] constantObjects = readConstantPool(dis);
                AccessFlags accessFlags = readAccessFlags(dis);
                int thisClass = dis.readUnsignedShort();
                int superClass = dis.readUnsignedShort();
                int[] interfaces = readInterfaces(dis);
                FieldInfo[] fieldInfos = readFields(dis);
                MethodInfo[] methodInfos = readMethodInfos(dis);
                RawAttributeInfo[] attributeInfos = readAttributes(dis);
                ClassInfo classInfo = new ClassInfo(version, constantObjects, accessFlags, thisClass, superClass, interfaces, fieldInfos, methodInfos, attributeInfos);
                Document xml = classInfo.toXML();
                File file1 = xmlJavaFileSupplier.get();
                try (FileOutputStream fileOutputStream = new FileOutputStream(file1)) {
                    XML.writeDocument(xml, fileOutputStream);
                }
            }
        }
    }

    private static MethodInfo[] readMethodInfos(DataInputStream dis) throws IOException {
        int methodCount = dis.readUnsignedShort();
        MethodInfo[] methodInfos = new MethodInfo[methodCount];
        for (int i = 0; i < methodCount; i++) {
            methodInfos[i] = readMethodInfo(dis);
        }
        return methodInfos;
    }

    private static MethodInfo readMethodInfo(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        RawAttributeInfo[] attributeInfos = readAttributes(dis);
        return new MethodInfo(accessFlags, nameIndex, descriptorIndex, attributeInfos);
    }


    private static FieldInfo[] readFields(DataInputStream dis) throws IOException {
        int fieldsCount = dis.readUnsignedShort();
        FieldInfo[] fieldInfos = new FieldInfo[fieldsCount];
        for (int i = 0; i < fieldsCount; i++) {
            fieldInfos[i] = readField(dis);
        }
        return fieldInfos;
    }

    private static FieldInfo readField(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        int nameIndex = dis.readUnsignedShort();
        int descriptorIndex = dis.readUnsignedShort();
        RawAttributeInfo[] attributeInfos = readAttributes(dis);
        return new FieldInfo(accessFlags, nameIndex, descriptorIndex, attributeInfos);
    }

    private static RawAttributeInfo[] readAttributes(DataInputStream dis) throws IOException {
        int attributeCount = dis.readUnsignedShort();
        RawAttributeInfo[] attributes = new RawAttributeInfo[attributeCount];
        for (int i = 0; i < attributeCount; i++) {
            RawAttributeInfo attribute = readAttribute(dis);
            attributes[i] = attribute;
        }
        return attributes;
    }

    public static RawAttributeInfo readAttribute(DataInputStream dis) throws IOException {
        int attributeNameIndex = dis.readUnsignedShort();
        int attributeLength = dis.readInt();
        byte[] info = dis.readNBytes(attributeLength);
        return new RawAttributeInfo(attributeNameIndex, info);
    }

    private static int[] readInterfaces(DataInputStream dis) throws IOException {
        int interfacesCount = dis.readUnsignedShort();
        int[] result = new int[interfacesCount];
        for (int i = 0; i < interfacesCount; i++) {
            result[i] = dis.readUnsignedShort();
        }
        return result;
    }

    private static ClassFileVersion readVersion(DataInputStream dis) throws IOException {
        int minorVersion = dis.readUnsignedShort();
        int majorVersion = dis.readUnsignedShort();
        return new ClassFileVersion(majorVersion, minorVersion);
    }

    private static AccessFlags readAccessFlags(DataInputStream dis) throws IOException {
        int accessFlags = dis.readUnsignedShort();
        return new AccessFlags(accessFlags);
    }

    private static boolean readMagic(DataInputStream dis) throws IOException {
        int magic = dis.readInt();
        return 0xCAFEBABE == magic;
    }

    private static ConstantObject[] readConstantPool(DataInputStream dis) throws IOException {
        int constantPoolCount = dis.readUnsignedShort() - 1;
        ConstantObject[] constantObjects = new ConstantObject[constantPoolCount];
        int i = 0;
        while (i < constantPoolCount) {
            ConstantObject nextObject = readConstantObject(dis);
            constantObjects[i] = nextObject;
            i += nextObject.getNEntries();
        }
        return constantObjects;
    }

    private static ConstantObject readConstantObject(DataInputStream dis) throws IOException {
        int tag = dis.readUnsignedByte();
        return switch (tag) {
            case 7 -> ConstantFactory.readConstant(dis);
            case 9 -> ConstantFactory.readConstantFieldRef(dis);
            case 10 -> ConstantFactory.readConstantMethodRef(dis);
            case 11 -> ConstantFactory.readConstantInterfaceMethodRef(dis);
            case 8 -> ConstantFactory.readConstantString(dis);
            case 3 -> ConstantFactory.readConstantInteger(dis);
            case 4 -> ConstantFactory.readConstantFloat(dis);
            case 5 -> ConstantFactory.readConstantLong(dis);
            case 6 -> ConstantFactory.readConstantDouble(dis);
            case 12 -> ConstantFactory.readConstantNameAndType(dis);
            case 1 -> readConstantUtf8(dis);
            case 15 -> ConstantFactory.readConstantMethodHandle(dis);
            case 16 -> ConstantFactory.readConstantMethodType(dis);
            case 17 -> readConstantDynamic(dis);
            case 18 -> readConstantInvokeDynamic(dis);
            case 19 -> ConstantFactory.readConstantModule(dis);
            case 20 -> readConstantPackage(dis);
            default -> throw new IllegalStateException("Unexpected value for constant pool tag: " + tag);
        };
    }

    private static ConstantUtf8 readConstantUtf8(DataInputStream dis) throws IOException {
        return ConstantFactory.readConstantUtf8(dis);
    }

    private static ConstantDynamic readConstantDynamic(DataInputStream dis) throws IOException {
        return ConstantFactory.readConstantDynamic(dis);
    }

    private static ConstantInvokeDynamic readConstantInvokeDynamic(DataInputStream dis) throws IOException {
        return ConstantFactory.readConstantInvokeDynamic(dis);
    }

    private static ConstantPackage readConstantPackage(DataInputStream dis) throws IOException {
        return ConstantFactory.readConstantPackage(dis);
    }

}

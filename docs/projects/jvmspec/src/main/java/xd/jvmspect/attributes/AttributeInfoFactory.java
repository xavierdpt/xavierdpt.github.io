package xd.jvmspect.attributes;

import xd.jvmspect.ExceptionInfo;
import xd.jvmspect.bytecode.ByteCodeParser;
import xd.jvmspect.bytecode.Instruction;
import xd.jvmspect.steps.Step2GenerateXMLFiles;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

public class AttributeInfoFactory {
    public static CodeAttributeInfo parseCode(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        int maxStack = dis.readUnsignedShort();
        int maxLocals = dis.readUnsignedShort();
        int codeLength = dis.readInt();
        byte[] code = dis.readNBytes(codeLength);
        List<Instruction> parsedCode = ByteCodeParser.parse(code);
        int exceptionTableLength = dis.readUnsignedShort();
        ExceptionInfo[] exceptionInfos = new ExceptionInfo[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            int startPc = dis.readUnsignedShort();
            int endPc = dis.readUnsignedShort();
            int handlerPc = dis.readUnsignedShort();
            int catchType = dis.readUnsignedShort();
            exceptionInfos[i] = new ExceptionInfo(startPc, endPc, handlerPc, catchType);
        }
        int attributesCount = dis.readUnsignedShort();
        RawAttributeInfo[] attributeInfos = new RawAttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributeInfos[i] = Step2GenerateXMLFiles.readAttribute(dis);
        }
        return new CodeAttributeInfo(maxStack, maxLocals, code, parsedCode, exceptionInfos, attributeInfos);
    }

    public static LineNumberTableAttributeInfo parseLineNumberTable(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        int count = dis.readUnsignedShort();
        LineNumber[] lineNumbers = new LineNumber[count];
        for (int i = 0; i < count; i++) {
            int codeOffset = dis.readUnsignedShort();
            int lineNumber = dis.readUnsignedShort();
            lineNumbers[i] = new LineNumber(codeOffset, lineNumber);
        }
        return new LineNumberTableAttributeInfo(lineNumbers);
    }

    public static LocalVariableTableAttributeInfo parseLocalVariableTable(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        int count = dis.readUnsignedShort();
        LocalVariable[] localVariables = new LocalVariable[count];
        for (int i = 0; i < count; i++) {
            int codeOffset = dis.readUnsignedShort();
            int length = dis.readUnsignedShort();
            int nameIndex = dis.readUnsignedShort();
            int descriptorIndex = dis.readUnsignedShort();
            int index = dis.readUnsignedShort();
            localVariables[i] = new LocalVariable(codeOffset, length, nameIndex, descriptorIndex, index);
        }
        return new LocalVariableTableAttributeInfo(localVariables);
    }

    public static SourceFileAttributeInfo parseSourceFile(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        int sourceFileIndex = dis.readUnsignedShort();
        return new SourceFileAttributeInfo(sourceFileIndex);
    }

    public static NestHostAttributeInfo parseNestHost(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        int hostClassIndex = dis.readUnsignedShort();
        return new NestHostAttributeInfo(hostClassIndex);
    }

    public static InnerClassesAttributeInfo parseInnerClasses(byte[] bytes) throws IOException {
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes));
        int count = dis.readUnsignedShort();
        InnerClass[] innerClasses = new InnerClass[count];
        for (int i = 0; i < count; i++) {
            int innerClassInfoIndex = dis.readUnsignedShort();
            int outerClassInfoIndex = dis.readUnsignedShort();
            int innerNameIndex = dis.readUnsignedShort();
            int innerClassAccessFlags = dis.readUnsignedShort();
            innerClasses[i]= new InnerClass(innerClassInfoIndex, outerClassInfoIndex, innerNameIndex, innerClassAccessFlags);
        }
        return new InnerClassesAttributeInfo(innerClasses);
    }
}

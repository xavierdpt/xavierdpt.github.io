package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.ConstantResolver;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.AnnotationDefaultAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.AnnotationInfo;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.AnnotationInfoDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.ElementValue;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.ElementValueDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.RuntimeInvisibleAnnotationsAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.annotations.RuntimeVisibleAnnotationsAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.bm.BootstrapMethod;
import com.github.xavierdpt.jvmspect.input.attributes.bm.BootstrapMethodDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.bm.BootstrapMethodsAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.code.CodeAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.code.ExceptionInfo;
import com.github.xavierdpt.jvmspect.input.attributes.code.Instruction;
import com.github.xavierdpt.jvmspect.input.attributes.code.InstructionDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.ic.InnerClass;
import com.github.xavierdpt.jvmspect.input.attributes.ic.InnerClassDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.ic.InnerClassesAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.ln.LineNumber;
import com.github.xavierdpt.jvmspect.input.attributes.ln.LineNumberDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.ln.LineNumberTableAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.lvt.LocalVariable;
import com.github.xavierdpt.jvmspect.input.attributes.lvt.LocalVariableDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.lvt.LocalVariableTableAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.lvtt.LocalVariableType;
import com.github.xavierdpt.jvmspect.input.attributes.lvtt.LocalVariableTypeDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.lvtt.LocalVariableTypeTableAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.module.ModuleDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.module.ModulePackagesAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.mp.MethodParameter;
import com.github.xavierdpt.jvmspect.input.attributes.mp.MethodParameterDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.mp.MethodParametersAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.record.RecordAttributeInfo;
import com.github.xavierdpt.jvmspect.input.attributes.record.RecordComponentInfo;
import com.github.xavierdpt.jvmspect.input.attributes.record.RecordComponentInfoDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.smt.StackMapFrame;
import com.github.xavierdpt.jvmspect.input.attributes.smt.StackMapFrameDataInput;
import com.github.xavierdpt.jvmspect.input.attributes.smt.StackMapTableAttributeInfo;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

public class AttributeInfoDataInput {
    public static AttributeInfo readAttribute(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        int attributeNameIndex = dis.readUnsignedShort();
        String attributeName = constantResolver.resolveString(attributeNameIndex);
        int byteCount = dis.readInt();
        AttributeInfo attributeInfo = switch (attributeName) {
            case "Code" -> readCode(dis, constantResolver);
            case "LineNumberTable" -> readLineNumberTable(dis);
            case "LocalVariableTable" -> readLocalVariableTable(dis);
            case "SourceFile" -> readSourceFile(dis);
            case "NestHost" -> readNestHost(dis);
            case "InnerClasses" -> readInnerClasses(dis);
            case "StackMapTable" -> readStackMapTable(dis);
            case "Signature" -> readSignature(dis);
            case "Exceptions" -> readExceptions(dis);
            case "LocalVariableTypeTable" -> readLocalVariableTypeTable(dis);
            case "ConstantValue" -> readConstantValue(dis);
            case "MethodParameters" -> readMethodParameters(dis);
            case "RuntimeVisibleAnnotations" -> readRuntimeVisibleAnnotations(dis);
            case "BootstrapMethods" -> readBootstrapMethods(dis);
            case "EnclosingMethod" -> readEnclosingMethod(dis);
            case "NestMembers" -> readNestMembers(dis);
            case "Deprecated" -> new DeprecatedAttributeInfo();
            case "PermittedSubclasses" -> readPermittedSubclasses(dis);
            case "Record" -> readRecord(dis, constantResolver);
            case "RuntimeInvisibleAnnotations" -> readRuntimeInvisibleAnnotations(dis);
            case "Module" -> ModuleDataInput.readModule(dis);
            case "ModulePackages" -> readModulePackages(dis);
            case "AnnotationDefault" -> readAnnotationDefault(dis);
            case "ModuleMainClass" -> readModuleMainClass(dis);
            default -> readUnknown(dis, byteCount);
        };
        attributeInfo.setAttributeName(attributeName);
        return attributeInfo;
    }

    public static CodeAttributeInfo readCode(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        int maxStack = dis.readUnsignedShort();
        int maxLocals = dis.readUnsignedShort();
        int codeLength = dis.readInt();
        byte[] code = dis.readNBytes(codeLength);
        List<Instruction> parsedCode = InstructionDataInput.parse(code, 0, -1);
        int exceptionTableLength = dis.readUnsignedShort();
        ExceptionInfo[] exceptionInfos = new ExceptionInfo[exceptionTableLength];
        for (int i = 0; i < exceptionTableLength; i++) {
            exceptionInfos[i] = ExceptionInfoDataInput.read(dis);
        }
        int attributesCount = dis.readUnsignedShort();
        AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
        for (int i = 0; i < attributesCount; i++) {
            attributeInfos[i] = readAttribute(dis, constantResolver);
        }
        return new CodeAttributeInfo(maxStack, maxLocals, parsedCode, exceptionInfos, attributeInfos);
    }

    public static LineNumberTableAttributeInfo readLineNumberTable(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        LineNumber[] lineNumbers = new LineNumber[count];
        for (int i = 0; i < count; i++) {
            lineNumbers[i] = LineNumberDataInput.read(dis);
        }
        return new LineNumberTableAttributeInfo(lineNumbers);
    }

    public static LocalVariableTableAttributeInfo readLocalVariableTable(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        LocalVariable[] localVariables = new LocalVariable[count];
        for (int i = 0; i < count; i++) {
            localVariables[i] = LocalVariableDataInput.read(dis);
        }
        return new LocalVariableTableAttributeInfo(localVariables);
    }

    public static SourceFileAttributeInfo readSourceFile(DataInputStream dis) throws IOException {
        int sourceFileIndex = dis.readUnsignedShort();
        return new SourceFileAttributeInfo(sourceFileIndex);
    }

    public static NestHostAttributeInfo readNestHost(DataInputStream dis) throws IOException {
        int hostClassIndex = dis.readUnsignedShort();
        return new NestHostAttributeInfo(hostClassIndex);
    }

    public static InnerClassesAttributeInfo readInnerClasses(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        InnerClass[] innerClasses = new InnerClass[count];
        for (int i = 0; i < count; i++) {
            innerClasses[i] = InnerClassDataInput.read(dis);
        }
        return new InnerClassesAttributeInfo(innerClasses);
    }

    public static StackMapTableAttributeInfo readStackMapTable(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        StackMapFrame[] stackMapFrames = new StackMapFrame[count];
        for (int i = 0; i < count; i++) {
            stackMapFrames[i] = StackMapFrameDataInput.read(dis);
        }
        return new StackMapTableAttributeInfo(stackMapFrames);
    }

    public static SignatureAttributeInfo readSignature(DataInputStream dis) throws IOException {
        int signatureIndex = dis.readUnsignedShort();
        return new SignatureAttributeInfo(signatureIndex);
    }

    public static ExceptionsAttributeInfo readExceptions(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        int[] exceptionIndexes = new int[count];
        for (int i = 0; i < count; i++) {
            exceptionIndexes[i] = dis.readUnsignedShort();
        }
        return new ExceptionsAttributeInfo(exceptionIndexes);
    }

    public static LocalVariableTypeTableAttributeInfo readLocalVariableTypeTable(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        LocalVariableType[] localVariableTypes = new LocalVariableType[count];
        for (int i = 0; i < count; i++) {
            localVariableTypes[i] = LocalVariableTypeDataInput.parse(dis);
        }
        return new LocalVariableTypeTableAttributeInfo(localVariableTypes);
    }

    public static ConstantValueAttributeInfo readConstantValue(DataInputStream dis) throws IOException {
        int constantValueIndex = dis.readUnsignedShort();
        return new ConstantValueAttributeInfo(constantValueIndex);
    }

    public static MethodParametersAttributeInfo readMethodParameters(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedByte();
        MethodParameter[] methodParameters = new MethodParameter[count];
        for (int i = 0; i < count; i++) {
            methodParameters[i] = MethodParameterDataInput.read(dis);

        }
        return new MethodParametersAttributeInfo(methodParameters);
    }

    public static RuntimeVisibleAnnotationsAttributeInfo readRuntimeVisibleAnnotations(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        AnnotationInfo[] annotationBytecodes = new AnnotationInfo[count];
        for (int i = 0; i < count; i++) {
            annotationBytecodes[i] = AnnotationInfoDataInput.readAnnotationInfo(dis);
        }
        return new RuntimeVisibleAnnotationsAttributeInfo(annotationBytecodes);
    }

    public static BootstrapMethodsAttributeInfo readBootstrapMethods(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        BootstrapMethod[] bootstrapMethods = new BootstrapMethod[count];
        for (int i = 0; i < count; i++) {
            bootstrapMethods[i] = BootstrapMethodDataInput.read(dis);
        }
        return new BootstrapMethodsAttributeInfo(bootstrapMethods);
    }

    public static NestMembersAttributeInfo readNestMembers(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        int[] classIndexes = new int[count];
        for (int i = 0; i < count; i++) {
            int classIndex = dis.readUnsignedShort();
            classIndexes[i] = classIndex;
        }
        return new NestMembersAttributeInfo(classIndexes);
    }

    public static PermittedSubclassesAttributeInfo readPermittedSubclasses(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        int[] classIndexes = new int[count];
        for (int i = 0; i < count; i++) {
            int classIndex = dis.readUnsignedShort();
            classIndexes[i] = classIndex;
        }
        return new PermittedSubclassesAttributeInfo(classIndexes);
    }

    public static RecordAttributeInfo readRecord(DataInputStream dis, ConstantResolver constantResolver) throws IOException {
        int count = dis.readUnsignedShort();
        RecordComponentInfo[] recordComponentInfos = new RecordComponentInfo[count];
        for (int i = 0; i < count; i++) {
            RecordComponentInfo recordComponentInfo = RecordComponentInfoDataInput.read(dis, constantResolver);
            recordComponentInfos[i] = recordComponentInfo;
        }
        return new RecordAttributeInfo(recordComponentInfos);
    }

    public static RuntimeInvisibleAnnotationsAttributeInfo readRuntimeInvisibleAnnotations(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        AnnotationInfo[] annotations = new AnnotationInfo[count];
        for (int i = 0; i < count; i++) {
            annotations[i] = AnnotationInfoDataInput.readAnnotationInfo(dis);
        }
        return new RuntimeInvisibleAnnotationsAttributeInfo(annotations);
    }

    public static ModulePackagesAttributeInfo readModulePackages(DataInputStream dis) throws IOException {
        int count = dis.readUnsignedShort();
        int[] packageIndexes = new int[count];
        for (int i = 0; i < count; i++) {
            int packageIndex = dis.readUnsignedShort();
            packageIndexes[i] = packageIndex;
        }
        return new ModulePackagesAttributeInfo(packageIndexes);
    }

    public static AnnotationDefaultAttributeInfo readAnnotationDefault(DataInputStream dis) throws IOException {
        ElementValue elementValue = ElementValueDataInput.read(dis);
        return new AnnotationDefaultAttributeInfo(elementValue);
    }

    public static ModuleMainClassAttributeInfo readModuleMainClass(DataInputStream dis) throws IOException {
        int mainClassIndex = dis.readUnsignedShort();
        return new ModuleMainClassAttributeInfo(mainClassIndex);
    }


    public static EnclosingMethodAttributeInfo readEnclosingMethod(DataInputStream dis) throws IOException {
        int classIndex = dis.readUnsignedShort();
        int methodIndex = dis.readUnsignedShort();
        return new EnclosingMethodAttributeInfo(classIndex, methodIndex);
    }

    public static AttributeInfo readUnknown(DataInputStream dis, int byteCount) throws IOException {
        byte[] bytes = dis.readNBytes(byteCount);
        return new RawAttributeInfo(bytes);
    }
}

package com.github.xavierdpt.jvmspect.input.attributes.smt;

import java.io.DataInputStream;
import java.io.IOException;

public class StackMapFrameDataInput {
    public static StackMapFrame read(DataInputStream dis) throws IOException {
        int frameType = dis.readUnsignedByte();
        if (frameType <= 63) {
            return readSameFrame(frameType, dis);
        } else if (frameType <= 127) {
            return readSameLocals1StackItemFrame(frameType, dis);
        } else if (frameType == 247) {
            return readSameLocals1StackItemFrameExtended(dis);
        } else if (frameType >= 248 && frameType <= 250) {
            return readChop(frameType, dis);
        } else if (frameType == 251) {
            return readSameFrameExtended(dis);
        } else if (frameType >= 252 && frameType <= 254) {
            return readAppendFrame(frameType, dis);
        } else if (frameType == 255) {
            return readFullFrame(dis);
        } else {
            throw new IllegalStateException("Unexpected frame type: " + frameType);
        }
    }

    public static SameFrame readSameFrame(int frameType, DataInputStream dis) {
        return new SameFrame(frameType);
    }

    public static SameLocals1StackItemFrame readSameLocals1StackItemFrame(int frameType, DataInputStream dis) throws IOException {
        int offsetDelta = frameType - 64;
        VerificationTypeInfo verificationTypeInfo = VerificationTypeInfoDataInput.read(dis);
        return new SameLocals1StackItemFrame(offsetDelta, verificationTypeInfo);
    }

    public static SameLocals1StackItemFrameExtended readSameLocals1StackItemFrameExtended(DataInputStream dis) throws IOException {
        int offsetDelta = dis.readUnsignedShort();
        VerificationTypeInfo verificationTypeInfo = VerificationTypeInfoDataInput.read(dis);
        return new SameLocals1StackItemFrameExtended(offsetDelta, verificationTypeInfo);
    }

    public static Chop readChop(int frameType, DataInputStream dis) throws IOException {
        int k = 251 - frameType;
        int offsetDelta = dis.readUnsignedShort();
        return new Chop(k, offsetDelta);
    }

    public static SameFrameExtended readSameFrameExtended(DataInputStream dis) throws IOException {
        int offsetDelta = dis.readUnsignedShort();
        return new SameFrameExtended(offsetDelta);
    }

    public static AppendFrame readAppendFrame(int frameType, DataInputStream dis) throws IOException {
        int k = frameType - 251;
        int offsetDelta = dis.readUnsignedShort();
        VerificationTypeInfo[] verificationTypeInfos = new VerificationTypeInfo[k];
        for (int i = 0; i < k; i++) {
            verificationTypeInfos[i] = VerificationTypeInfoDataInput.read(dis);
        }
        return new AppendFrame(offsetDelta, verificationTypeInfos);
    }

    public static FullFrame readFullFrame(DataInputStream dis) throws IOException {
        int offsetDelta = dis.readUnsignedShort();
        int numberOfLocals = dis.readUnsignedShort();
        VerificationTypeInfo[] locals = new VerificationTypeInfo[numberOfLocals];
        for (int i = 0; i < numberOfLocals; i++) {
            locals[i] = VerificationTypeInfoDataInput.read(dis);
        }
        int numberOfStackItems = dis.readUnsignedShort();
        VerificationTypeInfo[] stack = new VerificationTypeInfo[numberOfStackItems];
        for (int i = 0; i < numberOfStackItems; i++) {
            stack[i] = VerificationTypeInfoDataInput.read(dis);
        }
        return new FullFrame(offsetDelta, locals, stack);
    }
}

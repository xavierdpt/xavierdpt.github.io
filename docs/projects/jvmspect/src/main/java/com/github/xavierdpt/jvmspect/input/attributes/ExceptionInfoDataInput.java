package com.github.xavierdpt.jvmspect.input.attributes;

import com.github.xavierdpt.jvmspect.input.attributes.code.ExceptionInfo;

import java.io.DataInputStream;
import java.io.IOException;

public class ExceptionInfoDataInput {
    public static ExceptionInfo read(DataInputStream dis) throws IOException {
        int startPc = dis.readUnsignedShort();
        int endPc = dis.readUnsignedShort();
        int handlerPc = dis.readUnsignedShort();
        int catchType = dis.readUnsignedShort();
        return new ExceptionInfo(startPc, endPc, handlerPc, catchType);
    }
}

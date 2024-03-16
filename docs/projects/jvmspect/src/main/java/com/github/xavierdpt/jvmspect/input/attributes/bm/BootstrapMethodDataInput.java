package com.github.xavierdpt.jvmspect.input.attributes.bm;

import java.io.DataInputStream;
import java.io.IOException;

public class BootstrapMethodDataInput {
    public static BootstrapMethod read(DataInputStream dis) throws IOException {
        int boostrapMethodRef = dis.readUnsignedShort();
        int numArguments = dis.readUnsignedShort();
        int[] boostrapArguments = new int[numArguments];
        for (int i = 0; i < numArguments; i++) {
            int boostrapArgument = dis.readUnsignedShort();
            boostrapArguments[i] = boostrapArgument;
        }
        return new BootstrapMethod(boostrapMethodRef, boostrapArguments);
    }
}

package com.github.xavierdpt.jvmspect.input.attributes.ln;

import java.io.DataInputStream;
import java.io.IOException;

public class LineNumberDataInput {
    public static LineNumber read(DataInputStream dis) throws IOException {
        int codeOffset = dis.readUnsignedShort();
        int lineNumber = dis.readUnsignedShort();
        return new LineNumber(codeOffset, lineNumber);
    }
}

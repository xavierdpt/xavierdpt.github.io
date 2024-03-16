package com.github.xavierdpt.jvmspect.input.constants;

import java.nio.charset.StandardCharsets;

public class StringUtils {
    public static String magic(byte[] bytes) {
        boolean hasEscapes = false;
        for (byte b : bytes) {
            if (shouldEscape(Byte.toUnsignedInt(b))) {
                hasEscapes = true;
            }
        }
        if (!hasEscapes) {
            return new String(bytes, StandardCharsets.UTF_8);
        } else {
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                int bi = Byte.toUnsignedInt(b);
                if (shouldEscape(bi)) {
                    sb.append("\\x" + Integer.toHexString(bi));
                } else if (b == '\\') {
                    sb.append("\\\\");
                } else {
                    sb.append((char) bi);
                }
            }
            return sb.toString();
        }
    }

    private static boolean shouldEscape(int bi) {
        boolean escape = false;
        if (bi < 0x80) {
            if (Character.isISOControl(bi)) {
                if (!Character.isSpaceChar(bi)) {
                    escape = true;
                }
            }
        } else {
            escape = true;
        }
        return escape;

    }
}

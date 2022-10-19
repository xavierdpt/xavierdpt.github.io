package trove.tests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class Test {
    public static void main(String[] args) throws IOException {

        try (FileOutputStream fos = new FileOutputStream("unicode.txt")) {
            PrintStream out = new PrintStream(fos);
            Charset utf32 = Charset.forName("UTF-32");
            Charset utf16 = Charset.forName("UTF-16BE");
            Charset utf8 = Charset.forName("UTF-8");

            for (int codePoint = Character.MIN_CODE_POINT; codePoint <= Character.MAX_CODE_POINT; codePoint++) {
                if (Character.isDefined(codePoint)) {
                    String name = Character.getName(codePoint);
                    if (name != null) {
                        if (name.contains("SUPPLEMENTARY PRIVATE USE AREA")) {
                            continue;
                        }
                        if(name.startsWith("LOW SURROGATES ") || name.startsWith("HIGH SURROGATES ")) {
                            continue;
                        }
                        if(name.startsWith("PRIVATE USE AREA ")) {
                            continue;
                        }
                        if(name.startsWith("CJK UNIFIED IDEOGRAPHS EXTENSION ")) {
                            continue;
                        }
                        if(name.startsWith("CJK COMPATIBILITY IDEOGRAPH-")) {
                            continue;
                        }
                        if(name.startsWith("TANGUT ")) {
                            continue;
                        }
                        if(name.startsWith("HANGUL ")) {
                            continue;
                        }
                        if(name.startsWith("CJK UNIFIED IDEOGRAPHS ")) {
                            continue;
                        }

                    }
                    String codePointHex = toHexStringg(codePoint);
                    out.println(codePointHex);
                    if (name != null) {
                        out.println(name);
                    }
                    String asString = Character.toString(codePoint);
                    out.println("UTF32: " + toByteStrings(asString, utf32));
                    out.println("UTF16: " + toByteStrings(asString, utf16));
                    out.println("UTF8:  " + toByteStrings(asString, utf8));
                    out.println("----");
                }
            }
        }
    }

    private static String toByteStrings(String s, Charset charset) {
        StringBuilder sb = new StringBuilder();
        boolean sep = false;
        for (byte b : s.getBytes(charset)) {
            if (sep) {
                sb.append(" ");
            }
            sb.append(byteToBinaryString(b));
            sep = true;
        }
        return sb.toString();
    }

    private static String toHexStringg(int codePoint) {
        StringBuilder sb = new StringBuilder(Integer.toHexString(codePoint).toUpperCase());
        while (sb.length() < 6) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

    private static String byteToBinaryString(byte b) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(b & 0xff));
        while (sb.length() < 8) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static net.xdexamples.support.ExampleSupport.bytesToHex;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringExample_bytesCharsetConstructor {

    @Test
    public void example() {
        {
            // Here are two well known bytes for French speakers
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};

            // As UTF8, these bytes describe the letter e with acute accent
            String asUTF8 = new String(bytes, StandardCharsets.UTF_8);
            assertEquals("é", asUTF8);

            // But as ISOLatin1, these describes an A with tilde, followed by the copyright sign
            String asISOLatin1 = new String(bytes, StandardCharsets.ISO_8859_1);
            assertEquals("Ã©", asISOLatin1);

            // Note that the string itself consists of two UTF-16 characters which are encoded as more bytes in UTF-8
            assertEquals("C3 83 C2 A9", bytesToHex(asISOLatin1.getBytes()));
        }
        {
            int count = 5;
            String[] byteStrings = new String[count];
            String string = "é";
            for (int i = 0; i < count; i++) {
                // UTF-8 bytes
                byte[] bytes = string.getBytes();
                byteStrings[i] = bytesToHex(bytes);
                // Reinterpret them as ISO Latin 1
                string = new String(bytes, StandardCharsets.ISO_8859_1);
                // again and again and again...
            }
            assertArrayEquals(new String[]{
                    "C3 A9",
                    "C3 83 C2 A9",
                    "C3 83 C2 83 C3 82 C2 A9",
                    "C3 83 C2 83 C3 82 C2 83 C3 83 C2 82 C3 82 C2 A9",
                    "C3 83 C2 83 C3 82 C2 83 C3 83 C2 82 C3 82 C2 83 C3 83 C2 83 C3 82 C2 82 C3 83 C2 82 C3 82 C2 A9"
            }, byteStrings);
        }
    }

}

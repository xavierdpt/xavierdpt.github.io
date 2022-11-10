package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringExample_bytesOffsetLengthCharsetNameConstructor {

    @Test
    public void example() throws UnsupportedEncodingException {

        {
            // Usual case
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            int offset = 0;
            int length = bytes.length;
            String charsetName = StandardCharsets.UTF_8.name();

            String string = new String(bytes, offset, length, charsetName);

            assertEquals("é", string);
        }

        {
            // Invalid charset name
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            int offset = 0;
            int length = bytes.length;
            String charsetName = "hello";

            assertThrows(UnsupportedEncodingException.class, () -> {
                new String(bytes, offset, length, charsetName);
            });
        }

        {
            // Partial UTF-8 surrogate sequence
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            int offset = 1;
            int length = 1;
            String charsetName = StandardCharsets.UTF_8.name();

            String string = new String(bytes, offset, length, charsetName);

            assertEquals("\ufffd", string);
        }

        {
            // Invalid bounds
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            int offset = 1;
            int length = 2;
            String charsetName = StandardCharsets.UTF_8.name();

            assertThrows(StringIndexOutOfBoundsException.class, () -> {
                new String(bytes, offset, length, charsetName);
            });
        }


    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringExample_bytesOffsetLengthCharsetConstructor {

    @Test
    public void example() {

        {
            // Usual case
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            int offset = 0;
            int length = bytes.length;
            Charset charset = StandardCharsets.UTF_8;

            String string = new String(bytes, offset, length, charset);

            assertEquals("é", string);
        }

        {
            // Partial UTF-8 surrogate sequence
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            int offset = 1;
            int length = 1;
            Charset charset = StandardCharsets.UTF_8;

            String string = new String(bytes, offset, length, charset);

            assertEquals("\ufffd", string);
        }

        {
            // Invalid bounds
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            int offset = 1;
            int length = 2;
            Charset charset = StandardCharsets.UTF_8;

            assertThrows(StringIndexOutOfBoundsException.class, () -> {
                new String(bytes, offset, length, charset);
            });
        }

    }

}

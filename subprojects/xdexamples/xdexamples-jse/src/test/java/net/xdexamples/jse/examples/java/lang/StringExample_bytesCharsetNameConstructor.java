package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringExample_bytesCharsetNameConstructor {

    @Test
    public void example() throws UnsupportedEncodingException {
        {
            // better use an actual Charset object whenever possible
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            String charsetName = StandardCharsets.UTF_8.name();
            String string = new String(bytes, charsetName);
            assertEquals("é", string);
        }
        {
            // Here's what happens when a charset of that name does not exist
            byte[] bytes = {(byte) 0xc3, (byte) 0xa9};
            String charsetName = "hello";
            assertThrows(UnsupportedEncodingException.class, () -> {
                new String(bytes, charsetName);
            });
        }
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static net.xdexamples.support.ExampleSupport.bytesToHex;
import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class StringExample_getBytesCharset {

    @Test
    public void example() {
        {
            // ASCII in UTF-16 with BOM
            String string = "hello";
            byte[] bytes = string.getBytes(StandardCharsets.UTF_16);
            assertEquals("FE FF 00 68 00 65 00 6C 00 6C 00 6F", bytesToHex(bytes));
        }
        {
            // ASCII in UTF-16 without BOM, big endian
            String string = "hello";
            byte[] bytes = string.getBytes(StandardCharsets.UTF_16BE);
            assertEquals("00 68 00 65 00 6C 00 6C 00 6F", bytesToHex(bytes));
        }
        {
            // ASCII in UTF-16 without BOM, little endian
            String string = "hello";
            byte[] bytes = string.getBytes(StandardCharsets.UTF_16LE);
            assertEquals("68 00 65 00 6C 00 6C 00 6F 00", bytesToHex(bytes));
        }
        {
            // REPLACEMENT CHARACTER in UTF-16 without BOM, big endian
            String string = "\ufffd";
            byte[] bytes = string.getBytes(StandardCharsets.UTF_16BE);
            assertEquals("FF FD", bytesToHex(bytes));
        }
        {
            // UTF-16 surrogate pair ASCII (unknown characters get converted to '?')
            String string = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            byte[] bytes = string.getBytes(StandardCharsets.US_ASCII);
            assertEquals("3F", bytesToHex(bytes));

            String whatIsIt = new String(bytes, StandardCharsets.US_ASCII);
            assertEquals("?", whatIsIt);
        }

    }

}

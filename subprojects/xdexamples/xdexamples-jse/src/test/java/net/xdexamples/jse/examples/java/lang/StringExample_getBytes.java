package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.bytesToHex;
import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class StringExample_getBytes {

    @Test
    public void example() {
        {
            // ASCII
            String string = "hello";
            byte[] bytes = string.getBytes();
            assertEquals("68 65 6C 6C 6F", bytesToHex(bytes));
        }
        {
            // REPLACEMENT CHARACTER in UTF-8
            String string = "\ufffd";
            byte[] bytes = string.getBytes();
            assertEquals("EF BF BD", bytesToHex(bytes));
        }
        {
            // UTF-16 surrogate pair encoded in UTF-8
            String string = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            byte[] bytes = string.getBytes();
            assertEquals("F0 92 80 BC", bytesToHex(bytes));
        }

    }

}

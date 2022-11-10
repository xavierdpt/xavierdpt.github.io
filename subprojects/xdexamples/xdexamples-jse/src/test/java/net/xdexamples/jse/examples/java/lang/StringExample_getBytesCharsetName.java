package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static net.xdexamples.support.ExampleSupport.bytesToHex;
import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class StringExample_getBytesCharsetName {

    @Test
    public void example() throws UnsupportedEncodingException {
        {
            // UTF-16 surrogate pair in UTF-32 big endian, no BOM
            String codePointName = "CUNEIFORM SIGN ASH OVER ASH OVER ASH";
            String string = fromCodePointNames(codePointName);
            byte[] bytes = string.getBytes("UTF-32BE");
            assertEquals("00 01 20 3C", bytesToHex(bytes));

            // It's almost exactly the code point
            assertEquals("1203c", Integer.toHexString(Character.codePointOf(codePointName)));
        }

        {
            // UTF-16 surrogate pair in UTF-32 little endian, no BOM
            String codePointName = "CUNEIFORM SIGN ASH OVER ASH OVER ASH";
            String string = fromCodePointNames(codePointName);
            byte[] bytes = string.getBytes("UTF-32LE");
            assertEquals("3C 20 01 00", bytesToHex(bytes));
        }

        {
            // UTF-16 surrogate pair in UTF-32
            // note: contrary to UTF-16, it's the same as UTF-32 big endian
            String codePointName = "CUNEIFORM SIGN ASH OVER ASH OVER ASH";
            String string = fromCodePointNames(codePointName);
            byte[] bytes = string.getBytes("UTF-32");
            assertEquals("00 01 20 3C", bytesToHex(bytes));
        }
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;

public class StringExample_bytesOffsetLengthConstructor {

    @Test
    @SuppressWarnings({"CodeBlock2Expr", "UnnecessaryLocalVariable"})
    public void example() {
        {
            // For ASCII characters, 1 code point = 1 UTF-8 byte
            // + implicit casting from char to byte
            byte[] bytes = new byte[]{'h', 'e', 'l', 'l', 'o'};

            int offset = 1;
            int length = 3;
            String string = new String(bytes, offset, length);

            assertEquals("ell", string);
        }
        {
            // For codepoints outside the BMP, the bytes are UTF-8 surrogate character
            byte[] bytes = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH").getBytes();
            // That's 4 UTF-8 bytes
            assertEquals(4, bytes.length);

            // Taking any part of a multi-UTF-8 bytes codepoint produces the UTF-8 replacement character
            for (int i = 0; i < bytes.length; i++) {

                int offset = i;
                int length = 1;

                String string = new String(bytes, offset, length);

                String expected = fromCodePointNames("REPLACEMENT CHARACTER");

                assertEquals(expected, string);

                // That's the codepoint for the replacement character
                assertEquals("\ufffd", expected);

                // the replacement character is itself 3 UTF-8 bytes
                assertEquals(3,expected.getBytes().length);
            }
        }
        {
            byte[] bytes = new byte[0];
            int offset = 0;
            int length = 1;
            // Bounds check
            Assert.assertThrows(StringIndexOutOfBoundsException.class,()->{
                new String(bytes, offset, length);
            });
        }
    }

}

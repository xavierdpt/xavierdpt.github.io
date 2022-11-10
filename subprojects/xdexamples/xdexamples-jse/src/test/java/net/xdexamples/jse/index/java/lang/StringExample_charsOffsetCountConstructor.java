package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import static net.xdexamples.support.ExampleSupport.fromCodePointNames;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringExample_charsOffsetCountConstructor {

    @Test
    public void example() {
        {
            // Note that you cannot specify the charset for chars because chars are UTF-16 characters
            // or UTF-16 surrogate pairs
            char[] chars = {'h', 'e', 'l', 'l', 'o'};
            int offset = 1;
            int count = chars.length - 2;

            String string = new String(chars, offset, count);
            assertEquals("ell", string);
        }
        {

            char[] chars = fromCodePointNames("CUNEIFORM SIGN ASH OVER ASH OVER ASH").toCharArray();
            int offset = 0;
            int count = 1;

            // Here we construct the string with only the high surrogate
            String string = new String(chars, offset, count);

            // And we get a string with exactly that surrogate, not \ufffd
            assertEquals("\ud808", string);
        }
        {
            // Invalid bounds
            assertThrows(StringIndexOutOfBoundsException.class, () -> {
                new String(new char[0], 0, 1);
            });
        }
    }

}

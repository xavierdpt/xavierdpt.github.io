package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CharacterExample_highSurrogate {

    @Test
    public void example() {
        {
            // It's possible to directly obtain the high surrogate of a codepoint outside the BMP
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");

            char result = Character.highSurrogate(codePoint);

            String string = Character.toString(codePoint);
            assertEquals(string.charAt(0), result);
        }
        {
            // But with characters in the BMP, the result has no meaning
            int codePoint = Character.codePointOf("NULL");

            char result = Character.highSurrogate(codePoint);

            String string = Character.toString(codePoint);
            assertEquals("\0", string);

            assertNotEquals(string.charAt(0), result);
            assertEquals('\ud7c0', result);
        }
    }
}

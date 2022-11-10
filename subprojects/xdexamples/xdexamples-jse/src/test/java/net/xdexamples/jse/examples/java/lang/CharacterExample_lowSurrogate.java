package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_lowSurrogate {

    @Test
    public void example() {
        {
            // It's possible to directly obtain the low surrogate of a codepoint outside the BMP
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");

            char result = Character.lowSurrogate(codePoint);

            String string = Character.toString(codePoint);
            assertEquals(string.charAt(1), result);
        }
        {
            // But with characters in the BMP, the result has no meaning
            int codePoint = Character.codePointOf("NULL");

            char result = Character.lowSurrogate(codePoint);

            String string = Character.toString(codePoint);
            assertEquals("\0", string);
            assertEquals('\udc00',result);

        }
    }


}

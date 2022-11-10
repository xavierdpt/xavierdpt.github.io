package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isLowSurrogate {

    @Test
    public void example() {
        {
            // Code points in the BMP are not surrogates
            char ch = 'h';

            boolean result = Character.isLowSurrogate(ch);

            assertFalse(result);
        }
        {
            // Code points outside the BMP are made of a high and  low surrogate pair
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            String string = Character.toString(codePoint);
            char ch0 = string.charAt(0);
            char ch1 = string.charAt(1);

            boolean result0 = Character.isLowSurrogate(ch0);
            boolean result1 = Character.isLowSurrogate(ch1);

            assertFalse(result0);
            assertTrue(result1);
        }
    }

}

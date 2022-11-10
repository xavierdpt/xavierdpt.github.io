package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isSurrogatePair {

    @Test
    public void example() {
        {
            // Code points outside the BMP are made of a high and a low UTF-16 surrogate pair
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            String string = Character.toString(codePoint);
            char left = string.charAt(0);
            char right = string.charAt(1);
            boolean result = Character.isSurrogatePair(left, right);
            assertTrue(result);
        }
        {
            // The surrogates must appear in the correct order (high surrogate, then low surrogate)
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            String string = Character.toString(codePoint);
            char left = string.charAt(0);
            char right = string.charAt(1);
            boolean result = Character.isSurrogatePair(right, left);
            assertFalse(result);
        }
    }

}

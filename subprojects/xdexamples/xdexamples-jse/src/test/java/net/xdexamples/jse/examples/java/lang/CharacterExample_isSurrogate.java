package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isSurrogate {

    @Test
    public void example() {
        {
            // Code points in the BMP are not surrogates
            char ch = 'h';

            boolean result = Character.isSurrogate(ch);

            assertFalse(result);
        }
        {
            // Code points outside the BMP are made of surrogates
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            String string = Character.toString(codePoint);
            char ch0 = string.charAt(0);
            char ch1 = string.charAt(1);

            boolean result0 = Character.isSurrogate(ch0);
            boolean result1 = Character.isSurrogate(ch1);

            assertTrue(result0);
            assertTrue(result1);
        }
    }

}

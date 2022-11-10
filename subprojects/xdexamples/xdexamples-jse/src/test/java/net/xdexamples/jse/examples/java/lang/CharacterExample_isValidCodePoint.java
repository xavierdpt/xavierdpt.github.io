package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isValidCodePoint {
    @Test
    public void example() {
        {
            // Named codepoints are valid
            int codePoint = Character.codePointOf("NULL");
            boolean result = Character.isValidCodePoint(codePoint);
            assertTrue(result);
        }
        {
            // All codepoints between MIN_CODE_POINT and MAX_CODE_POINT are valid
            for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; ++codePoint) {
                assertTrue(Character.isValidCodePoint(codePoint));
            }
        }
        {
            // Integers above MAX_CODE_POINT are not valid codepoints
            int codePoint = Character.MAX_CODE_POINT + 1;
            boolean result = Character.isValidCodePoint(codePoint);
            assertFalse(result);

        }
    }
}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isBmpCodePoint {

    @Test
    public void example() {
        {
            // Outside the BMP : Two UTF-16 characters
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            boolean result = Character.isBmpCodePoint(codePoint);
            assertFalse(result);
            assertEquals(2, Character.toString(codePoint).length());
        }
        {
            // Inside the BMP : One UTF-16 characters
            int codePoint = Character.codePointOf("NULL");
            boolean result = Character.isBmpCodePoint(codePoint);
            assertTrue(result);
            assertEquals(1, Character.toString(codePoint).length());
        }
    }

}

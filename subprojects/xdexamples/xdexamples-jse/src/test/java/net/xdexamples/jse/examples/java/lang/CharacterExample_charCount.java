package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_charCount {

    @Test
    public void example() {
        {
            // Outside the BMP : Two UTF-16 characters
            int codePoint = Character.codePointOf("CUNEIFORM SIGN ASH OVER ASH OVER ASH");
            int result = Character.charCount(codePoint);
            assertEquals(2, result);
        }
        {
            // Inside the BMP : One UTF-16 characters
            int codePoint = Character.codePointOf("NULL");
            int result = Character.charCount(codePoint);
            assertEquals(1, result);
        }
    }

}

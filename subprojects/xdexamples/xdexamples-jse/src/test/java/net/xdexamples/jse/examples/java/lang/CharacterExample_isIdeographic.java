package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isIdeographic {

    @Test
    public void example() {
        {
            // Here's an ideographic codepoint
            int codePoint = Character.codePointOf("IDEOGRAPHIC CLOSING MARK");
            boolean result = Character.isIdeographic(codePoint);
            assertTrue(result);
        }
        {
            // There are many ideographic codepoints
            int count = 0;
            for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
                if (Character.isIdeographic(codePoint)) {
                    ++count;
                }
            }
            assertEquals(101_652, count);
        }
        {
            // Most of them are outside the BMP
            int count = 0;
            for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
                if (Character.isIdeographic(codePoint) && Character.isBmpCodePoint(codePoint)) {
                    ++count;
                }
            }
            assertEquals(28_067, count);
        }
    }

}

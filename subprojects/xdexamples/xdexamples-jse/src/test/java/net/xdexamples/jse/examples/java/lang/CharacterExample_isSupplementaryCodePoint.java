package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isSupplementaryCodePoint {

    @Test
    public void example() {
        // Supplementary codepoints start at 0x10000
        for (int codePoint = Character.MIN_CODE_POINT; codePoint < 0x10000; ++codePoint) {
            boolean result = Character.isSupplementaryCodePoint(codePoint);
            assertFalse(result);
            // Note: all non supplementary code points are in the BMP
            assertTrue(Character.isBmpCodePoint(codePoint));
        }
        for (int codePoint = 0x10000; codePoint < Character.MAX_CODE_POINT; ++codePoint) {
            boolean result = Character.isSupplementaryCodePoint(codePoint);
            assertTrue(result);
            // Note: all supplementary code points are outside the BMP
            assertFalse(Character.isBmpCodePoint(codePoint));
        }

    }
}


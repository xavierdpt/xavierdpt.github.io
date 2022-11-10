package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StringExample_codePointsOffsetLengthConstructor {

    @Test
    public void example() {

        // Start with codepoint names
        String[] codePointNames = {
                "LATIN SMALL LETTER H",
                "LATIN SMALL LETTER E",
                "LATIN SMALL LETTER L",
                "LATIN SMALL LETTER L",
                "LATIN SMALL LETTER O"
        };

        // Get the corresponding codepoints
        int[] codePoints = Arrays.stream(codePointNames).mapToInt(Character::codePointOf).toArray();
        int offset = 0;
        int length = codePoints.length;

        // Create string from those codepoints
        String string = new String(codePoints, offset, length);

        // Check
        assertEquals("hello", string);

    }

}

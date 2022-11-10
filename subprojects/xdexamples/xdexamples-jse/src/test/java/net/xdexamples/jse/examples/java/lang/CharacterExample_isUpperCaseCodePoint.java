package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_isUpperCaseCodePoint {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        {
            int count = 0;
            Integer last = null;
            for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; ++codePoint) {
                boolean result = Character.isUpperCase(codePoint);
                if (result) {
                    ++count;
                    last = codePoint;
                }
            }
            // There are 1911 upper case characters in Unicode
            assertEquals(1911, count);
            // Here's the last one
            assertEquals("NEGATIVE SQUARED LATIN CAPITAL LETTER Z", Character.getName(last));
        }
    }
}

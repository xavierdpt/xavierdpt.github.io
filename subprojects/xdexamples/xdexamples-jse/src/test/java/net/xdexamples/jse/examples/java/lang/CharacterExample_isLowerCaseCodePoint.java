package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_isLowerCaseCodePoint {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void test() {
        {
            int count = 0;
            Integer last = null;
            for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; ++codePoint) {
                boolean result = Character.isLowerCase(codePoint);
                if (result) {
                    ++count;
                    last = codePoint;
                }
            }
            // There are 2344 lower case characters in Unicode
            assertEquals(2344, count);
            // Here's the last one
            assertEquals("ADLAM SMALL LETTER SHA", Character.getName(last));
        }
    }
}

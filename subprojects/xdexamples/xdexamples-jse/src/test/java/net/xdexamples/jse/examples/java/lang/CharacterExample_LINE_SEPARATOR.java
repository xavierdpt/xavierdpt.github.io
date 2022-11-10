package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterExample_LINE_SEPARATOR {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        // There is only one line separator
        int count = 0;
        String lastName = null;
        Integer lastCodePoint = null;
        for (int codePoint = Character.MIN_CODE_POINT; codePoint < Character.MAX_CODE_POINT; codePoint++) {
            if (Character.isDefined(codePoint)) {
                if (Character.getType(codePoint) == Character.LINE_SEPARATOR) {
                    ++count;
                    lastCodePoint = codePoint;
                    lastName = Character.getName(codePoint);
                }
            }
        }
        assertEquals(1, count);
        assertEquals(0x2028, lastCodePoint.intValue());
        assertEquals("LINE SEPARATOR", lastName);
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isDigitChar {

    @Test
    public void example() {
        {
            char ch = '0';
            boolean result = Character.isDigit(ch);
            assertTrue(result);
        }
        {
            char ch = 'a';
            boolean result = Character.isDigit(ch);
            assertFalse(result);
        }
    }

}

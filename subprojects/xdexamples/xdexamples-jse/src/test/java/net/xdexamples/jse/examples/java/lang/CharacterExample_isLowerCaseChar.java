package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CharacterExample_isLowerCaseChar {

    @Test
    public void example() {
        {
            char ch = 'a';
            boolean result = Character.isLowerCase(ch);
            assertTrue(result);
        }
        {
            char ch = 'A';
            boolean result = Character.isLowerCase(ch);
            assertFalse(result);
        }
    }

}

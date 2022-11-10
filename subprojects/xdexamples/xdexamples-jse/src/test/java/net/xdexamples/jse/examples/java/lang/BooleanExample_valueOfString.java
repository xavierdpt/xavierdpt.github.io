package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExample_valueOfString {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void example() {

        // valueOf recognizes true in any cases (lowercase, uppercase or mixed case)
        // Anything else is false

        {
            String input = "true";
            boolean value = Boolean.valueOf(input);
            assertTrue(value);
        }

        {
            String input = "false";
            boolean value = Boolean.valueOf(input);
            assertFalse(value);
        }

        {
            String input = "TRue";
            boolean value = Boolean.valueOf(input);
            assertTrue(value);
        }

        {
            String input = "FAlse";
            boolean value = Boolean.valueOf(input);
            assertFalse(value);
        }

        {
            String input = "anything else";
            boolean value = Boolean.valueOf(input);
            assertFalse(value);
        }

    }
}

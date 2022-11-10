package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExample_parseBoolean {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {

        // parseBoolean recognizes true in any cases (lowercase, uppercase or mixed case)
        // Anything else is false

        {
            String input = "true";
            boolean value = Boolean.parseBoolean(input);
            assertTrue(value);
        }

        {
            String input = "false";
            boolean value = Boolean.parseBoolean(input);
            assertFalse(value);
        }

        {
            String input = "TRue";
            boolean value = Boolean.parseBoolean(input);
            assertTrue(value);
        }

        {
            String input = "FAlse";
            boolean value = Boolean.parseBoolean(input);
            assertFalse(value);
        }

        {
            String input = "anything else";
            boolean value = Boolean.parseBoolean(input);
            assertFalse(value);
        }

    }
}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExample_startsWith {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        // Nothing fancy here
        {
            String string = "hello";
            String prefix = "hell";
            boolean result = string.startsWith(prefix);
            assertTrue(result);
        }
        {
            String string = "hello";
            String prefix = "world";
            boolean result = string.startsWith(prefix);
            assertFalse(result);
        }
    }

}

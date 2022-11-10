package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExample_startsWithOffset {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        {
            String string = "hello wonderful world";
            String prefix = "wonderful";
            int offset = "hello".length() + 1;
            boolean result = string.startsWith(prefix, offset);
            assertTrue(result);
        }
        {
            String string = "hello wonderful world";
            String prefix = "world";
            int offset = "hello".length() + 1;
            boolean result = string.startsWith(prefix, offset);
            assertFalse(result);
        }
    }

}

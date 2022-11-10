package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isArray {
    @Test
    public void example() {
        {
            // This is not an array
            Class<?> clazz = String.class;
            boolean result = clazz.isArray();
            assertFalse(result);
        }
        {
            // This is an array
            Class<?> clazz = String[].class;
            boolean result = clazz.isArray();
            assertTrue(result);
        }

    }


}

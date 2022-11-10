package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isPrimitive {

    @Test
    public void example() {
        {
            // This is not a primitive
            Class<?> clazz = Double.class;
            boolean result = clazz.isPrimitive();
            assertFalse(result);
        }
        {
            // This is a primitive
            Class<?> clazz = double.class;
            boolean result = clazz.isPrimitive();
            assertTrue(result);
        }

    }

}

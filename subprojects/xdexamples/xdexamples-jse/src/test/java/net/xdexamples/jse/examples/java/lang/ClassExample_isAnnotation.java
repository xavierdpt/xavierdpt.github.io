package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isAnnotation {

    @Test
    public void example() {
        {
            // This is not an annotation
            Class<?> clazz = String.class;
            boolean result = clazz.isAnnotation();
            assertFalse(result);
        }
        {
            // This is an annotation
            Class<?> clazz = SuppressWarnings.class;
            boolean result = clazz.isAnnotation();
            assertTrue(result);
        }

    }


}

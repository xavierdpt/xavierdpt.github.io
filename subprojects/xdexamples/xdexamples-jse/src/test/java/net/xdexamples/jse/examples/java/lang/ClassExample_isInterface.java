package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isInterface {

    @Test
    public void example() {
        {
            // This class is not an interface
            Class<?> clazz = this.getClass();
            boolean result = clazz.isInterface();
            assertFalse(result);
        }
        {
            // Runnable is an interface
            Class<?> clazz = Runnable.class;
            boolean result = clazz.isInterface();
            assertTrue(result);
        }

    }


}

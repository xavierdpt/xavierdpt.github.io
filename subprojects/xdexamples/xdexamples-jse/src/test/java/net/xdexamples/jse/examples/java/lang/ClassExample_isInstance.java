package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isInstance {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        {
            // this is an instance of this class
            Class<?> clazz = this.getClass();
            boolean result = clazz.isInstance(this);
            assertTrue(result);
        }
        {
            // this is an instance of the Object class
            Class<?> clazz = Object.class;
            boolean result = clazz.isInstance(this);
            assertTrue(result);
        }
        {
            // this is not an instance of Runnable
            Class<?> clazz = Runnable.class;
            boolean result = clazz.isInstance(this);
            assertFalse(result);
        }
    }

}

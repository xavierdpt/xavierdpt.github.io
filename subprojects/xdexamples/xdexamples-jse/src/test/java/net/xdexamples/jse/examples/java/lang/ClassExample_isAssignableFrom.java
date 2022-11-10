package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassExample_isAssignableFrom {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        {
            // object of this class cannot be assigned to objects of type Object
            Class<?> clazz = this.getClass();
            Class<?> other = Object.class;
            boolean result = clazz.isAssignableFrom(other);
            assertFalse(result);
        }
        {
            // objects of type Object can be assigned to object of this class
            Class<?> clazz = Object.class;
            Class<?> other = this.getClass();
            boolean result = clazz.isAssignableFrom(other);
            assertTrue(result);
        }
        {
            // objects of type Thread can be assigned to objects of type Runnable
            Class<?> clazz = Runnable.class;
            Class<?> other = Thread.class;
            boolean result = clazz.isAssignableFrom(other);
            assertTrue(result);
        }
        {
            // objects of type Runnable cannot be assigned to objects of type Thread
            Class<?> clazz = Thread.class;
            Class<?> other = Runnable.class;
            boolean result = clazz.isAssignableFrom(other);
            assertFalse(result);
        }

    }


}

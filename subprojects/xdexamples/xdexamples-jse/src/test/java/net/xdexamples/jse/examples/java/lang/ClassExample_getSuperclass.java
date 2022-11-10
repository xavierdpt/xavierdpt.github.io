package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class ClassExample_getSuperclass {

    @Test
    public void example() {
        {
            // The object class has no super class
            Class<?> clazz = Object.class;
            Class<?> superclass = clazz.getSuperclass();
            assertNull(superclass);
        }
        {
            // Other classes at least have Object as their superclass
            Class<?> clazz = String.class;
            Class<?> superclass = clazz.getSuperclass();
            assertSame(Object.class, superclass);
        }
        {
            // Exceptoin has Throwable as its superclass
            Class<?> clazz = Exception.class;
            Class<?> superclass = clazz.getSuperclass();
            assertSame(Throwable.class, superclass);
        }

    }

}

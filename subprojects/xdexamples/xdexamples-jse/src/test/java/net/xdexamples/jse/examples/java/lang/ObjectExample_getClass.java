package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ObjectExample_getClass {

    @Test
    public void example() {

        // All classes in Java inherits the Object class
        // the Object class defines the getClass() method which returns the actual class

        {
            // We define a new object
            Object object = new Object();

            // It's class as Object.class has expected
            assertSame(Object.class, object.getClass());
        }

        {
            // We define a new string, but only manuplate a reference to an object
            Object object = "hello";

            // It's class is String.class
            assertSame(String.class, object.getClass());
        }
    }

}

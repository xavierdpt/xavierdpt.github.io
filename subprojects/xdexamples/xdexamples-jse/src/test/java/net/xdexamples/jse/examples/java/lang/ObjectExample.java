package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ObjectExample {
    @SuppressWarnings({
            "ConstantConditions",
            "EmptySynchronizedStatement",
            "SynchronizationOnLocalVariableOrMethodParameter"
    })
    @Test
    public void example() throws InterruptedException {
        {
            // Object is the base class of all other classes in Java
            String hello = "hello";
            // hello is an instance of the String class
            assertTrue(hello instanceof String);
            // hello is also an instance of the Object class
            assertTrue(hello instanceof Object);
        }
        {
            // It's possible to create objects directly
            Object object = new Object();

            // That object is a brand new object that cannot do much
            assertNotNull(object);

            // But it can be used for concurrency control
            synchronized (object) {
                // Here we are sure that other threads will wait before entering this critical section
            }
        }

    }
}

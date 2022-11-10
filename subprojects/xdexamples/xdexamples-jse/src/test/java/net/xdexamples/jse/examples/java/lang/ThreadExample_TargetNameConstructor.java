package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_TargetNameConstructor {

    @Test
    public void example() throws InterruptedException {
        // Prepare a slot to receive a String
        String[] value = new String[1];

        // This runnable outputs a message with the current thread's name
        Runnable target = () -> value[0] = "Hello from " + Thread.currentThread().getName();

        // Create a new named thread
        Thread thread = new Thread(target, "myThread");

        // Start the thread
        thread.start();

        // Wait for the thread to finish
        thread.join();

        // Check that the value has been set with the thread's name
        assertEquals("Hello from myThread", value[0]);
    }

}

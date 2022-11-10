package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class ThreadExample_currentThread {

    @Test
    public void example() throws InterruptedException {

        // Result will be written here
        AtomicReference<Thread> result = new AtomicReference<>();

        // Create the thread
        Thread thread = new Thread(() -> {
            // Retrieve the current thread
            Thread currentThread = Thread.currentThread();
            // Sets the reference to the current thread
            result.set(currentThread);
        });

        // Start the thread
        thread.start();

        // Wait for the thread to terminate
        thread.join();

        // Check that the result was indeed the thread
        assertSame(thread, result.get());

        // Additional check that current thread is not the thread
        assertNotSame(thread, Thread.currentThread());
    }

}

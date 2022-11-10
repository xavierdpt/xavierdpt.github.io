package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

public class ThreadGroupExample_interrupt {

    @Test
    public void example() throws InterruptedException {

        // New thread group
        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");

        // CountDownLatch to block the thread
        CountDownLatch cdl = new CountDownLatch(1);

        // Atomic reference to string to store a message
        AtomicReference<String> message = new AtomicReference<>();

        // New thread
        Thread thread = new Thread(threadGroup, () -> {
            try {
                // Wait on the latch
                cdl.await();
            } catch (InterruptedException e) {
                // Set the message
                message.set("Oh no, I've been interrupted");
            }
        }, "myThread");

        // Start the thread
        thread.start();

        // Try to wait for the thread, but nothing will happen here
        thread.join(100L);

        // Interrupt all the threads
        threadGroup.interrupt();

        // Try to wait for the thread, and give it time to register the interrupt
        thread.join(100L);

        // Check that the message has been received
        assertEquals("Oh no, I've been interrupted", message.get());

        // TODO: Is it possible to do the same thing without Thread.join ?
    }

}

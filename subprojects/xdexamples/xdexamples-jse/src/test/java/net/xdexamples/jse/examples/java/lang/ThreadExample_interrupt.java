package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertTrue;

public class ThreadExample_interrupt {

    @Test
    public void example() throws InterruptedException {

        // The thread will write in this flag
        AtomicBoolean interrupted = new AtomicBoolean();

        // The thread will wait indefinitely on this latch
        CountDownLatch cdl = new CountDownLatch(1);

        // Create the new thread
        Thread thread = new Thread(() -> {
            try {
                // Wait indefinitely
                cdl.await();
            } catch (InterruptedException e) {
                // Set the flag when interrupted
                interrupted.set(true);
            }
        });

        // Start
        thread.start();

        // This thread will interrupt the other thread after one second
        new Thread(() -> {
            try {
                Thread.sleep(1000L);
                thread.interrupt();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        // Wait for the thread
        // The second thread will be terminated by then
        thread.join();

        // Check that the interrupted flag has been set
        assertTrue(interrupted.get());
    }

}

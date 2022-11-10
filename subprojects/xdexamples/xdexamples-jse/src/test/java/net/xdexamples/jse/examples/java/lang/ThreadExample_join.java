package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadExample_join {

    @Test
    public void example() throws InterruptedException {

        // Start a thread that sleeps
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.start();

        // Wait for one nano second
        // Note: current hardware hardly allows effective use of join with millis and nanos
        // See ThreadExample_start_join_sleep
        thread.join(0L,1);

        // Check that thread is still alive
        assertTrue(thread.isAlive());

        // Wait a bit for the thread
        thread.join(100L);

        // Check that thread is still alive
        assertTrue(thread.isAlive());

        // Wait for the thread to terminate
        thread.join();

        // Check that thread is no longer alive
        assertFalse(thread.isAlive());



    }

}

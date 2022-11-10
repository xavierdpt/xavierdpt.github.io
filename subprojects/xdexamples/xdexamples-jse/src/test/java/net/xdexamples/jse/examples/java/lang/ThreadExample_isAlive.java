package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadExample_isAlive {

    @Test
    public void example() throws InterruptedException {

        CountDownLatch cdl = new CountDownLatch(1);

        try {
            Thread thread = new Thread(() -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });

            {
                // Thread is not started => not alive
                boolean alive = thread.isAlive();
                assertFalse(alive);
            }

            // Start thread
            thread.start();

            {
                // Thread marked alive as soon as it is staretd
                boolean alive = thread.isAlive();
                assertTrue(alive);
            }

            // Tell thread to proceed
            cdl.countDown();

            {
                // Thread is still alive, but this is a race condition here
                boolean alive = thread.isAlive();
                assertTrue(alive);
            }

            // Wait for thread
            thread.join();

            {
                // This is no longer alive
                boolean alive = thread.isAlive();
                assertFalse(alive);
            }

        } finally {
            // In case any assert fails, clear latch and let thread finish nicely
            if (cdl.getCount() > 0) {
                cdl.countDown();
            }
        }


    }

}

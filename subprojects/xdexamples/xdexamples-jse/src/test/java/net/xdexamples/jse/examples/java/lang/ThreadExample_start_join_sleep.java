package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ThreadExample_start_join_sleep {

    @Test
    public void example() throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        long start = System.currentTimeMillis();
        thread.start();
        thread.join();
        long end = System.currentTimeMillis();

        assertTrue(end - start >= 1000L);

        // Note: current hardware hardly allows effective use of sleep with millis and nanos
        long min = Long.MAX_VALUE;
        for (int i = 0; i < 10000; i++) {
            long before = System.nanoTime();
            Thread.sleep(0L, 1);
            long after = System.nanoTime();
            long delta = after - before;
            if (delta < min) {
                min = delta;
            }
        }
        // You'll be lucky if the following assert fails for you
        assertTrue(min >= 1000000);
    }


}

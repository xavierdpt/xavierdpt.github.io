package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

public class ThreadExample_activeCount {

    @Test
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public void example() throws InterruptedException {

        // Here's the current active count
        int activeCount0 = Thread.activeCount();

        // Let's start a new thread
        Thread thread = new Thread();
        thread.start();

        // There is one more "active" thread
        // (there's a race condition here)
        int activeCount1 = Thread.activeCount();

        // Wait for the thread to finish
        thread.join();

        // We should have observed one more active thread
        assertEquals(activeCount0 + 1, activeCount1);


    }
}

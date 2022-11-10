package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ThreadGroupExample_setMaxPriority {

    @Test
    public void example() {

        // This is the main thread group
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        // This is the system thread group
        ThreadGroup system = main.getParent();
        assertEquals("system", system.getName());

        // Remember the max priorities because we will change them
        int initialSystemMaxPriority = system.getMaxPriority();
        int initialMainMaxPiority = main.getMaxPriority();

        // A thread will wait on this latch
        CountDownLatch cdl = new CountDownLatch(1);

        try {

            // This thing will wait indefinitely
            Runnable waitIndefinitely = () -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };

            // Start a long running thread
            Thread highThread = new Thread(waitIndefinitely);
            highThread.start();

            // That thread's max priority is current thread's max priority
            assertEquals(10, main.getMaxPriority());
            assertEquals(5, Thread.currentThread().getPriority());
            assertSame(main, highThread.getThreadGroup());
            assertEquals(5, highThread.getPriority());

            // It's possible to change the max priority of the system thread group
            int maxPriority = 2;
            system.setMaxPriority(maxPriority);

            assertEquals(2, system.getMaxPriority());

            // Now the main thread group max priority as been changed too
            assertEquals(2, main.getMaxPriority());

            // We can set the maxi priority lower than its parent
            main.setMaxPriority(1);
            assertEquals(1, main.getMaxPriority());

            // But we cannot set it higher than its parent
            main.setMaxPriority(10);
            assertEquals(2, main.getMaxPriority());

            // The thread's priority was not affected
            assertEquals(5, highThread.getPriority());

            // Start a new thread
            Thread lowThread = new Thread(waitIndefinitely);
            lowThread.start();
            // The new thread's priority has been affected
            assertEquals(2, lowThread.getPriority());

        } finally {
            // Terminate the threads
            cdl.countDown();

            // Reset the max priorities in the correct order
            system.setMaxPriority(initialSystemMaxPriority);
            main.setMaxPriority(initialMainMaxPiority);
            // Note that any other children of system or of main will still keep the lower priorities
        }
    }


}

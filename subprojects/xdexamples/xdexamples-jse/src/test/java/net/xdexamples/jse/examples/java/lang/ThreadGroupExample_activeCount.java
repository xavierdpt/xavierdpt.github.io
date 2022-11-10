package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertEquals;

public class ThreadGroupExample_activeCount {

    @Test
    public void example() throws InterruptedException {

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        ThreadGroup system = main.getParent();
        assertEquals("system", system.getName());

        {
            // The system's thread group has 8 active threads (may vary)
            int activeCount = system.activeCount();
            assertEquals(8, activeCount);
        }

        {
            // The current thread group has two active thread: that one and the Ctrl-Break monitor
            // that may vary too
            int activeCount = main.activeCount();
            assertEquals(2, activeCount);
        }

        {
            // Create a new thread group under main
            ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
            // Initially no active threads
            assertEquals(0, threadGroup.activeCount());

            // Use a count down latch to control the thread
            CountDownLatch cdl = new CountDownLatch(1);
            try {
                // New thread in the thread group
                Thread thread = new Thread(threadGroup, () -> {
                    try {
                        cdl.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

                // Not active yet because not started
                assertEquals(0, threadGroup.activeCount());

                // Start the thread
                thread.start();

                // Now one thread is active
                assertEquals(1, threadGroup.activeCount());

                // Count down and let the thread terminate
                cdl.countDown();
                thread.join();

                // No active thread
                assertEquals(0, threadGroup.activeCount());

            }finally {
                // In case of failure, manually decrease the count down latch here, unless it has already been decreased
                if (cdl.getCount() > 0) {
                    cdl.countDown();
                }
            }
        }
    }

}

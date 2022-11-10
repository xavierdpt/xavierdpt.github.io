package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreadGroupExample_enumerateThreads {

    @Test
    public void example() throws InterruptedException {

        // Check that we get a thread group named "main"
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        // Start a new thread
        CountDownLatch cdl = new CountDownLatch(1);
        try {
            Runnable runnable = () -> {
                try {
                    cdl.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            };
            Thread thread = new Thread(runnable, "z");
            thread.start();

            // Check the names
            checkThreadNames(main, new String[]{
                    "Monitor Ctrl-Break",
                    "main",
                    "z"
            });

            // Let thread "z" terminate
            cdl.countDown();
            thread.join();

            // Check again
            checkThreadNames(main, new String[]{
                    "Monitor Ctrl-Break",
                    "main"
            });
        } finally {
            // Handle exceptions
            if (cdl.getCount() > 0) {
                cdl.countDown();
            }
        }
    }

    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    private void checkThreadNames(ThreadGroup threadGroup, String[] expected) {
        // Collect the names of active threads
        String[] names;

        // Possibly better to synchronize on the thread group so that the active count and the result of enumerate
        // match more closely
        synchronized (threadGroup) {

            // Prepare a bigger array because activeCount is an estimate
            Thread[] list = new Thread[threadGroup.activeCount() * 2];

            // Fill the array with threads
            int found = threadGroup.enumerate(list);

            // Check that all threads have been found
            assertTrue(found < list.length);

            // Collect thread names and ignore null entries
            names = Arrays.stream(list)
                    .filter(Objects::nonNull)
                    .map(Thread::getName)
                    .sorted()
                    .toArray(String[]::new);
        }

        // Compare the names with what was expected
        assertArrayEquals(expected, names);
    }
}
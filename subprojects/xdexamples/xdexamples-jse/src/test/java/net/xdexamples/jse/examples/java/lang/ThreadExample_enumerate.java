package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class ThreadExample_enumerate {

    @Test
    public void example() {

        // Prepare an array with more than enough slots
        Thread[] threads = new Thread[2 * Thread.activeCount()];

        // Enumerate active threads
        int found = Thread.enumerate(threads);

        // Check that the array was big enough to hold all the threads
        assertTrue(found < threads.length);

        // Current thread's id
        long currentThreadId = Thread.currentThread().getId();

        // Check that the current thread was enumerated
        assertTrue(Arrays.stream(threads)
                .filter(Objects::nonNull)
                .map(Thread::getId)
                .anyMatch(id -> id == currentThreadId)
        );
    }

}

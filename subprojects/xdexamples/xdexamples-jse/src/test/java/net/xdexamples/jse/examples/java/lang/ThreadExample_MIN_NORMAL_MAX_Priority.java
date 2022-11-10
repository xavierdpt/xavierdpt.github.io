package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_MIN_NORMAL_MAX_Priority {

    @Test
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public void example() {

        // Thread priority goes from 1 to 10
        // Default "normal" priority is 5

        int minPriority = Thread.MIN_PRIORITY;
        assertEquals(1, minPriority);

        int normPriority = Thread.NORM_PRIORITY;
        assertEquals(5, normPriority);

        int maxPriority = Thread.MAX_PRIORITY;
        assertEquals(10, maxPriority);

        Thread thread = new Thread();
        assertEquals(Thread.NORM_PRIORITY, thread.getPriority());
    }

}

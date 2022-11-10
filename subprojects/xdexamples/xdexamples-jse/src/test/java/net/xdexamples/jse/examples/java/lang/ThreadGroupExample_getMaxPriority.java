package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadGroupExample_getMaxPriority {

    @Test
    public void example() {
        {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            assertEquals("main", threadGroup.getName());

            // Default priority of the "main" thead group
            int maxPriority = threadGroup.getMaxPriority();
            assertEquals(10, maxPriority);
        }
        {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup().getParent();
            assertEquals("system", threadGroup.getName());

            // Default priority of the "system" thead group
            int maxPriority = threadGroup.getMaxPriority();
            assertEquals(10, maxPriority);

            // Note: 10 is the max priority
        }
    }
}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ThreadGroupExample_getName {

    @Test
    public void example() {
        {
            // Current thread's thread group is "main"
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            assertNotNull(threadGroup);
            assertEquals("main", threadGroup.getName());
        }
        {
            // We can create a new thread group with a custom name
            ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");
            String name = threadGroup.getName();
            assertEquals("myThreadGroup", name);
        }
    }

}

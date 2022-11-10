package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadGroupExample_activeGroupCount {

    @Test
    public void example() {

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        ThreadGroup system = main.getParent();
        assertEquals("system", system.getName());

        {
            // The system's thread group has 8 active threads (may vary)
            int activeCount = system.activeGroupCount();
            assertEquals(2, activeCount);
        }

        {
            // The current thread group has no child thread groups
            int activeCount = main.activeGroupCount();
            assertEquals(0, activeCount);
        }

        {
            // Create a new thread group under main
            ThreadGroup threadGroup = new ThreadGroup("myThreadGroup");

            // That new thread group appears active even if it has no running threads
            assertEquals(1, main.activeGroupCount());

            // TODO: not clear, they say it's an estimate, but it seems to be quite a bad estimate
        }
    }

}

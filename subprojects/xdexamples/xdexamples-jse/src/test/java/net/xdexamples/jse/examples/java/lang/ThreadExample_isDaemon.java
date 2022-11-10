package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadExample_isDaemon {

    @Test
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public void example() {

        Thread thread = new Thread();

        // By default, threads are not daemon
        {
            boolean isDaemon = thread.isDaemon();
            assertFalse(isDaemon);
        }

        // They can be marked as daemons before before being started
        thread.setDaemon(true);
        {
            boolean isDaemon = thread.isDaemon();
            assertTrue(isDaemon);
        }

    }

}

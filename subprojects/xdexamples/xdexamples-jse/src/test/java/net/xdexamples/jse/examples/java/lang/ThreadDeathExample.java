package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

public class ThreadDeathExample {

    @Test
    @SuppressWarnings("removal")
    public void example() throws InterruptedException {

        // A message will be written here
        AtomicReference<String> ref = new AtomicReference<>();

        // This thread group will write the latest uncaught exception in ref
        ThreadGroup threadGroup = new ThreadGroup("custom") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                ref.set(t.getName() + ": " + e.getClass().getName() + ": " + e.getMessage());
                super.uncaughtException(t, e);
            }
        };

        // This thread is an infinite loop
        Thread thread = new Thread(threadGroup, () -> {
            while (true) {
                Thread.onSpinWait();
            }
        }, "myThread");

        // Start the thread
        thread.start();

        // Wait a bit
        Thread.sleep(10L);

        // Forcibly stop the thread
        thread.stop();

        // Wait a bit
        Thread.sleep(10L);

        // ThreadDeath has been sighted
        assertEquals("myThread: java.lang.ThreadDeath: null", ref.get());
    }

}

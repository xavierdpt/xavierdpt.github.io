package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ThreadExample_defaultUncaughtExceptionHandler {

    @Test
    public void example() throws InterruptedException {
        {
            // The default uncaught exception handler is null by default
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            assertNull(defaultUncaughtExceptionHandler);
        }
        {
            // Remember original default uncaught exceptio nhandler
            // We know it is null here, but it's best practice for the general case
            // and it may not be still be true in the future
            Thread.UncaughtExceptionHandler original = Thread.getDefaultUncaughtExceptionHandler();
            try {

                // Handler will write here
                AtomicReference<String> ref = new AtomicReference<>();

                // The new handler
                Thread.UncaughtExceptionHandler handler = (t, e) ->
                        ref.set(t.getName() + ": " + e.getClass().getName() + ": " + e.getMessage());

                // Set the new handler
                Thread.setDefaultUncaughtExceptionHandler(handler);

                // Create and execute a new thread that will trown an exception
                Thread thread = new Thread(() -> {
                    throw new IllegalStateException("Don't wanna");
                }, "lazy");
                thread.start();
                thread.join();

                // Check that the message has been written
                assertEquals("lazy: java.lang.IllegalStateException: Don't wanna", ref.get());

            } finally {
                // Reset the original handler
                Thread.setDefaultUncaughtExceptionHandler(original);
            }
        }
    }

}

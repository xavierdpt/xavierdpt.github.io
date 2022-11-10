package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ThreadExample_uncaughtExceptionHandler {

    @Test
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public void example() throws InterruptedException {
        {
            // A new thread's uncaught exception handler is exactly its thread group's uncaught handler,
            // which is the thread group itself
            Thread thread = new Thread();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
            assertSame(thread.getThreadGroup(), uncaughtExceptionHandler);
        }
        {
            // Handler will write here
            AtomicReference<String> ref = new AtomicReference<>();

            // The new handler
            Thread.UncaughtExceptionHandler handler = (t, e) -> ref.set(t.getName() + ": " + e.getClass().getName() + ": " + e.getMessage());

            // Create new thread with custom uncaught exception handler
            Thread thread = new Thread(() -> {
                throw new IllegalStateException("Don't wanna");
            }, "lazy");
            thread.setUncaughtExceptionHandler(handler);

            // Star and execute the thread
            thread.start();
            thread.join();

            // Check that the message has been written
            assertEquals("lazy: java.lang.IllegalStateException: Don't wanna", ref.get());


        }
    }


}

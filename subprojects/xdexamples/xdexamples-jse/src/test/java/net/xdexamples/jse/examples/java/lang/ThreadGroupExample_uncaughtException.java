package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

public class ThreadGroupExample_uncaughtException {

    @Test
    public void example() throws InterruptedException {

        // There is hardly any reason to call uncaughtException directly
        // But it can be overriden to change the behavior of the default function

        // Reference to a string that we will use to store the last message
        AtomicReference<String> ref = new AtomicReference<>();

        // New thread group with custom uncaughtException method
        ThreadGroup threadGroup = new ThreadGroup("myThreadGroup") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // Store a message in ref
                ref.set(t.getName() + ": " + e.getClass().getName() + ": " + e.getMessage());
                // Additionally do the default behavior but disable the error stream
                PrintStream err = System.err;
                try {
                    // We do this by having err write to a byte array output stream that will be discarded
                    System.setErr(new PrintStream(new ByteArrayOutputStream()));
                    super.uncaughtException(t, e);
                } finally {
                    // Reset the error stream
                    System.setErr(err);
                }
            }
        };

        // Start a new thread in that thread group
        Thread thread = new Thread(threadGroup, () -> {
            throw new RuntimeException("Don't wanna");
        }, "myThread");
        thread.start();

        // Wait for the thread to terminate and launch its exception
        thread.join();

        // Check that the message has been written
        String content = ref.get();
        assertEquals("myThread: java.lang.RuntimeException: Don't wanna", content);

    }

}

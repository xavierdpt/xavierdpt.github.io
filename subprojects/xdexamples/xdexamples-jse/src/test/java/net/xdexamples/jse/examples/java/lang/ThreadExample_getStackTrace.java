package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ThreadExample_getStackTrace {

    @Test
    public void example() throws InterruptedException {

        // A thread that sleeps
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Start the thread
        thread.start();

        // Wait a bit
        Thread.sleep(100L);

        // Collect it's stack trace
        StackTraceElement[] stackTrace = thread.getStackTrace();

        // Find wether the thread is indeed sleeping
        boolean result = Arrays.stream(stackTrace)
                .map(StackTraceElement::getMethodName)
                .anyMatch("sleep"::equals);

        // Wait for the thread to terminate
        thread.join();

        // Expect to have found that the thread was sleeping
        assertTrue(result);

    }

}

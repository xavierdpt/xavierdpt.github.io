package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;

public class ThreadExample_setName {

    @Test
    public void example() throws InterruptedException {

        AtomicReference<String> ref = new AtomicReference<>();

        // This thread writes its name after 1s
        Thread thread = new Thread(
                () -> {
                    try {
                        Thread.sleep(1000L);
                        ref.set(Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        );

        // We can set the name of a thread before starting it
        thread.setName("myThread");

        {
            // Check the name
            String name = thread.getName();
            assertEquals("myThread", name);
        }

        // Start the thread
        thread.start();

        // Wait a bit
        Thread.sleep(100L);

        // We can also change the thread's name while it's running
        thread.setName("anotherName");

        {
            // Check the name
            String name = thread.getName();
            assertEquals("anotherName", name);
        }

        // Wait for the thread
        thread.join();

        // The thread wrote its new name
        assertEquals("anotherName", ref.get());

    }

}

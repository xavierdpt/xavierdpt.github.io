package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertTrue;

public class ThreadExample_isInterrupted {

    @Test
    public void example() throws InterruptedException {

        // Thread will set this flag when interrupted then exit
        AtomicBoolean flag = new AtomicBoolean();

        // The thread
        Thread thread = new Thread(() -> {
            while (true) {
                // This does not clear the interrupted status
                // TODO: Find a good example that distinguish interrupted and isInterrupted
                if (Thread.currentThread().isInterrupted()) {
                    flag.set(true);
                    break;
                }
                Thread.onSpinWait();
            }
        });
        thread.start();

        // Let it run for a while
        Thread.sleep(1000L);

        // Interrupter thread will interrupt the thread
        Thread interrupter = new Thread(thread::interrupt);
        interrupter.start();

        // Wait for both threads
        thread.join();
        interrupter.join();

        // Check the flag
        assertTrue(flag.get());

    }

}

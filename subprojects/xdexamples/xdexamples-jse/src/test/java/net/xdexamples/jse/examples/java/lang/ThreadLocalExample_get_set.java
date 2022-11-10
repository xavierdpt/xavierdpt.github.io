package net.xdexamples.jse.examples.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static net.xdexamples.support.ExampleSupport.assertInThread;
import static net.xdexamples.support.ExampleSupport.checkThreadExceptions;
import static net.xdexamples.support.ExampleSupport.clearThreadExceptions;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ThreadLocalExample_get_set {

    @Before
    public void before() {
        clearThreadExceptions();
    }

    @Test
    public void example() throws InterruptedException {

        // Initialize a random number generator to sleep random number of times
        // Note: Random is thread safe
        Random random = new Random(System.currentTimeMillis());

        // Initialize a thread local
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        // Each thread will share this anonymous implementation of runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                String threadName = Thread.currentThread().getName();

                // Sleep a random amount of time
                sleep();

                // Check that the thread local is not set for that thread
                assertInThread(() -> {
                    assertNull(threadLocal.get());
                });

                // Sleep again
                sleep();

                // Set the thread local's value to the current thread's name
                threadLocal.set(threadName);

                // Sleep again
                sleep();

                // Checks that the thread's local value didn't change
                assertInThread(() -> {
                    assertEquals(threadName, threadLocal.get());
                });
            }

            private void sleep() {
                try {
                    // This sleeps for up to 1 second
                    Thread.sleep(random.nextLong(100, 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // We're going to start 100 threads all at once
        int THREADCOUNT = 100;

        // Initialize the thread array
        Thread[] threads = new Thread[THREADCOUNT];
        for (int i = 0; i < THREADCOUNT; i++) {
            threads[i] = new Thread(runnable, "thread" + i);
        }

        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads
        for (Thread thread : threads) {
            thread.join();
        }

    }

    @After
    public void after() throws Throwable {
        checkThreadExceptions();
    }
}

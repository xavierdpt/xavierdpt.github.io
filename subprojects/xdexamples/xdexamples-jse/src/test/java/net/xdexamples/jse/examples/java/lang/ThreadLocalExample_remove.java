package net.xdexamples.jse.examples.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.function.Supplier;

import static net.xdexamples.support.ExampleSupport.assertInThread;
import static net.xdexamples.support.ExampleSupport.checkThreadExceptions;
import static net.xdexamples.support.ExampleSupport.clearThreadExceptions;
import static org.junit.Assert.assertEquals;

public class ThreadLocalExample_remove {

    @Before
    public void before() {
        clearThreadExceptions();
    }

    @Test
    public void example() throws InterruptedException {

        // Initialize a random number generator to sleep random number of times
        // Note: Random is thread safe
        Random random = new Random(System.currentTimeMillis());

        // Initialize a thread local with a supplier that counts how many times it is invoked for each thread
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(new Supplier<>() {


            // Since there is only one supplier, the counts per thread are themselves stored in a thread local
            private final ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

            @Override
            public String get() {
                String threadName = Thread.currentThread().getName();
                Integer currentCount = count.get();
                String result = threadName + "-" + currentCount;
                count.set(currentCount + 1);
                return result;
            }
        });

        // Each thread will share this anonymous implementation of runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                String threadName = Thread.currentThread().getName();

                // Sleep a random amount of time
                sleep();

                // Check that the thread local was initialized with the current thread's name and 0
                String expected0 = threadName + "-0";
                assertInThread(() -> {
                    assertEquals(expected0, threadLocal.get());
                });

                // Sleep again
                sleep();

                // Remove the current value
                threadLocal.remove();

                // Sleep again
                sleep();

                // Checks that the thread's local is reinitialized, this time with its count set to 1
                String expected1 = threadName + "-1";
                assertInThread(() -> {
                    assertEquals(expected1, threadLocal.get());
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

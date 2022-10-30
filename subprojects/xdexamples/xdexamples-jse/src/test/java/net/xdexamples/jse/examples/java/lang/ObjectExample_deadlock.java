package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

public class ObjectExample_deadlock {

    @Test
    public void example() throws InterruptedException {
        // This example use synchronized on two objects and two threads to induce a deadlock
        {
            // Two lock objects
            Object lock1 = new Object();
            Object lock2 = new Object();

            // A counter that should be incremented twice
            int[] counter = new int[1];

            // Sleeping will avoid that the first thread completes before the second thread is started
            long SLEEPTIME = 100L;

            // The threads will synchronize on the first lock, then on the second lock
            BiFunction<Object, Object, Thread> threadMaker = (firstLock, secondLock) -> new Thread(() -> {
                try {
                    synchronized (firstLock) {

                        Thread.sleep(SLEEPTIME);
                        synchronized (secondLock) {
                            Thread.sleep(SLEEPTIME);
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    ++counter[0];
                }
            });

            // First thread synchronizes on lock1, then on lock2
            Thread thread1 = threadMaker.apply(lock1, lock2);

            // Second thread synchronizes on lock2, then on lock1
            Thread thread2 = threadMaker.apply(lock2, lock1);

            // Start both threads
            thread1.start();
            thread2.start();

            // Wait for ten times longer than the timeouts
            thread1.join(SLEEPTIME * 10L);
            thread2.join(SLEEPTIME * 10L);

            // Counter was not updated
            assertEquals(0, counter[0]);


        }
    }

}

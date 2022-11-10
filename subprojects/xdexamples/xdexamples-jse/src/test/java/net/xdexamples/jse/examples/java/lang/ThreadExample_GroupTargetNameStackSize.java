package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

public class ThreadExample_GroupTargetNameStackSize {

    @Test
    public void example() throws InterruptedException {

        // stack size is supposed to limit the stack size of a Thread
        // but the JVM may disregard the value

        // And as luck would have it, my JVM seems to not care, so instead I'll try to write a test that can detect
        // when the JVM does care

        // Here we try with a stack size of 1
        double result1 = tryWith(1L);

        // Here we set it to 0, which means, no limit
        double result0 = tryWith(0L);

        // We compute the diff, min and max
        double diff = Math.abs(result0 - result1);
        double min = Math.min(result1, result0);
        double max = Math.max(result1, result0);

        // And do ratios
        double ratioMin = diff / min;
        double ratioMax = diff / max;

        // If the JVM does not care, it should be roughly the same
        // But since the runtime numbers can vary a lot, we compare the ratios with a relatively high error
        assertEquals(ratioMax, 0D, 0.05D);
    }

    private double tryWith(long stackSize) throws InterruptedException {

        // This atomic long will receive the effective stack size
        AtomicLong value = new AtomicLong();

        // We do that many iterations
        int ITERATIONS = 1000;
        // We store the effective stack sizes here
        long[] results = new long[ITERATIONS];

        for (int i = 0; i < ITERATIONS; i++) {

            // The thread group is the current thread's thread group
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();

            // The target will try to find the effective maximum stack size
            Runnable target = () -> value.set(findStackSize(0L));

            // The thread name is "myThread", but it does'nt matter
            String threadName = "myThread";

            // Create the thread
            Thread thread = new Thread(threadGroup, target, threadName, stackSize);

            // Start the thread
            thread.start();

            // Wait for the thread to terminate
            thread.join();

            // Collect the effective stack size
            results[i] = value.get();
        }
        // Return the average value
        return LongStream.of(results).summaryStatistics().getAverage();
    }

    public static long findStackSize(long depth) {
        // To find the stack size, we start an infinite recursion
        try {
            return findStackSize(depth + 1);
        } catch (StackOverflowError error) {
            // We found  a stack overflow error, so return which depth we were at
            return depth;
        }
    }

}

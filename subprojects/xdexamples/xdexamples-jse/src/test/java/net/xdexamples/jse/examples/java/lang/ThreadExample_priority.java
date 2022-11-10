package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.ToDoubleFunction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreadExample_priority {

    @Test
    public void example() throws InterruptedException {

        // This example illustrates the difference between low priority and high priority threads

        // We will do that many iterations
        int ITERATIONS = 10;

        // We will use twice the number of CPUs
        int NPROC = Runtime.getRuntime().availableProcessors();

        // Every thread will do the same thing
        class ExampleThread extends Thread {

            // Reference to the list that is created anew in each iteration
            private final CopyOnWriteArrayList<String> list;


            // Constructor to keep the list around
            public ExampleThread(CopyOnWriteArrayList<String> list) {
                this.list = list;
            }

            @Override
            public void run() {
                try {
                    // Get an RSA KeyPairGenerator, hopefully thread safe
                    KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
                    // generate a key pair, which is costly
                    // and hopefully thread safe in case the key pair generator is statically shared
                    rsa.generateKeyPair();
                    // When done, add the thread name to the list
                    list.add(Thread.currentThread().getName());
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        // We will collect the average positions of high and low priority threads in these two list
        List<Double> lowAverages = new ArrayList<>();
        List<Double> highAverages = new ArrayList<>();

        // Start iterations
        for (int k = ITERATIONS; k > 0; k--) {

            // Initialize the list of names
            CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

            // 2 threads for each CPU
            int NTHREADS = NPROC * 2;
            Thread[] threads = new Thread[NTHREADS];

            // Initialize the threads
            for (int tidx = 0; tidx < threads.length; tidx++) {
                Thread thread = new ExampleThread(list);
                if (tidx % 2 == 0) {
                    // Even indices are minimum priority
                    thread.setPriority(Thread.MIN_PRIORITY);
                    thread.setName("low-" + tidx);
                } else {
                    // Odd indices are high priority
                    thread.setPriority(Thread.MAX_PRIORITY);
                    thread.setName("high-" + tidx);
                }
                threads[tidx] = thread;
            }


            // Check that the priorites are as expected,
            // the current thread group may limit all threads to max priority 1 for example
            for (Thread thread : threads) {
                if (thread.getName().startsWith("high")) {
                    assertEquals(Thread.MAX_PRIORITY, thread.getPriority());
                } else {
                    assertEquals(Thread.MIN_PRIORITY, thread.getPriority());
                }

            }

            // Start all threads
            for (Thread thread : threads) {
                thread.start();
            }

            // Wait for all threads
            for (Thread thread : threads) {
                thread.join();
            }

            // Here we sum the positions of high and low threads
            int highIndices = 0;
            int lowIndices = 0;
            for (int i = 0; i < list.size(); i++) {
                String threadName = list.get(i);
                String prefix = threadName.substring(0, threadName.indexOf("-"));
                if ("high".equals(prefix)) {
                    highIndices += i;
                } else {
                    lowIndices += i;
                }
            }
            // And we record the average positions
            lowAverages.add(lowIndices / (double) NTHREADS);
            highAverages.add(highIndices / (double) NTHREADS);
        }

        // This thing computes the average of a list of Double
        ToDoubleFunction<List<Double>> averager = list -> list.stream()
                .mapToDouble(Double::doubleValue).average().orElse(0D);

        // Here we compute the average of the average position values
        double lowAveragePosition = averager.applyAsDouble(lowAverages);
        double highAveragePosition = averager.applyAsDouble(highAverages);

        // We expect threads of low priority to finish after threads of high priority
        // so the average position of threads of low priority should be higher
        assertTrue(lowAveragePosition > highAveragePosition);
    }

}

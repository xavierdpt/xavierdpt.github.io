package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class ThreadExample_onSpinWait {

    @Test
    public void example() throws NoSuchAlgorithmException, InterruptedException {

        // We do that many iterations for each scenario

        int ITERATIONS = 1000;

        // We record how many times polite sees the flag last in each scenario
        double ratioYield;
        double ratioNoYield;
        {
            // Polite uses Thread.onSpinWait()
            List<String> results = new ArrayList<>();
            for (int i = 0; i < ITERATIONS; ++i) {
                results.add(iteratePoliteYield());
            }
            Map<String, Long> groups = results.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
            // We expect to that polite sees the flag after rude
            Long rp = groups.get("rude polite");
            ratioYield = rp / (double) ITERATIONS;
        }

        {
            // Polite does not use Thread.onSpinWait()
            List<String> results = new ArrayList<>();
            for (int i = 0; i < ITERATIONS; ++i) {
                results.add(iteratePoliteNoYield());
            }
            Map<String, Long> groups = results.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
            // We expect roughly 50% distribution
            Long rp = groups.get("rude polite");
            ratioNoYield = rp / (double) ITERATIONS;
        }
        // So we expect that polite sees the flag after rude more often when using onSpinWait
        // This test seems to statistically work, but the distribution is less marked than when using Thread.yield
        // Thread.yield was 80% in favor of polite
        // Thread.onSpinWait is 60%
        assertTrue(ratioNoYield < ratioYield);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    private static String iteratePoliteYield() throws InterruptedException {

        // The flag is stored here
        AtomicBoolean flag = new AtomicBoolean();

        // Threads will write here
        CopyOnWriteArrayList<String> messages = new CopyOnWriteArrayList<>();


        Thread polite = new Thread(() -> {
            String successMessage = Thread.currentThread().getName();
            while (!flag.get()) {
                // The polite thread is polite here
                Thread.onSpinWait();
            }
            messages.add(successMessage);
        }, "polite");

        // The rude thread does use onSpinWait
        Thread rude = new Thread(() -> {
            String successMessage = Thread.currentThread().getName();
            while (!flag.get()) {
                // Busy waiting like this is not nice
            }
            messages.add(successMessage);
        }, "rude");

        // Start both thread
        polite.start();
        rude.start();

        // Wait a bit
        Thread.sleep(10);

        // Set the flag
        flag.set(true);

        // Wait for both threads to see the flag
        polite.join();
        rude.join();

        // Return who saw the flag when
        String first = messages.get(0);
        String second = messages.get(1);
        return first + " " + second;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    private static String iteratePoliteNoYield() throws InterruptedException {

        // Same scenario, but polite Thread does not use onSpinWait

        AtomicBoolean flag = new AtomicBoolean();

        CopyOnWriteArrayList<String> messages = new CopyOnWriteArrayList<>();

        Thread polite = new Thread(() -> {
            String successMessage = Thread.currentThread().getName();
            while (!flag.get()) {
            }
            messages.add(successMessage);
        }, "polite");

        Thread rude = new Thread(() -> {
            String successMessage = Thread.currentThread().getName();
            while (!flag.get()) {
            }
            messages.add(successMessage);
        }, "rude");

        polite.start();
        rude.start();

        Thread.sleep(10);

        flag.set(true);

        polite.join();
        rude.join();

        String first = messages.get(0);
        String second = messages.get(1);
        return first + " " + second;
    }

}

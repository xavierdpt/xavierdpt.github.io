package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreadExample_run {

    @Test
    @SuppressWarnings("AnonymousHasLambdaAlternative")
    public void example() throws InterruptedException {

        {

            // The Thread's run method can be overriden

            // This holds the flag
            AtomicBoolean flag = new AtomicBoolean();

            // A thread that sets the flag and overrides run()
            Thread thread = new Thread() {
                @Override
                public void run() {
                    flag.set(true);
                }
            };

            // Start the thread
            thread.start();

            // Wait for the thread to terminate
            thread.join();

            // Check the flag
            assertTrue(flag.get());
        }

        {

            // It's more common to use the "target" argument of the Thread constructors

            // The flag
            AtomicBoolean flag = new AtomicBoolean();

            // Threads that sets the flag using the target argument
            Thread thread = new Thread(() -> flag.set(true));

            // Start the thread
            thread.start();

            // Wait for the thread to terminate
            thread.join();

            // Check the flag
            assertTrue(flag.get());
        }

        {

            // The target can even be exported and shared among multiple threads, so here's an occasion for something
            // that may be a bit crazy

            // A shared target
            class SharedTarget implements Runnable {

                // The shared target holds a set of names
                CopyOnWriteArraySet<String> names = new CopyOnWriteArraySet<>();

                @Override
                public void run() {
                    // Each time its runs, it will add the name of its thread to the set of names
                    names.add(Thread.currentThread().getName());
                }

                public Set<String> getNames() {
                    // Return the names
                    return names;
                }
            }

            // We share a single instance of that SharedTarget class in all the threads
            SharedTarget target = new SharedTarget();

            // Separately store the generate names to check later
            Set<String> generatedNames = new HashSet<>();

            // Create one thread for each CPU
            int NTHREADS = Runtime.getRuntime().availableProcessors();
            Thread[] threads = new Thread[NTHREADS];

            // Initialize the threads
            for (int tidx = 0; tidx < NTHREADS; tidx++) {
                String threadName = "myThread-" + tidx;
                threads[tidx] = new Thread(target, threadName);
                generatedNames.add(threadName);
            }

            // Start the threads
            for (Thread thread : threads) {
                thread.start();
            }

            // Wait for the threads to terminate
            for (Thread thread : threads) {
                thread.join();
            }

            // Compare the generated names against what was stored by the target
            assertEquals(generatedNames, target.getNames());

        }
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_TargetConstructor {

    @Test
    @SuppressWarnings("Convert2Lambda")
    public void example() throws InterruptedException {
        int[] value = new int[1];
        {
            // Create a thread with an explicit anonymous instance of Runnable
            Runnable target = new Runnable() {
                @Override
                public void run() {
                    ++value[0];
                }
            };
            Thread thread = new Thread(target);

            // Thread has not been started yet
            assertEquals(0, value[0]);

            // Thread is started but has not run yet
            thread.start();
            assertEquals(0, value[0]);

            // Waiting for the thread to terminate
            thread.join();

            // Thread is terminated and value has been increased
            assertEquals(1, value[0]);
        }
        {
            // Same thing with lambda
            Runnable target = () -> ++value[0];
            Thread thread = new Thread(target);
            assertEquals(1, value[0]);
            thread.start();
            assertEquals(1, value[0]);
            thread.join();
            assertEquals(2, value[0]);
        }
        {
            // Same thing with inlined
            Thread thread = new Thread(() -> ++value[0]);
            assertEquals(2, value[0]);
            thread.start();
            assertEquals(2, value[0]);
            thread.join();
            assertEquals(3, value[0]);
        }
    }

}

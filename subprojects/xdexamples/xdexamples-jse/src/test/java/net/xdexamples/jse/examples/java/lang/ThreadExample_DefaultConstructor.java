package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_DefaultConstructor {

    @Test
    @SuppressWarnings("AnonymousHasLambdaAlternative")
    public void example() throws InterruptedException {

        // The default constructor exists so that subclasses of Thread can define what the run() method doee
        // by overriding it

        int[] value = new int[1];

        Thread thread = new Thread() {
            @Override
            public void run() {
                ++value[0];
            }
        };

        thread.start();

        thread.join();

        assertEquals(1, value[0]);
    }

}

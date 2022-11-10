package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadExample_NameConstructor {

    @Test
    public void example() throws InterruptedException {

        String[] value = new String[1];

        Thread thread = new Thread("myThread") {
            @Override
            public void run() {
                value[0] = "Hello from " + Thread.currentThread().getName();
            }
        };

        thread.start();

        thread.join();

        assertEquals("Hello from myThread", value[0]);

    }

}

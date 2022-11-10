package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class RunnableExample_thread {

    @Test
    public void example() throws InterruptedException {

        StringWriter sw = new StringWriter();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sw.append("hello");
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

        thread.join();

        assertEquals("hello", sw.toString());
    }

}

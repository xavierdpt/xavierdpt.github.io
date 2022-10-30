package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class RunnableExample_explicit {

    @Test
    public void example() {

        StringWriter sw = new StringWriter();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                sw.append("Hello world");
            }
        };

        assertEquals("", sw.toString());

        runnable.run();

        assertEquals("Hello world", sw.toString());
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class RunnableExample_lambda {

    @Test
    public void example() {

        StringWriter sw = new StringWriter();

        Runnable runnable = () -> sw.append("Hello world");

        assertEquals("", sw.toString());

        runnable.run();

        assertEquals("Hello world", sw.toString());
    }

}

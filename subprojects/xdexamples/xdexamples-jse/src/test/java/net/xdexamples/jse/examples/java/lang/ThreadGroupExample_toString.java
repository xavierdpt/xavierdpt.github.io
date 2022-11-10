package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThreadGroupExample_toString {

    @Test
    public void example() {

        // Check that we get a thread group named "main"
        ThreadGroup main = Thread.currentThread().getThreadGroup();
        assertEquals("main", main.getName());

        String result = main.toString();

        // The string representation contains the thread name and its priority
        assertEquals("java.lang.ThreadGroup[name=main,maxpri=10]", result);
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.Assert.assertTrue;

public class ThreadExample_dumpStack {

    @Test
    public void example() {

        // Remember standard error
        PrintStream original = System.err;

        // Redirect standard error
        ByteArrayOutputStream baos;
        try {
            baos = new ByteArrayOutputStream();
            System.setErr(new PrintStream(baos));

            // Dump the current thread's stack to standard error and capture it
            Thread.dumpStack();
        } finally {
            // Reset standard error
            System.setErr(original);
        }

        // Expect at least one line to contains this class name
        String thisClassName = this.getClass().getName();
        assertTrue(new BufferedReader(new StringReader(baos.toString()))
                .lines()
                .anyMatch(line -> line.contains(thisClassName)));

    }

}

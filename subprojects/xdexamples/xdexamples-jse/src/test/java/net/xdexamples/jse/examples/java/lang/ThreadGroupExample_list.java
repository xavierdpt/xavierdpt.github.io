package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class ThreadGroupExample_list {

    @Test
    public void example() {
        // Temporarily redirect stdout to capture it
        PrintStream initial = System.out;
        String result;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));

            // Call list() on the system thread group
            ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();
            system.list();

            result = baos.toString(StandardCharsets.UTF_8);
        } finally {
            System.setOut(initial);
        }

        // Here's what to expect, with possible variations across platforms and Java flavors and versions
        String expected = """
                java.lang.ThreadGroup[name=system,maxpri=10]
                    Thread[Reference Handler,10,system]
                    Thread[Finalizer,8,system]
                    Thread[Signal Dispatcher,9,system]
                    Thread[Attach Listener,5,system]
                    Thread[Notification Thread,9,system]
                    java.lang.ThreadGroup[name=main,maxpri=10]
                        Thread[main,5,main]
                        Thread[Monitor Ctrl-Break,5,main]
                    java.lang.ThreadGroup[name=InnocuousThreadGroup,maxpri=10]
                        Thread[Common-Cleaner,8,InnocuousThreadGroup]
                """;
        result = result.replaceAll("\r\n", "\n");
        assertEquals(expected, result);
    }
}

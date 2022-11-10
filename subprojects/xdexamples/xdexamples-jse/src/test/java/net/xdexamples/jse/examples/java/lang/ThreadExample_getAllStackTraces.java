package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ThreadExample_getAllStackTraces {

    @Test
    public void example() {

        // This class's expected file name
        String expectedFileName = this.getClass().getSimpleName() + ".java";

        // Get the stack traces of all threads
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        // Find all thread names that are currently using this file
        Set<String> result = allStackTraces.entrySet().stream()
                .filter(
                        entry -> Arrays.stream(entry.getValue())
                                .map(StackTraceElement::getFileName)
                                .anyMatch(expectedFileName::equals)
                ).map(Map.Entry::getKey)
                .map(Thread::getName)
                .collect(Collectors.toSet());

        // Expect to see only the main thread
        assertEquals(Set.of("main"), result);
    }

}

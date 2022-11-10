package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DeprecatedExample_forRemoval {

    @Test
    public void example() {

        Deprecated deprecated = DeprecatedExample.A.class.getAnnotation(Deprecated.class);

        // See also https://openjdk.org/jeps/277

        // "forRemoval" is supposed to identify code that will be removed in future versions
        // the idea is that code is mark as Deprecated first, then later marked with forRemoval = true
        // as part of a process to give advance warnings to users before actually removing the code
        boolean forRemoval = deprecated.forRemoval();
        assertTrue(forRemoval);
    }

    @Deprecated(forRemoval = true)
    public static class A {

    }

}

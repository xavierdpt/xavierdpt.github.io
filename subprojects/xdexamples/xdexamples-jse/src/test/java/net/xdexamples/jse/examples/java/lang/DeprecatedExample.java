package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class DeprecatedExample {

    @Test
    public void example() {

        // This annotation is exploited by IDEs and build tools to identify code that is deprecated
        Deprecated deprecated = A.class.getAnnotation(Deprecated.class);

        assertNotNull(deprecated);

        // By default, since is blank (it's new in Java 9)
        String since = deprecated.since();
        assertEquals("", since);

        // By default, forRemoval is false (it's new in Java 9)
        boolean forRemoval = deprecated.forRemoval();
        assertFalse(forRemoval);
    }

    @Deprecated
    public static class A {

    }
}

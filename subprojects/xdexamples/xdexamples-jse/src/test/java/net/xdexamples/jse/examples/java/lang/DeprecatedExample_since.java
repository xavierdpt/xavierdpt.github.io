package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeprecatedExample_since {

    @Test
    public void example() {
        Deprecated deprecated = DeprecatedExample.A.class.getAnnotation(Deprecated.class);

        // Since can be use to store any String, but it expects something that should be a version String
        String since = deprecated.since();
        assertEquals("1.0.0", since);
    }

    @Deprecated(since = "1.0.0")
    public static class A {

    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class BooleanExample_type {

    @Test
    public void example() {

        // Retrive the value of the TYPE constant
        Class<Boolean> type = Boolean.TYPE;

        // The TYPE constant holds the type of the primitive counterpart
        assertSame(boolean.class, type);
    }
}

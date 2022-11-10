package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ByteExample_type {
    @Test
    public void example() {

        // Retrive the value of the TYPE constant
        Class<Byte> type = Byte.TYPE;

        // The TYPE constant holds the type of the primitive counterpart
        assertSame(byte.class, type);
    }
}

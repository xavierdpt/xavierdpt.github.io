package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class StringExample_stringConstructor {

    @Test
    @SuppressWarnings("StringOperationCanBeSimplified")
    public void example() {

        // When creating a new string with the constructor, it is a real copy of that string
        String string = new String("hello");

        // It's equal
        assertEquals("hello", string);

        // But not the same
        assertNotSame("hello",string);
    }

}

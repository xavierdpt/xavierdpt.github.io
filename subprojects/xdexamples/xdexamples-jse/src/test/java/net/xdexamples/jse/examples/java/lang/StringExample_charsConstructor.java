package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringExample_charsConstructor {

    @Test
    public void example() {
        // A string constructed from an array of chars
        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        String string = new String(chars);
        assertEquals("hello", string);
    }

}

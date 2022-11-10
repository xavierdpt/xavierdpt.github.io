package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringExample_stringBuilderConstructor {

    @Test
    public void example() {

        // better use the ::toString method to get the final string

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello");

        String string = new String(stringBuilder);
        assertEquals("hello", string);
    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class StringExample_defaultConstructor {

    @Test
    @SuppressWarnings("StringOperationCanBeSimplified")
        public void example() {

        // When creating a new string with the constructor, it is the empty string but not THE empty string
        String string = new String();

        // It's equal
        assertEquals("", string);

        // But not the same
        assertNotSame("",string);

    }

}

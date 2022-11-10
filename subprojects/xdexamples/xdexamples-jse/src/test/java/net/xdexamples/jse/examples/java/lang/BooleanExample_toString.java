package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooleanExample_toString {

    @Test
    public void example() {

        // TRUE -> "true"
        // FALSE -> "false"

        {
            Boolean b = Boolean.TRUE;
            String string = b.toString();
            assertEquals("true", string);
        }

        {
            Boolean b = Boolean.FALSE;
            String string = b.toString();
            assertEquals("false", string);
        }
    }
}

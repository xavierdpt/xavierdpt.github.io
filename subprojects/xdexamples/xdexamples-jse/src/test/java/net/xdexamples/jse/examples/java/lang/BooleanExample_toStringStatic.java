package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooleanExample_toStringStatic {

    @Test
    public void example() {

        // true -> "true"
        // false -> "false"

        {
            boolean value = true;
            String string = Boolean.toString(value);
            assertEquals("true", string);
        }

        {
            boolean value = false;
            String string = Boolean.toString(value);
            assertEquals("false", string);
        }

    }

}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooleanExample_compare {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        // returns -1, 0 or 1 depending on the values of b
        {
            // false, false -> 0
            boolean b1f = false;
            boolean b2f = false;
            int result = Boolean.compare(b1f, b2f);
            assertEquals(0, result);
        }
        {
            // false, true -> -1
            boolean b1f = false;
            boolean b2t = true;
            int result = Boolean.compare(b1f, b2t);
            assertEquals(-1, result);
        }
        {
            // true, false -> 1
            boolean b1t = true;
            boolean b2f = false;
            int result = Boolean.compare(b1t, b2f);
            assertEquals(1, result);
        }
        {
            // true, true -> 0
            boolean b1t = true;
            boolean b2t = true;
            int result = Boolean.compare(b1t, b2t);
            assertEquals(0, result);
        }
    }

}

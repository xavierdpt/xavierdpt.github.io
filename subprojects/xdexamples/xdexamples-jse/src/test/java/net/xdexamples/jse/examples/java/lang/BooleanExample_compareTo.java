package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BooleanExample_compareTo {

    @Test
    public void example() {
        // returns -1, 0 or 1 depending on the values of b
        {
            // false, false -> 0
            Boolean b1f = Boolean.FALSE;
            Boolean b2f = Boolean.FALSE;
            int result = b1f.compareTo(b2f);
            assertEquals(0, result);
        }
        {
            // false, true -> -1
            Boolean b1f = Boolean.FALSE;
            Boolean b2t = Boolean.TRUE;
            int result = b1f.compareTo(b2t);
            assertEquals(-1, result);
        }
        {
            // true, false -> 1
            Boolean b1t = Boolean.TRUE;
            Boolean b2f = Boolean.FALSE;
            int result = b1t.compareTo(b2f);
            assertEquals(1, result);
        }
        {
            // true, true -> 0
            Boolean b1t = Boolean.TRUE;
            Boolean b2t = Boolean.TRUE;
            int result = b1t.compareTo(b2t);
            assertEquals(0, result);
        }
        {
            // This means that the natural order is TRUE, then FALSE
            ArrayList<Boolean> list = new ArrayList<>(asList(Boolean.TRUE, Boolean.FALSE));
            Collections.sort(list);
            assertArrayEquals(new Boolean[]{Boolean.FALSE, Boolean.TRUE}, list.toArray());
        }
    }
}

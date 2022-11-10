package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExample_contentEqualsStringBuffer {

    @Test
    @SuppressWarnings("StringBufferMayBeStringBuilder")
    public void example() {
        // specific method to compare a StringBuffer
        {
            String string = "hello";

            StringBuffer other = new StringBuffer();
            other.append("hello");

            boolean result = string.contentEquals(other);
            assertTrue(result);
        }
        {
            String string = "hello";

            StringBuffer other = new StringBuffer();
            other.append("world");

            boolean result = string.contentEquals(other);
            assertFalse(result);
        }
    }

}

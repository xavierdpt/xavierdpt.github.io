package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringExample_isEmpty {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        // No surprise here
        {
            String string = "";
            boolean empty = string.isEmpty();
            assertTrue(empty);
        }
        {
            String string = "hello";
            boolean empty = string.isEmpty();
            assertFalse(empty);
        }
    }

}

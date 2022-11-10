package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BooleanExample_logicalXor {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {

        // Truth table of the logical "XOR" operator
        {
            boolean value1 = false;
            boolean value2 = false;
            boolean result = Boolean.logicalXor(value1, value2);
            assertFalse(result);
        }
        {
            boolean value1 = false;
            boolean value2 = true;
            boolean result = Boolean.logicalXor(value1, value2);
            assertTrue(result);
        }
        {
            boolean value1 = true;
            boolean value2 = false;
            boolean result = Boolean.logicalXor(value1, value2);
            assertTrue(result);
        }
        {
            boolean value1 = true;
            boolean value2 = true;
            boolean result = Boolean.logicalXor(value1, value2);
            assertFalse(result);
        }
    }
}

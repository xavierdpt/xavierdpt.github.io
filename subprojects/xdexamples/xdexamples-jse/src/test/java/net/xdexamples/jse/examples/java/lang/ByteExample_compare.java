package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ByteExample_compare {

    @Test
    @SuppressWarnings({"ConstantConditions", "EqualsWithItself"})
    public void example() {
        {
            // a < b => compare(a,b) < 0
            byte value1 = (byte) 1;
            byte value2 = (byte) 2;
            int result = Byte.compare(value1, value2);
            assertTrue(result < 0);
        }
        {
            // a > b => compare(a,b) > 0
            byte value1 = (byte) 2;
            byte value2 = (byte) 1;
            int result = Byte.compare(value1, value2);
            assertTrue(result > 0);
        }
        {
            // a = b => compare(a,b) = 0
            byte value1 = (byte) 1;
            int result = Byte.compare(value1, value1);
            assertEquals(0, result);
        }
    }

}

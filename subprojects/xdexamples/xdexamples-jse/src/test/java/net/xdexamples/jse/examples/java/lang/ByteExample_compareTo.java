package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ByteExample_compareTo {

    @Test
    @SuppressWarnings({"EqualsWithItself", "UnnecessaryBoxing"})
    public void example() {
        {
            // a < b => a.compareTo(b) < 0
            Byte value1 = Byte.valueOf((byte) 1);
            Byte value2 = Byte.valueOf((byte) 2);
            int result = value1.compareTo(value2);
            assertTrue(result < 0);
        }
        {
            // a > b => a.compareTo(b) > 0
            Byte value1 = Byte.valueOf((byte) 2);
            Byte value2 = Byte.valueOf((byte) 1);
            int result = value1.compareTo(value2);
            assertTrue(result > 0);
        }
        {
            // a = b => a.compareTo(b) = 0
            Byte value = Byte.valueOf((byte) 1);
            int result = value.compareTo(value);
            assertEquals(0, result);
        }
    }

}

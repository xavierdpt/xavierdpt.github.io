package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_toUnsignedLong {
    @Test
    public void example() {
        {
            // Max value
            byte value = Byte.MAX_VALUE;
            // As an unsigned long
            long result = Byte.toUnsignedLong(value);
            // Is 127, no surprise
            assertEquals(127, result);
        }

        {
            // Min value
            byte value = Byte.MIN_VALUE;
            // As an unsigned long
            long result = Byte.toUnsignedLong(value);
            // Is 128 (not -128)
            assertEquals(128, result);
        }

        {
            // Minus one
            byte value = -1;
            // As an unsigned long
            long result = Byte.toUnsignedLong(value);
            // is 255 because in 2's complement notation, all eight bits are set to 1 for -1
            assertEquals(255, result);
        }


        {
            // Here we increment a byte starting from 0 for 255 iteratoins
            // It will start at 0 up to 127, then wrap around to -128 up to -1
            // As it does this, the bits seen as integer are 0 up to 255
            byte value = 0;
            for (long c = 0L; c <= 255; c++) {
                assertEquals(c, Byte.toUnsignedLong(value));
                ++value;
            }
        }
    }

}

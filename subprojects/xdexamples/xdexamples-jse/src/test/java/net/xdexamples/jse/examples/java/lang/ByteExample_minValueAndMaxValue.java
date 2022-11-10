package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_minValueAndMaxValue {

    @Test
    public void example() {

        // The range of a (signed) byte is [-128, 127]

        byte minValue = Byte.MIN_VALUE;
        byte maxValue = Byte.MAX_VALUE;

        assertEquals(-128, minValue);
        assertEquals(127, maxValue);

    }

}

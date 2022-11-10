package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class NumberExample_values {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void example() {

        // This example illustrates that using the ...Value() functions on the Number interface
        // are equivalent to casting

        // We initialize a random number generator
        Random random = new Random(System.currentTimeMillis());

        // We obtain a random primitive double, but we could use any other number type
        double aDouble = random.nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);

        // We box that primitive double into a Double that we treated as a Number
        // All boxed number types implement the Number interface
        Number number = Double.valueOf(aDouble);

        // We downcast the random double pritive to the other primitive number types
        float aFloat = (float) aDouble;
        long aLong = (long) aDouble;
        int anInt = (int) aDouble;
        short aShort = (short) aDouble;
        byte aByte = (byte) aDouble;

        // We check that calling the ...Value() functions on Number is the same as casting
        assertEquals(aDouble, number.doubleValue(), 0D);
        assertEquals(aFloat, number.floatValue(), 0D);
        assertEquals(aLong, number.longValue());
        assertEquals(anInt, number.intValue());
        assertEquals(aShort, number.shortValue());
        assertEquals(aByte, number.byteValue());
    }
}

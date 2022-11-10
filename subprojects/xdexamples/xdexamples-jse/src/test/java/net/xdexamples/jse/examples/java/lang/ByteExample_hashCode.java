package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class ByteExample_hashCode {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void example() {

        // This example illustrates the use of both hashCode methods

        {// Create a random byte by filling a byte array of one byte
            Random random = new Random(System.currentTimeMillis());
            byte[] bytes = new byte[1];
            random.nextBytes(bytes);
            byte value = bytes[0];

            // Boxed value
            Byte b = Byte.valueOf(value);

            // Check that the hashCode is the same
            assertEquals(b.hashCode(), Byte.hashCode(value));
        }

        {
            // Check that all byte's hash codes are different
            Set<Integer> hashCodes = new HashSet<>();
            byte b = Byte.MIN_VALUE;
            do {
                hashCodes.add(Byte.hashCode(b));
                ++b;
            } while (b != Byte.MIN_VALUE);
            assertEquals(256, hashCodes.size());
        }
    }

}

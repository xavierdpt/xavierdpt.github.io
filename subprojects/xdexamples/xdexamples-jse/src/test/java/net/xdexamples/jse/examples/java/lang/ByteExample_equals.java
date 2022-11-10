package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class ByteExample_equals {

    @Test
    @SuppressWarnings({"UnnecessaryBoxing", "ConstantConditions"})
    public void example() {
        // Create a random byte by filling an array of one byte
        Random random = new Random(System.currentTimeMillis());
        byte[] bytes = new byte[1];
        random.nextBytes(bytes);

        // Box the values in two different isntance
        Byte byte1 = Byte.valueOf(bytes[0]);
        Byte byte2 = Byte.valueOf(bytes[0]);

        // Compute equality
        boolean result = byte1.equals(byte2);

        // Equality is indeed true
        assertTrue(result);

        // And the instance are the same because the underlying Java implemention uses constant pooling for bytes
        assertSame(byte1, byte2);
    }
}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

public class ByteExample_bytesAndSize {

    @Test
    public void example() {

        // A byte takes 8 bits = 1 byte

        int size = Byte.SIZE;
        int bytes = Byte.BYTES;

        Assert.assertEquals(8, size);
        Assert.assertEquals(1, bytes);
    }
}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_parseByte {

    @Test
    public void example() {
        // This method delegates to parseByte with radix 10, so not much to say here
        String input = "10";
        byte result = Byte.parseByte(input);
        assertEquals((byte) 10, result);
    }

}

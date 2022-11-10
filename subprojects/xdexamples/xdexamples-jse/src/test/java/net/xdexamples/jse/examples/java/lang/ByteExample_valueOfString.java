package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_valueOfString {

    @Test
    @SuppressWarnings("WrapperTypeMayBePrimitive")
    public void example() {
        // This method delegates to valueOf with radix 10, so not much more to say here
        String input = "10";
        Byte result = Byte.valueOf(input);
        assertEquals((byte) 10, result.byteValue());
    }

}

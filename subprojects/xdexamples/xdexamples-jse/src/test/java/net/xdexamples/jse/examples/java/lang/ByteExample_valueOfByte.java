package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_valueOfByte {

    @Test
    @SuppressWarnings({"ConstantConditions", "UnnecessaryBoxing"})
    public void example() {
        // valueOf on a primitive byte creates a boxed version
        byte primitive = 0;
        Byte boxed = Byte.valueOf(primitive);
        assertEquals(primitive, boxed.byteValue());
    }
}

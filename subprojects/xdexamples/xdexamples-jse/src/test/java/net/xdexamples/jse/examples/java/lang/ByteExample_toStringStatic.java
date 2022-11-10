package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_toStringStatic {

    @Test
    public void example() {
        // convert byte to String
        {
            byte value = Byte.MIN_VALUE;
            String string = Byte.toString(value);
            assertEquals("-128", string);
        }
        {
            byte value = Byte.MAX_VALUE;
            String string = Byte.toString(value);
            assertEquals("127", string);
        }
    }
}

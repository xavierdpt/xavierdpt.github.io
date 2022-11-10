package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_toString {

    @Test
    @SuppressWarnings("UnnecessaryBoxing")
    public void example() {
        // convert Byte to String
        {
            Byte value = Byte.valueOf(Byte.MIN_VALUE);
            String string = value.toString();
            assertEquals("-128", string);
        }
        {
            Byte value = Byte.valueOf(Byte.MAX_VALUE);
            String string = value.toString();
            assertEquals("127", string);
        }
    }
}

package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

public class ByteExample_valueOfStringWithRadix {

    @Test
    public void example() {
        // This method delegates to parseByte and returns a boxed value instead of a primitive
        // so not much ore to say here
        String input = "10";
        int radix = 3;
        Byte result = Byte.valueOf(input, radix);
        Assert.assertEquals((byte) 3, result.byteValue());
    }

}

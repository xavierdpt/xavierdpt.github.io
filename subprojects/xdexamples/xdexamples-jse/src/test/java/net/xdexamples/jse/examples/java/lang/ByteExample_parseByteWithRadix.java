package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ByteExample_parseByteWithRadix {

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void example() {
        // This method delegates to Integer::parseInt, so refer to the same method in Integer for more examples
        // The only addition is that it checks that the result is a byte value, then cast the returned integer
        // to a byte
        {
            String input = "10";
            int radix = 3;
            byte result = Byte.parseByte(input, radix);
            assertEquals((byte) 3, result);
        }
        {
            String input = "1000";
            int radix = 10;
            Assert.assertThrows(NumberFormatException.class, () -> {
                Byte.parseByte(input, radix);
            });
        }
    }

}

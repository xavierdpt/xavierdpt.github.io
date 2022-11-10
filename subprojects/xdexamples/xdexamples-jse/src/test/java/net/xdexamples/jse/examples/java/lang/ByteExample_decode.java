package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class ByteExample_decode {

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void example() {
        // This method delegates to Integer::decode and checks the value range, see Integer for more examples
        {
            String input = "10";
            Byte result = Byte.decode(input);
            assertEquals((byte) 10, result.byteValue());
        }
        {
            String input = "1000";
            assertThrows(NumberFormatException.class, () -> {
                Byte.decode(input);
            });
        }
    }

}

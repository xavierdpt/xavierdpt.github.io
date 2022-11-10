package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class ByteExample_compareUnsigned {


    @Test
    @SuppressWarnings({"ComparatorCombinators", "UnnecessaryBoxing", "UnnecessaryUnboxing"})
    public void example() {
        {
            byte value1 = (byte) 0;
            byte value2 = Byte.MAX_VALUE; // 127
            int result = Byte.compareUnsigned(value1, value2);
            assertTrue(result < 0);
        }
        {
            byte value1 = Byte.MAX_VALUE; // 127
            byte value2 = Byte.MIN_VALUE; // -128 signed, but 128 unsigned
            int result = Byte.compareUnsigned(value1, value2);
            assertTrue(result < 0);
        }
        {
            byte value1 = Byte.MIN_VALUE; // -128 signed, but 128 unsigned
            byte value2 = (byte) -1; // -1 signed, but 255 unsigned
            int result = Byte.compareUnsigned(value1, value2);
            assertTrue(result < 0);
        }
        {
            // The four bytes above as boxed value
            Byte zero = Byte.valueOf((byte) 0);
            Byte max = Byte.valueOf(Byte.MAX_VALUE);
            Byte min = Byte.valueOf(Byte.MIN_VALUE);
            Byte minusOne = Byte.valueOf((byte) -1);

            // List of those bytes
            List<Byte> list = new ArrayList<>(Arrays.asList(zero, max, min, minusOne));

            // Sort according to compareUnsigned
            list.sort((one, another) -> Byte.compareUnsigned(
                    one.byteValue(),
                    another.byteValue()
            ));

            // Check the order
            assertArrayEquals(
                    new Byte[]{zero, max, min, minusOne},
                    list.toArray(Byte[]::new)
            );

            // Sort according to natural signed order
            list.sort((one, another) -> Byte.compare(
                    one.byteValue(),
                    another.byteValue()
            ));

            // Check the order
            assertArrayEquals(
                    new Byte[]{min,minusOne,zero, max},
                    list.toArray(Byte[]::new)
            );
        }
    }

    @Test
    public void exampleNoWarnings() {
        // same as above with no warnings
        // it would be nice to compare the bytecode of both methods and see if there are any differences
        // boxing/unboxing has a real performance cost, hiding it in the syntax is convenient but makes it more
        // difficult to identify possible performance issues
        {
            // The four bytes above as boxed value
            Byte zero = (byte) 0;
            Byte max = Byte.MAX_VALUE;
            Byte min = Byte.MIN_VALUE;
            Byte minusOne = (byte) -1;

            // List of those bytes
            List<Byte> list = new ArrayList<>(Arrays.asList(zero, max, min, minusOne));

            // Sort according to compareUnsigned
            list.sort(Byte::compareUnsigned);

            // Check the order
            assertArrayEquals(
                    new Byte[]{zero, max, min, minusOne},
                    list.toArray(Byte[]::new)
            );

            // Sort according to natural signed order
            list.sort(Byte::compare);

            // Check the order
            assertArrayEquals(
                    new Byte[]{min,minusOne,zero, max},
                    list.toArray(Byte[]::new)
            );
        }
    }
}

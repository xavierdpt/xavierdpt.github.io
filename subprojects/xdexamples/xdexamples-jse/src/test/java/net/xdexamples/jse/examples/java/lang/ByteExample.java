package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;
import net.xdexamples.BaseExample;
import xdtest.ToBeContinued;

import java.lang.constant.DynamicConstantDesc;
import java.util.Optional;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


@ToBeContinued
public class ByteExample extends BaseExample<Byte> {

    @Override
    protected void scaffold(Byte instance) throws Throwable {
        {
            String result = instance.toString();
            seeExamples(this::toStringExample);
            ignore(result);
        }
        {
            // TODO
            Optional<DynamicConstantDesc<Byte>> byteDynamicConstantDesc = instance.describeConstable();
            ignore(byteDynamicConstantDesc);
        }
        byte b__ = 0;
        {
            // TODO
            byte value = 0;
            Byte b = Byte.valueOf(value);
            ignore(b);
        }
        int radix__ = 0;
        String s__ = null;
        {
            // TODO
            String string = null;
            int radix = 0;
            Byte b = Byte.valueOf(string, radix);
            ignore(b);
        }
        {
            // TODO
            byte string = 0;
            Byte b = Byte.valueOf(string);
            ignore(b);
        }
        {
            // TODO
            String string = null;
            byte b = Byte.parseByte(string);
            ignore(b);
        }
        {
            // TODO
            String string = null;
            int radix = 0;
            byte b = Byte.parseByte(string, radix);
            ignore(b);
        }
        {
            // TODO
            String string = null;
            Byte b = Byte.decode(string);
            ignore(b);
        }
        {
            byte value = instance.byteValue();
            seeOthers(NumberExample.class);
            ignore(value);
        }
        {
            short value = instance.shortValue();
            seeOthers(NumberExample.class);
            ignore(value);
        }
        {
            int value = instance.intValue();
            seeOthers(NumberExample.class);
            ignore(value);
        }
        {
            long value = instance.longValue();
            seeOthers(NumberExample.class);
            ignore(value);
        }
        {
            float value = instance.floatValue();
            seeOthers(NumberExample.class);
            ignore(value);
        }
        {
            double value = instance.doubleValue();
            seeOthers(NumberExample.class);
            ignore(value);
        }
        {
            byte value = 0;
            String result = Byte.toString(value);
            seeExamples(this::toStringStaticExample);
            ignore(result);
        }
        {
            int result = instance.hashCode();
            seeOthers(ObjectExample.class);
            ignore(result);
        }
        {
            int result = Byte.hashCode(b__);
            seeExamples(this::hashCodeExample);
            ignore(result);
        }
        Byte other__ = any();
        {
            Byte other = any();
            boolean result = instance.equals(other);
            seeOthers(ObjectExample.class);
            ignore(result);
        }
        {
            Byte other = any();
            int result = instance.compareTo(other);
            seeOthers(ComparableExample.class);
            ignore(result);
        }
        {
            byte value1 = 0;
            byte value2 = 0;
            int result = Byte.compare(value1, value2);
            seeExamples(this::compareExample);
            ignore(result);
        }
        {
            byte value1 = 0;
            byte value2 = 0;
            int result = Byte.compareUnsigned(value1, value2);
            seeExamples(this::compareUnsignedExample);
            ignore(result);
        }
        {
            byte value = 0;
            int result = Byte.toUnsignedInt(value);
            seeExamples(this::toUnsignedIntExample);
            ignore(result);
        }
        {
            byte value = 0;
            long result = Byte.toUnsignedLong(value);
            seeExamples(this::toUnsignedLongExample);
            ignore(result);
        }
        {
            byte minValue = Byte.MIN_VALUE;
            seeExamples(this::minValueExample);
            ignore(minValue);
        }
        {
            byte maxValue = Byte.MAX_VALUE;
            seeExamples(this::maxValueExample);
            ignore(maxValue);
        }
        {
            Class<Byte> type = Byte.TYPE;
            seeExamples(this::typeExample);
            ignore(type);
        }
        {
            int size = Byte.SIZE;
            seeExamples(this::sizeExample);
            ignore(size);
        }
        {
            int bytes = Byte.BYTES;
            seeExamples(this::bytesExample);
            ignore(bytes);
        }
    }

    @Test
    public void bytesExample() {
        int bytes = Byte.BYTES;
        assertEquals(1, bytes);
    }

    @Test
    public void sizeExample() {
        int size = Byte.SIZE;
        assertEquals(8, size);
    }

    @Test
    public void typeExample() {
        Class<Byte> type = Byte.TYPE;
        assertSame(byte.class, type);
    }

    @Test
    public void minValueExample() {
        byte minValue = Byte.MIN_VALUE;
        assertEquals(-128, minValue);
    }

    @Test
    public void maxValueExample() {
        byte maxValue = Byte.MAX_VALUE;
        assertEquals(127, maxValue);
    }

    @Test
    public void toUnsignedLongExample() {
        {
            byte value = Byte.MAX_VALUE;
            long result = Byte.toUnsignedLong(value);
            assertEquals(127L, result);
        }

        {
            byte value = Byte.MIN_VALUE;
            long result = Byte.toUnsignedLong(value);
            assertEquals(128L, result);
        }

        {
            byte value = Byte.parseByte("-1");
            long result = Byte.toUnsignedLong(value);
            assertEquals(255L, result);
        }


        {
            byte value = 0;
            for (long c = 0; c <= 255; c++) {
                assertEquals(c, Byte.toUnsignedLong(value));
                ++value; // Wraps around: 0, 1, 2, ..., 126, 127, -128, -127, ..., -1
            }
        }
    }

    @Test
    public void toUnsignedIntExample() {
        {
            byte value = Byte.MAX_VALUE;
            int result = Byte.toUnsignedInt(value);
            assertEquals(127, result);
        }

        {
            byte value = Byte.MIN_VALUE;
            int result = Byte.toUnsignedInt(value);
            assertEquals(128, result);
        }

        {
            byte value = Byte.parseByte("-1");
            int result = Byte.toUnsignedInt(value);
            assertEquals(255, result);
        }


        {
            byte value = 0;
            for (int c = 0; c <= 255; c++) {
                assertEquals(c, Byte.toUnsignedLong(value));
                ++value; // Wraps around: 0, 1, 2, ..., 126, 127, -128, -127, ..., -1
            }
        }
    }

    @Test
    public void compareExample() {
        {
            byte value1 = (byte) 1;
            byte value2 = (byte) 2;
            int result = Byte.compare(value1, value2);
            assertTrue(result < 0);
        }
        {
            byte value1 = (byte) 2;
            byte value2 = (byte) 1;
            int result = Byte.compare(value1, value2);
            assertTrue(result > 0);
        }
        {
            byte value1 = (byte) 1;
            int result = Byte.compare(value1, value1);
            assertEquals(0, result);
        }
    }

    @Test
    public void compareUnsignedExample() {
        {
            byte value1 = (byte) 0;
            byte value2 = Byte.MAX_VALUE; // 127
            int result = Byte.compareUnsigned(value1, value2);
            assertTrue(result < 0);
        }
        {
            byte value1 = Byte.MAX_VALUE; // 127
            byte value2 = Byte.MIN_VALUE; // 128
            int result = Byte.compareUnsigned(value1, value2);
            assertTrue(result < 0);
        }
        {
            byte value1 = Byte.MIN_VALUE; // 128
            byte value2 = (byte) -1; // 255
            int result = Byte.compareUnsigned(value1, value2);
            assertTrue(result < 0);
        }

    }

    @Test
    public void hashCodeExample() {
        // Create a random byte
        Random random = new Random(System.currentTimeMillis());
        byte[] bytes = new byte[1];
        random.nextBytes(bytes);
        byte value = bytes[0];

        // Boxed version
        Byte b = Byte.valueOf(value);

        // Check that the hashCode is the same
        assertEquals(b.hashCode(), Byte.hashCode(value));
    }

    @Test
    public void toStringExample() {
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

    @Test
    public void toStringStaticExample() {
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

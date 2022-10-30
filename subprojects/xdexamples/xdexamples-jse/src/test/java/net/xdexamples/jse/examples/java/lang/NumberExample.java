package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;
import net.xdexamples.BaseExample;
import net.xdexamples.AllMethodsCovered;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

import static org.junit.Assert.assertEquals;

@AllMethodsCovered
public class NumberExample extends BaseExample<Number> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(Number instance) throws Throwable {
        {
            byte value = instance.byteValue();
            seeExamples(this::example);
        }
        {
            short value = instance.shortValue();
            seeExamples(this::example);
        }
        {
            int value = instance.intValue();
            seeExamples(this::example);
        }
        {
            float value = instance.floatValue();
            seeExamples(this::example);
        }
        {
            double value = instance.doubleValue();
            seeExamples(this::example);
        }
    }

    @Test
    public void example() {

        Number number = 5D;

        byte expectedByte = 5;
        byte expectedShort = 5;
        int expectedInt = 5;
        long expectedLong = 5L;
        float expectedFloat = 5F;
        double expectedDouble = 5D;

        // Casting is performed according to rules for implicit casts
        assertEquals(expectedByte, number.byteValue());
        assertEquals(expectedShort, number.shortValue());
        assertEquals(expectedInt, number.intValue());
        assertEquals(expectedLong, number.longValue());
        assertEquals(expectedFloat, number.floatValue(), 0F);
        assertEquals(expectedDouble, number.doubleValue(), 0D);
    }

    @Test
    public void subclasses() {
        for (Class<? extends Number> clazz : Arrays.asList(
                Byte.class,
                Short.class,
                Integer.class,
                Long.class,
                Float.class,
                Double.class,

                BigInteger.class,
                BigDecimal.class,

                AtomicInteger.class,
                AtomicLong.class,

                LongAdder.class,
                DoubleAdder.class,

                LongAccumulator.class,
                DoubleAccumulator.class
        )) {
            Number.class.isAssignableFrom(clazz);
        }
    }


}

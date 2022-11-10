package net.xdexamples.jse.index.java.lang;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

import static java.util.Arrays.asList;

public class NumberExample_subTypes {
    @Test
    public void example() {

        // Here we mention other types that implement the Number interface

        for (Class<? extends Number> clazz : asList(
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

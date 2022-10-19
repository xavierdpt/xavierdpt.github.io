package xd.examples.java.util.concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {

    public void index() {
        if (skip()) {
            ignore(asList(
                    AtomicBoolean.class,
                    AtomicInteger.class,
                    AtomicIntegerArray.class,
                    AtomicIntegerFieldUpdater.class,
                    AtomicLong.class,
                    AtomicLongArray.class,
                    AtomicLongFieldUpdater.class,
                    AtomicMarkableReference.class,
                    AtomicReference.class,
                    AtomicReferenceArray.class,
                    AtomicReferenceFieldUpdater.class,
                    AtomicStampedReference.class,
                    DoubleAccumulator.class,
                    DoubleAdder.class,
                    LongAccumulator.class,
                    LongAdder.class
            ));
        }
    }

}

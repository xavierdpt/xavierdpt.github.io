package net.xdexamples.jse.examples.java.util.stream;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;

import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamSupportExample extends BaseExample<StreamSupport> {

    @Override
    public void scaffold(StreamSupport instance) {

        Spliterator<Dummy> spliterator = null;
        Supplier<Spliterator<Dummy>> supplier = null;
        boolean parallel = false;
        int characteristics = 0;

        Spliterator.OfInt iSpliterator = null;
        Supplier<Spliterator.OfInt> iSupplier = null;

        Spliterator.OfLong lSpliterator = null;
        Supplier<Spliterator.OfLong> lSupplier = null;

        Spliterator.OfDouble dSpliterator = null;
        Supplier<Spliterator.OfDouble> dSupplier = null;

        Stream<Dummy> stream = StreamSupport.stream(spliterator, parallel);
        Stream<Dummy> stream1 = StreamSupport.stream(supplier, characteristics, parallel);

        IntStream intStream = StreamSupport.intStream(iSpliterator, parallel);
        IntStream intStream1 = StreamSupport.intStream(iSupplier, characteristics, parallel);

        LongStream longStream = StreamSupport.longStream(lSpliterator, parallel);
        LongStream longStream1 = StreamSupport.longStream(lSupplier, characteristics, parallel);


        DoubleStream doubleStream = StreamSupport.doubleStream(dSpliterator, parallel);
        DoubleStream doubleStream1 = StreamSupport.doubleStream(dSupplier, characteristics, parallel);
    }

}

package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.util.SplittableRandom;
import java.util.random.RandomGenerator.SplittableGenerator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Scaffolded
public class SplittableRandomExample extends BaseExample<SplittableRandom> {

    @Override
    public void scaffold(SplittableRandom instance) {
        long seed = 0;
        ignore(
                new SplittableRandom(),
                new SplittableRandom(seed)
        );

        SplittableGenerator source = null;
        long streamSize = 0;
        int origin = 0;
        int bound = 0;
        long lorigin = 0;
        long lbound = 0;
        double dorigin = 0;
        double dbound = 0;

        SplittableRandom split = instance.split();
        SplittableRandom split1 = instance.split(source);

        int i = instance.nextInt();

        long l = instance.nextLong();

        byte[] bytes = new byte[0];
        instance.nextBytes(bytes);

        Stream<SplittableGenerator> splits = instance.splits();
        Stream<SplittableGenerator> splits1 = instance.splits(streamSize);
        Stream<SplittableGenerator> splits2 = instance.splits(source);
        Stream<SplittableGenerator> splits3 = instance.splits(streamSize, source);

        IntStream ints = instance.ints();
        IntStream ints1 = instance.ints(streamSize);
        IntStream ints2 = instance.ints(origin, bound);
        IntStream ints3 = instance.ints(streamSize, origin, bound);

        LongStream longs = instance.longs();
        LongStream longs1 = instance.longs(streamSize);
        LongStream longs2 = instance.longs(lorigin, lbound);
        LongStream longs3 = instance.longs(streamSize, lorigin, lbound);

        DoubleStream doubles = instance.doubles();
        DoubleStream doubles1 = instance.doubles(streamSize);
        DoubleStream doubles2 = instance.doubles(dorigin, dbound);
        DoubleStream doubles3 = instance.doubles(streamSize, dorigin, dbound);

    }

}

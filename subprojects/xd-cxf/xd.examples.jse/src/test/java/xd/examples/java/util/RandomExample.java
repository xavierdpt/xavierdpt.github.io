package xd.examples.java.util;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Scaffolded
public class RandomExample extends BaseExample<Random> {
    @Override
    public void scaffold(Random instance) {
        long seed = 0;
        ignore(
                new Random(),
                new Random(seed)
        );

        long streamSize = 0;
        double dorigin = 0;
        double dbound = 0;
        int iorigin = 0;
        int ibound = 0;
        long lorigin = 0;
        long lbound = 0;

        DoubleStream doubles = instance.doubles();
        DoubleStream doubles1 = instance.doubles(streamSize);
        DoubleStream doubles2 = instance.doubles(dorigin, dbound);
        DoubleStream doubles3 = instance.doubles(streamSize, dorigin, dbound);

        IntStream ints = instance.ints();
        IntStream ints1 = instance.ints(streamSize);
        IntStream ints2 = instance.ints(iorigin, ibound);
        IntStream ints3 = instance.ints(streamSize, iorigin, ibound);

        LongStream longs = instance.longs();
        LongStream longs1 = instance.longs(streamSize);
        LongStream longs2 = instance.longs(lorigin, lbound);
        LongStream longs3 = instance.longs(streamSize, lorigin, lbound);

        boolean b = instance.nextBoolean();

        byte[] bytes = new byte[0];
        instance.nextBytes(bytes);

        double v = instance.nextDouble();
        float v1 = instance.nextFloat();
        double v2 = instance.nextGaussian();

        int i = instance.nextInt();
        int i1 = instance.nextInt(ibound);

        long l = instance.nextLong();

        instance.setSeed(seed);
    }
}

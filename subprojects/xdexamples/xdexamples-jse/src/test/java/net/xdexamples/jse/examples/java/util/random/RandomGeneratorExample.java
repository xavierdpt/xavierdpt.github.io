package net.xdexamples.jse.examples.java.util.random;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.util.random.RandomGenerator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Scaffolded
public class RandomGeneratorExample extends BaseExample<RandomGenerator> {
    @Override
    public void scaffold(RandomGenerator instance) throws Throwable {

        String name = null;
        RandomGenerator name1 = RandomGenerator.of(name);

        RandomGenerator aDefault = RandomGenerator.getDefault();

        boolean deprecated = instance.isDeprecated();


        int randomNumberOrigin = 0;
        int randomNumberBound = 0;
        int streamSize = 0;
        DoubleStream doubles = instance.doubles();
        DoubleStream doubles1 = instance.doubles(randomNumberOrigin, randomNumberBound);
        DoubleStream doubles2 = instance.doubles(streamSize);
        DoubleStream doubles3 = instance.doubles(streamSize, randomNumberOrigin, randomNumberBound);

        int io = 0;
        int ib = 0;
        IntStream ints = instance.ints();
        IntStream ints1 = instance.ints(io, ib);
        IntStream ints2 = instance.ints(streamSize);
        IntStream ints3 = instance.ints(streamSize, io, ib);

        long lo = 0;
        long lb = 0;
        LongStream longs = instance.longs();
        LongStream longs1 = instance.longs(lo, lb);
        LongStream longs2 = instance.longs(streamSize);
        LongStream longs3 = instance.longs(streamSize, lo, lb);

        boolean b = instance.nextBoolean();

        byte[] bytes = new byte[0];
        instance.nextBytes(bytes);

        float fb = 0;
        float fo = 0;
        float v = instance.nextFloat();
        float v1 = instance.nextFloat(fb);
        float v2 = instance.nextFloat(fo, fb);

        double db = 0;
        double doo = 0;
        double v3 = instance.nextDouble();
        double v4 = instance.nextDouble(db);
        double v5 = instance.nextDouble(doo, db);

        int i = instance.nextInt();
        int i1 = instance.nextInt(ib);
        int i2 = instance.nextInt(io, ib);

        long l = instance.nextLong();
        long l1 = instance.nextLong(lb);
        long l2 = instance.nextLong(lo, lb);

        double mean = 0;
        double stddev = 0;
        double v6 = instance.nextGaussian();
        double v7 = instance.nextGaussian(mean, stddev);

        double v8 = instance.nextExponential();
    }
}

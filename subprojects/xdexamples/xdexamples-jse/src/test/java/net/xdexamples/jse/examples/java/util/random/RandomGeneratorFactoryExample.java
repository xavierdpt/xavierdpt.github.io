package net.xdexamples.jse.examples.java.util.random;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.math.BigInteger;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Stream;

@Scaffolded
public class RandomGeneratorFactoryExample extends BaseExample<RandomGeneratorFactory> {
    @Override
    public void scaffold(RandomGeneratorFactory instance) throws Throwable {
        String name = null;
        RandomGeneratorFactory<RandomGenerator> name1 = RandomGeneratorFactory.of(name);

        RandomGeneratorFactory<RandomGenerator> aDefault = RandomGeneratorFactory.getDefault();

        Stream<RandomGeneratorFactory<RandomGenerator>> all = RandomGeneratorFactory.all();

        String name2 = instance.name();

        String group = instance.group();

        int i = instance.stateBits();

        int equidistribution = instance.equidistribution();

        BigInteger period = instance.period();

        boolean statistical = instance.isStatistical();
        boolean stochastic = instance.isStochastic();
        boolean hardware = instance.isHardware();
        boolean arbitrarilyJumpable = instance.isArbitrarilyJumpable();
        boolean jumpable = instance.isJumpable();
        boolean leapable = instance.isLeapable();
        boolean splittable = instance.isSplittable();
        boolean streamable = instance.isStreamable();
        boolean deprecated = instance.isDeprecated();

        long seed = 0;
        long seedBytes = 0;
        RandomGenerator randomGenerator = instance.create();
        RandomGenerator randomGenerator1 = instance.create(seed);
        RandomGenerator randomGenerator2 = instance.create(seedBytes);

    }
}

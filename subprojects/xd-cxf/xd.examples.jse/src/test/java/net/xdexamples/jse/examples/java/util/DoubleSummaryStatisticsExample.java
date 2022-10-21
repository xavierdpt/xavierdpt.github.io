package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;

import java.util.DoubleSummaryStatistics;

public class DoubleSummaryStatisticsExample extends BaseExample<DoubleSummaryStatistics> {
    @Override
    public void scaffold(DoubleSummaryStatistics instance) throws Throwable {
        long count = 0;
        double min = 0;
        double max = 0;
        double sum = 0;
        ignore(
                new DoubleSummaryStatistics(),
                new DoubleSummaryStatistics(count, min, max, sum)
        );

        double value = 0;
        instance.accept(value);

        DoubleSummaryStatistics other = null;
        instance.combine(other);

        instance.getCount();

        double sum1 = instance.getSum();

        double min1 = instance.getMin();

        double max1 = instance.getMax();

        double average = instance.getAverage();

        String s = instance.toString();

    }
}

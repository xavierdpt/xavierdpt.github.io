package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyComparable;
import net.xdexamples.Scaffolded;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@Scaffolded
public class ComparatorExample extends BaseExample<Comparator<Dummy>> {

    @Override
    public void scaffold(Comparator<Dummy> instance) throws Throwable {
        Dummy value1 = null;
        Dummy value2 = null;
        int compare = instance.compare(value1, value2);

        Comparator<Dummy> other = null;
        boolean equals = instance.equals(other);

        Comparator<Dummy> reversed = instance.reversed();

        Function<Dummy, DummyComparable> keyExtractorToComparable = null;
        Function<Dummy, Dummy> keyExtractor = null;
        Comparator<Dummy> comparator = null;

        Comparator<Dummy> dummyComparator = instance.thenComparing(other);
        Comparator<Dummy> dummyComparator2 = instance.thenComparing(keyExtractor, comparator);
        Comparator<Dummy> dummyComparator1 = instance.thenComparing(keyExtractorToComparable);

        ToIntFunction<Dummy> dummyToInt = null;
        Comparator<Dummy> dummyComparator3 = instance.thenComparingInt(dummyToInt);

        ToLongFunction<Dummy> dummyToLong = null;
        Comparator<Dummy> dummyComparator4 = instance.thenComparingLong(dummyToLong);

        ToDoubleFunction<Dummy> dummyToDouble = null;
        Comparator<Dummy> dummyComparator5 = instance.thenComparingDouble(dummyToDouble);

        Comparator<DummyComparable> dummyComparableComparator = Comparator.reverseOrder();

        Comparator<DummyComparable> dummyComparableComparator1 = Comparator.naturalOrder();

        Comparator<Dummy> dummyComparator6 = Comparator.nullsFirst(instance);

        Comparator<Dummy> dummyComparator7 = Comparator.nullsLast(instance);

        Comparator<Dummy> comparing = Comparator.comparing(keyExtractorToComparable);
        Comparator<Dummy> comparing1 = Comparator.comparing(keyExtractor, comparator);

        Comparator<Dummy> dummyComparator8 = Comparator.comparingInt(dummyToInt);

        Comparator<Dummy> dummyComparator9 = Comparator.comparingLong(dummyToLong);
        Comparator<Dummy> dummyComparator10 = Comparator.comparingDouble(dummyToDouble);
    }

}

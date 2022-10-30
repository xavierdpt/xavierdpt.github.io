package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;

import java.util.Collection;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.Spliterators;

public class SpliteratorsExample extends BaseExample<Spliterators> {
    @Override
    public void scaffold(Spliterators instance) {

        Spliterator.OfDouble ofDouble = Spliterators.emptyDoubleSpliterator();

        Spliterator.OfInt ofInt = Spliterators.emptyIntSpliterator();

        Spliterator.OfLong ofLong = Spliterators.emptyLongSpliterator();

        Spliterator<Dummy> dummySpliterator = Spliterators.emptySpliterator();

        PrimitiveIterator.OfInt ofIntIterator = Spliterators.iterator(ofInt);
        PrimitiveIterator.OfLong ofLongIterator = Spliterators.iterator(ofLong);
        PrimitiveIterator.OfDouble ofDoubleIterator = Spliterators.iterator(ofDouble);
        Iterator<Dummy> iterator3 = Spliterators.iterator(dummySpliterator);

        int[] ints = new int[0];
        long[] longs = new long[0];
        double[] doubles = new double[0];
        Object[] objects = new Object[0];
        int characteristics = 0;
        int from = 0;
        int to = 0;
        long size = 0;
        Iterator<Dummy> iterator = null;
        Collection<Dummy> collection = null;

        Spliterator.OfInt spliterator = Spliterators.spliterator(ints, characteristics);
        Spliterator.OfInt spliterator1 = Spliterators.spliterator(ints, from, to, characteristics);

        Spliterator.OfLong spliterator2 = Spliterators.spliterator(longs, characteristics);
        Spliterator.OfLong spliterator3 = Spliterators.spliterator(longs, from, to, characteristics);

        Spliterator.OfDouble spliterator4 = Spliterators.spliterator(doubles, characteristics);
        Spliterator.OfDouble spliterator5 = Spliterators.spliterator(doubles, from, to, characteristics);

        Spliterator<Object> spliterator6 = Spliterators.spliterator(objects, characteristics);
        Spliterator<Object> spliterator7 = Spliterators.spliterator(objects, from, to, characteristics);

        Spliterator.OfInt spliterator8 = Spliterators.spliterator(ofIntIterator, size, characteristics);
        Spliterator.OfLong spliterator9 = Spliterators.spliterator(ofLongIterator, size, characteristics);
        Spliterator.OfDouble spliterator10 = Spliterators.spliterator(ofDoubleIterator, size, characteristics);

        Spliterator<Dummy> spliterator11 = Spliterators.spliterator(iterator, size, characteristics);
        Spliterator<Dummy> spliterator12 = Spliterators.spliterator(collection, characteristics);

        Spliterator.OfInt ofInt1 = Spliterators.spliteratorUnknownSize(ofIntIterator, characteristics);
        Spliterator.OfLong ofLong1 = Spliterators.spliteratorUnknownSize(ofLongIterator, characteristics);
        Spliterator.OfDouble ofDouble1 = Spliterators.spliteratorUnknownSize(ofDoubleIterator, characteristics);
        Spliterator<Dummy> dummySpliterator1 = Spliterators.spliteratorUnknownSize(iterator, characteristics);
    }
}

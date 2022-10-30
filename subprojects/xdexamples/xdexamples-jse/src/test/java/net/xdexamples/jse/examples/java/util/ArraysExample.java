package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyClass;
import xd.helpers.dummies.DummyComparable;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@Scaffolded
public class ArraysExample extends BaseExample<Arrays> {

    @Override
    public void scaffold(Arrays instance) throws Throwable {

        Dummy value = null;

        List<Dummy> dummyList = Arrays.asList(value, value, value);

        byte[] bytes = new byte[0];
        short[] shorts = new short[0];
        int[] ints = new int[0];
        long[] longs = new long[0];
        float[] floats = new float[0];
        double[] doubles = new double[0];
        char[] chars = new char[0];

        byte bkey = 0;
        short skey = 0;
        int ikey = 0;
        long lkey = 0;
        float fkey = 0;
        double dkey = 0;
        char ckey = 0;

        int from = 0;
        int to = 0;

        int i = Arrays.binarySearch(bytes, bkey);
        int i1 = Arrays.binarySearch(bytes, from, to, bkey);

        int i2 = Arrays.binarySearch(shorts, skey);
        int i3 = Arrays.binarySearch(shorts, from, to, skey);

        int i4 = Arrays.binarySearch(ints, ikey);
        int i5 = Arrays.binarySearch(ints, from, to, ikey);

        int i6 = Arrays.binarySearch(longs, lkey);
        int i7 = Arrays.binarySearch(longs, from, to, lkey);

        int i8 = Arrays.binarySearch(floats, fkey);
        int i9 = Arrays.binarySearch(floats, from, to, fkey);

        int i10 = Arrays.binarySearch(doubles, dkey);
        int i11 = Arrays.binarySearch(doubles, from, to, dkey);

        int i12 = Arrays.binarySearch(chars, ckey);
        int i13 = Arrays.binarySearch(chars, from, to, ckey);

        Object[] objects = new Object[0];
        Object okey = null;

        int i15 = Arrays.binarySearch(objects, okey);
        int i16 = Arrays.binarySearch(objects, from, to, okey);

        Dummy[] oobjects = new Dummy[0];
        Dummy ookey = null;
        Comparator<? super Dummy> dummyComparator = null;
        int i14 = Arrays.binarySearch(oobjects, ookey, dummyComparator);
        int i17 = Arrays.binarySearch(oobjects, from, to, ookey, dummyComparator);

        boolean[] booleans = new boolean[0];
        int compare = Arrays.compare(booleans, booleans);
        int compare1 = Arrays.compare(booleans, from, to, booleans, from, to);

        int compare2 = Arrays.compare(bytes, bytes);
        int compare3 = Arrays.compare(bytes, from, to, bytes, from, to);

        int compare4 = Arrays.compare(shorts, shorts);
        int compare5 = Arrays.compare(shorts, from, to, shorts, from, to);

        int compare6 = Arrays.compare(ints, ints);
        int compare7 = Arrays.compare(ints, from, to, ints, from, to);

        int compare8 = Arrays.compare(longs, longs);
        int compare9 = Arrays.compare(longs, from, to, longs, from, to);

        int compare10 = Arrays.compare(floats, floats);
        int compare11 = Arrays.compare(floats, from, to, floats, from, to);

        int compare12 = Arrays.compare(doubles, doubles);
        int compare13 = Arrays.compare(doubles, from, to, doubles, from, to);

        int compare14 = Arrays.compare(chars, chars);
        int compare15 = Arrays.compare(chars, from, to, chars, from, to);

        DummyComparable[] dummyComparables = new DummyComparable[0];
        int compare16 = Arrays.compare(dummyComparables, dummyComparables);
        int compare17 = Arrays.compare(dummyComparables, from, to, dummyComparables, from, to);

        Dummy[] dummies = new Dummy[0];
        Comparator<Dummy> comparator1 = null;
        int compare18 = Arrays.compare(dummies, dummies, comparator1);
        int compare19 = Arrays.compare(dummies, from, to, dummies, from, to, comparator1);

        int i18 = Arrays.compareUnsigned(bytes, bytes);
        int i19 = Arrays.compareUnsigned(bytes, from, to, bytes, from, to);

        int i20 = Arrays.compareUnsigned(shorts, shorts);
        int i21 = Arrays.compareUnsigned(shorts, from, to, shorts, from, to);

        int i22 = Arrays.compareUnsigned(ints, ints);
        int i23 = Arrays.compareUnsigned(ints, from, to, ints, from, to);

        int i24 = Arrays.compareUnsigned(longs, longs);
        int i25 = Arrays.compareUnsigned(longs, from, to, longs, from, to);

        int newLength = 0;
        boolean[] booleans1 = Arrays.copyOf(booleans, newLength);
        byte[] bytes1 = Arrays.copyOf(bytes, newLength);
        short[] shorts1 = Arrays.copyOf(shorts, newLength);
        int[] ints1 = Arrays.copyOf(ints, newLength);
        long[] longs1 = Arrays.copyOf(longs, newLength);
        float[] floats1 = Arrays.copyOf(floats, newLength);
        double[] doubles1 = Arrays.copyOf(doubles, newLength);
        char[] chars1 = Arrays.copyOf(chars, newLength);
        Dummy[] dummies1 = Arrays.copyOf(dummies, newLength);
        DummyClass[] dummyClasses = Arrays.copyOf(dummies, newLength, DummyClass[].class);

        boolean[] booleans2 = Arrays.copyOfRange(booleans, from, to);
        byte[] bytes2 = Arrays.copyOfRange(bytes, from, to);
        short[] shorts2 = Arrays.copyOfRange(shorts, from, to);
        int[] ints2 = Arrays.copyOfRange(ints, from, to);
        long[] longs2 = Arrays.copyOfRange(longs, from, to);
        float[] floats2 = Arrays.copyOfRange(floats, from, to);
        double[] doubles2 = Arrays.copyOfRange(doubles, from, to);
        char[] chars2 = Arrays.copyOfRange(chars, from, to);
        Dummy[] dummies2 = Arrays.copyOfRange(dummies, from, to);
        DummyClass[] dummyClasses1 = Arrays.copyOfRange(dummies, from, to, DummyClass[].class);

        boolean b = Arrays.deepEquals(dummies, dummies);

        int i26 = Arrays.deepHashCode(dummies);

        String s = Arrays.deepToString(dummies);

        Arrays.equals(booleans, booleans);
        Arrays.equals(booleans, from, to, booleans, from, to);
        Arrays.equals(bytes, bytes);
        Arrays.equals(bytes, from, to, bytes, from, to);
        Arrays.equals(shorts, shorts);
        Arrays.equals(shorts, from, to, shorts, from, to);
        Arrays.equals(ints, ints);
        Arrays.equals(ints, from, to, ints, from, to);
        Arrays.equals(longs, longs);
        Arrays.equals(longs, from, to, longs, from, to);
        Arrays.equals(floats, floats);
        Arrays.equals(floats, from, to, floats, from, to);
        Arrays.equals(doubles, doubles);
        Arrays.equals(doubles, from, to, doubles, from, to);
        Arrays.equals(chars, chars);
        Arrays.equals(chars, from, to, chars, from, to);

        Arrays.equals(dummies, dummies);
        Arrays.equals(dummies, from, to, dummies, from, to);

        Arrays.equals(dummies, dummies, dummyComparator);
        Arrays.equals(dummies, from, to, dummies, from, to, dummyComparator);

        boolean bvalue = false;
        Arrays.fill(booleans, bvalue);
        Arrays.fill(booleans, from, to, bvalue);
        Arrays.fill(bytes, bkey);
        Arrays.fill(bytes, from, to, bkey);
        Arrays.fill(shorts, skey);
        Arrays.fill(shorts, from, to, skey);
        Arrays.fill(ints, ikey);
        Arrays.fill(ints, from, to, ikey);
        Arrays.fill(longs, lkey);
        Arrays.fill(longs, from, to, lkey);
        Arrays.fill(floats, fkey);
        Arrays.fill(floats, from, to, fkey);
        Arrays.fill(doubles, dkey);
        Arrays.fill(doubles, from, to, dkey);
        Arrays.fill(chars, ckey);
        Arrays.fill(chars, from, to, ckey);

        Dummy dummy = null;
        Arrays.fill(dummies, dummy);
        Arrays.fill(dummies, from, to, dummy);

        int i27 = Arrays.hashCode(booleans);
        int i28 = Arrays.hashCode(bytes);
        int i29 = Arrays.hashCode(shorts);
        int i30 = Arrays.hashCode(ints);
        int i31 = Arrays.hashCode(longs);
        int i32 = Arrays.hashCode(floats);
        int i33 = Arrays.hashCode(doubles);
        int i34 = Arrays.hashCode(chars);
        int i35 = Arrays.hashCode(dummies);

        int mismatch = Arrays.mismatch(booleans, booleans);
        int mismatch1 = Arrays.mismatch(booleans, from, to, booleans, from, to);
        int mismatch2 = Arrays.mismatch(bytes, bytes);
        int mismatch3 = Arrays.mismatch(bytes, from, to, bytes, from, to);
        int mismatch4 = Arrays.mismatch(shorts, shorts);
        int mismatch5 = Arrays.mismatch(shorts, from, to, shorts, from, to);
        int mismatch6 = Arrays.mismatch(ints, ints);
        int mismatch7 = Arrays.mismatch(ints, from, to, ints, from, to);
        int mismatch8 = Arrays.mismatch(longs, longs);
        int mismatch9 = Arrays.mismatch(longs, from, to, longs, from, to);
        int mismatch10 = Arrays.mismatch(floats, floats);
        int mismatch11 = Arrays.mismatch(floats, from, to, floats, from, to);
        int mismatch12 = Arrays.mismatch(doubles, doubles);
        int mismatch13 = Arrays.mismatch(doubles, from, to, doubles, from, to);
        int mismatch14 = Arrays.mismatch(chars, chars);
        int mismatch15 = Arrays.mismatch(chars, from, to, chars, from, to);
        int mismatch16 = Arrays.mismatch(objects, objects);
        int mismatch17 = Arrays.mismatch(objects, from, to, objects, from, to);
        int mismatch18 = Arrays.mismatch(dummies, dummies, dummyComparator);
        int mismatch19 = Arrays.mismatch(dummies, from, to, dummies, from, to, dummyComparator);

        IntBinaryOperator ibop = null;
        LongBinaryOperator lbop = null;
        DoubleBinaryOperator dbop = null;
        BinaryOperator<Dummy> dummybop = null;

        Arrays.parallelPrefix(ints, ibop);
        Arrays.parallelPrefix(ints, from, to, ibop);
        Arrays.parallelPrefix(longs, lbop);
        Arrays.parallelPrefix(longs, from, to, lbop);
        Arrays.parallelPrefix(doubles, dbop);
        Arrays.parallelPrefix(doubles, from, to, dbop);
        Arrays.parallelPrefix(dummies, dummybop);
        Arrays.parallelPrefix(dummies, from, to, dummybop);

        IntUnaryOperator iToInt = null;
        IntToLongFunction iToLong = null;
        IntToDoubleFunction iToDouble = null;
        IntFunction<Dummy> iToDummy = null;

        Arrays.parallelSetAll(ints, iToInt);
        Arrays.parallelSetAll(longs, iToLong);
        Arrays.parallelSetAll(doubles, iToDouble);
        Arrays.parallelSetAll(dummies, iToDummy);

        Arrays.parallelSort(bytes);
        Arrays.parallelSort(bytes, from, to);
        Arrays.parallelSort(shorts);
        Arrays.parallelSort(shorts, from, to);
        Arrays.parallelSort(ints);
        Arrays.parallelSort(ints, from, to);
        Arrays.parallelSort(longs);
        Arrays.parallelSort(longs, from, to);
        Arrays.parallelSort(floats);
        Arrays.parallelSort(floats, from, to);
        Arrays.parallelSort(doubles);
        Arrays.parallelSort(doubles, from, to);
        Arrays.parallelSort(chars);
        Arrays.parallelSort(chars, from, to);

        Arrays.parallelSort(dummyComparables);
        Arrays.parallelSort(dummyComparables, from, to);

        Arrays.parallelSort(dummies, dummyComparator);
        Arrays.parallelSort(dummies, from, to, dummyComparator);

        Arrays.setAll(ints, iToInt);
        Arrays.setAll(longs, iToLong);
        Arrays.setAll(doubles, iToDouble);
        Arrays.setAll(dummies, iToDummy);

        Arrays.sort(bytes);
        Arrays.sort(bytes, from, to);
        Arrays.sort(shorts);
        Arrays.sort(shorts, from, to);
        Arrays.sort(ints);
        Arrays.sort(ints, from, to);
        Arrays.sort(longs);
        Arrays.sort(longs, from, to);
        Arrays.sort(floats);
        Arrays.sort(floats, from, to);
        Arrays.sort(doubles);
        Arrays.sort(doubles, from, to);
        Arrays.sort(chars);
        Arrays.sort(chars, from, to);

        Arrays.sort(dummyComparables);
        Arrays.sort(dummyComparables, from, to);

        Arrays.sort(dummies, dummyComparator);
        Arrays.sort(dummies, from, to, dummyComparator);

        Spliterator.OfInt spliterator = Arrays.spliterator(ints);
        Spliterator.OfInt spliterator1 = Arrays.spliterator(ints, from, to);
        Spliterator.OfLong spliterator2 = Arrays.spliterator(longs);
        Spliterator.OfLong spliterator3 = Arrays.spliterator(longs, from, to);
        Spliterator.OfDouble spliterator4 = Arrays.spliterator(doubles);
        Spliterator.OfDouble spliterator5 = Arrays.spliterator(doubles, from, to);
        Spliterator<Dummy> spliterator6 = Arrays.spliterator(dummies);
        Spliterator<Dummy> spliterator7 = Arrays.spliterator(dummies, from, to);

        IntStream stream = Arrays.stream(ints);
        IntStream stream1 = Arrays.stream(ints, from, to);
        LongStream stream2 = Arrays.stream(longs);
        LongStream stream3 = Arrays.stream(longs, from, to);
        DoubleStream stream4 = Arrays.stream(doubles);
        DoubleStream stream5 = Arrays.stream(doubles, from, to);
        Stream<Dummy> stream6 = Arrays.stream(dummies);
        Stream<Dummy> stream7 = Arrays.stream(dummies, from, to);

        String s1 = Arrays.toString(booleans);
        String s2 = Arrays.toString(bytes);
        String s3 = Arrays.toString(shorts);
        String s4 = Arrays.toString(ints);
        String s5 = Arrays.toString(longs);
        String s6 = Arrays.toString(floats);
        String s7 = Arrays.toString(doubles);
        String s8 = Arrays.toString(dummies);

    }
}

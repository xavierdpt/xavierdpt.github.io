package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.util.BitSet;
import java.util.stream.IntStream;

@Scaffolded
public class BitSetExample extends BaseExample<BitSet> {
    @Override
    public void scaffold(BitSet instance) throws Throwable {

        int nbits = 0;
        ignore(
                new BitSet(),
                new BitSet(nbits)
        );

        BitSet other = null;
        instance.and(other);

        instance.andNot(other);

        int cardinality = instance.cardinality();

        int index = 0;
        int from = 0;
        int to = 0;
        instance.clear();
        instance.clear(index);
        instance.clear(from, to);

        Object clone = instance.clone();

        boolean equals = instance.equals(other);

        instance.flip(index);
        instance.flip(from, to);

        boolean b = instance.get(index);
        BitSet bitSet = instance.get(from, to);

        int i = instance.hashCode();

        boolean intersects = instance.intersects(other);

        boolean empty = instance.isEmpty();

        int length = instance.length();

        int i1 = instance.nextClearBit(index);
        int i2 = instance.nextSetBit(index);

        instance.or(other);

        int i3 = instance.previousClearBit(index);
        int i4 = instance.previousSetBit(index);

        boolean value = false;
        instance.set(index);
        instance.set(index, value);
        instance.set(from, to);
        instance.set(from, to, value);

        int size = instance.size();

        IntStream stream = instance.stream();

        byte[] bytes = instance.toByteArray();
        long[] longs = instance.toLongArray();

        String s = instance.toString();

        ByteBuffer byteBuffer = null;
        LongBuffer longBuffer = null;
        BitSet bitSet1 = BitSet.valueOf(bytes);
        BitSet bitSet2 = BitSet.valueOf(longs);
        BitSet bitSet3 = BitSet.valueOf(byteBuffer);
        BitSet bitSet4 = BitSet.valueOf(longBuffer);

        instance.xor(other);
    }
}

package net.xdexamples.jse.examples.java.nio;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

@Scaffolded
public class ByteBufferExample extends BaseExample<ByteBuffer> {

    @Override
    protected void scaffold(ByteBuffer instance) throws Throwable {
        int capacity = 0;
        ByteBuffer allocate = ByteBuffer.allocate(capacity);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(capacity);

        byte[] array = new byte[0];
        ByteBuffer wrap = ByteBuffer.wrap(array);

        int offset = 0;
        int length = 0;
        ByteBuffer wrap1 = ByteBuffer.wrap(array, offset, length);

        ByteBuffer slice = instance.slice();

        int index = 0;
        ByteBuffer slice1 = instance.slice(index, length);

        ByteBuffer duplicate = instance.duplicate();

        ByteBuffer byteBuffer1 = instance.asReadOnlyBuffer();

        byte b = instance.get();
        byte b1 = instance.get(index);
        ByteBuffer byteBuffer2 = instance.get(array, offset, length);
        ByteBuffer byteBuffer3 = instance.get(array);
        ByteBuffer byteBuffer4 = instance.get(index, array, offset, length);
        ByteBuffer byteBuffer5 = instance.get(index, array);

        byte aByte = 0;
        ByteBuffer put = instance.put(aByte);
        ByteBuffer put1 = instance.put(index, aByte);
        ByteBuffer put2 = instance.put(byteBuffer);
        ByteBuffer put3 = instance.put(index, byteBuffer, offset, length);
        ByteBuffer put4 = instance.put(array, offset, length);
        ByteBuffer put5 = instance.put(array);
        ByteBuffer put6 = instance.put(index, array, offset, length);
        ByteBuffer put7 = instance.put(index, array);

        boolean b2 = instance.hasArray();
        byte[] array1 = instance.array();
        int i = instance.arrayOffset();
        int position = instance.position();
        ByteBuffer position1 = instance.position(position);

        int limit = instance.limit();
        ByteBuffer limit1 = instance.limit(limit);

        ByteBuffer mark = instance.mark();

        ByteBuffer reset = instance.reset();

        ByteBuffer clear = instance.clear();

        ByteBuffer flip = instance.flip();

        ByteBuffer rewind = instance.rewind();

        ByteBuffer compact = instance.compact();

        boolean direct = instance.isDirect();

        String s = instance.toString();

        int i1 = instance.hashCode();

        ByteBuffer other = null;
        boolean equals = instance.equals(other);

        int i2 = instance.compareTo(other);

        int mismatch = instance.mismatch(other);

        ByteOrder order = instance.order();
        ByteBuffer order1 = instance.order(order);

        int unitSize = 0;
        int i3 = instance.alignmentOffset(index, unitSize);

        ByteBuffer byteBuffer6 = instance.alignedSlice(unitSize);

        char aChar = instance.getChar();
        char aChar1 = instance.getChar(index);

        ByteBuffer byteBuffer7 = instance.putChar(aChar);
        ByteBuffer byteBuffer8 = instance.putChar(index, aChar1);

        CharBuffer charBuffer = instance.asCharBuffer();

        short aShort = instance.getShort();
        short aShort1 = instance.getShort(index);
        ByteBuffer byteBuffer9 = instance.putShort(aShort);
        ByteBuffer byteBuffer10 = instance.putShort(index, aShort1);

        ShortBuffer shortBuffer = instance.asShortBuffer();

        int anInt = instance.getInt();
        int anInt1 = instance.getInt(index);
        ByteBuffer byteBuffer11 = instance.putInt(anInt);
        ByteBuffer byteBuffer12 = instance.putInt(index, anInt1);
        IntBuffer intBuffer = instance.asIntBuffer();

        long aLong = instance.getLong();
        long aLong1 = instance.getLong(index);
        ByteBuffer byteBuffer13 = instance.putLong(aLong1);
        ByteBuffer byteBuffer14 = instance.putLong(index, aLong);
        LongBuffer longBuffer = instance.asLongBuffer();

        float aFloat = instance.getFloat();
        float aFloat1 = instance.getFloat(index);
        ByteBuffer byteBuffer15 = instance.putFloat(aFloat);
        ByteBuffer byteBuffer16 = instance.putFloat(index, aFloat1);
        FloatBuffer floatBuffer = instance.asFloatBuffer();

        double aDouble = instance.getDouble();
        double aDouble1 = instance.getDouble(index);
        ByteBuffer byteBuffer17 = instance.putDouble(aDouble);
        ByteBuffer byteBuffer18 = instance.putDouble(index, aDouble1);
        DoubleBuffer doubleBuffer = instance.asDoubleBuffer();


    }
}

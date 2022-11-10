package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ByteExample_bytesAndSize;
import net.xdexamples.jse.examples.java.lang.ByteExample_compare;
import net.xdexamples.jse.examples.java.lang.ByteExample_compareTo;
import net.xdexamples.jse.examples.java.lang.ByteExample_compareUnsigned;
import net.xdexamples.jse.examples.java.lang.ByteExample_decode;
import net.xdexamples.jse.examples.java.lang.ByteExample_describeConstable;
import net.xdexamples.jse.examples.java.lang.ByteExample_equals;
import net.xdexamples.jse.examples.java.lang.ByteExample_hashCode;
import net.xdexamples.jse.examples.java.lang.ByteExample_minValueAndMaxValue;
import net.xdexamples.jse.examples.java.lang.ByteExample_number;
import net.xdexamples.jse.examples.java.lang.ByteExample_parseByte;
import net.xdexamples.jse.examples.java.lang.ByteExample_parseByteWithRadix;
import net.xdexamples.jse.examples.java.lang.ByteExample_toString;
import net.xdexamples.jse.examples.java.lang.ByteExample_toStringStatic;
import net.xdexamples.jse.examples.java.lang.ByteExample_toUnsignedInt;
import net.xdexamples.jse.examples.java.lang.ByteExample_toUnsignedLong;
import net.xdexamples.jse.examples.java.lang.ByteExample_type;
import net.xdexamples.jse.examples.java.lang.ByteExample_valueOfByte;
import net.xdexamples.jse.examples.java.lang.ByteExample_valueOfString;
import net.xdexamples.jse.examples.java.lang.ByteExample_valueOfStringWithRadix;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CORE)
@Examples({
        @Example(value = ByteExample_type.class, illustrated = "TYPE"),
        @Example(value = ByteExample_bytesAndSize.class, illustrated = {"BYTES", "SIZE"}),
        @Example(value = ByteExample_minValueAndMaxValue.class, illustrated = {"MIN_VALUE", "MAX_VALUE"}),
        @Example(value = ByteExample_toUnsignedInt.class, illustrated = {"toUnsignedInt"}),
        @Example(value = ByteExample_toUnsignedLong.class, illustrated = {"toUnsignedLong"}),
        @Example(value = ByteExample_toStringStatic.class, illustrated = {"toString"}),
        @Example(value = ByteExample_toString.class, illustrated = {"toString"}),
        @Example(value = ByteExample_hashCode.class, illustrated = {"hashCode"}),
        @Example(value = ByteExample_compare.class, illustrated = {"compare"}),
        @Example(value = ByteExample_compareTo.class, illustrated = {"compareTo"}),
        @Example(value = ByteExample_compareUnsigned.class, illustrated = {"compareUnsigned"}),
        @Example(value = ByteExample_equals.class, illustrated = {"equals"}),
        @Example(value = ByteExample_number.class,
                illustrated = {"byteValue", "shortValue", "intValue", "longValue", "floatValue", "doubleValue"}),
        @Example(value = ByteExample_valueOfByte.class, illustrated = {"valueOf"}),
        @Example(value = ByteExample_parseByteWithRadix.class, illustrated = {"parseByte"}),
        @Example(value = ByteExample_parseByte.class, illustrated = {"parseByte"}),
        @Example(value = ByteExample_valueOfStringWithRadix.class, illustrated = {"valueOf"}),
        @Example(value = ByteExample_valueOfString.class, illustrated = {"valueOf"}),
        @Example(value = ByteExample_decode.class, illustrated = {"decode"}),
        @Example(value = ByteExample_describeConstable.class, illustrated = {"describeConstable"},
                bundle = EBundle.CONSTABLE, access = EAccessLevel.PROTECTED),
})
public class ByteIndex extends ExampleComplete<Byte> {
}

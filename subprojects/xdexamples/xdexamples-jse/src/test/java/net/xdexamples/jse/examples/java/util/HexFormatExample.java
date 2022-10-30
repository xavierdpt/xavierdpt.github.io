package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.DummyAppendable;

import java.util.HexFormat;

@Scaffolded
public class HexFormatExample extends BaseExample<HexFormat> {
    @Override
    public void scaffold(HexFormat instance) throws Throwable {

        String delimiter = instance.delimiter();

        HexFormat other = null;
        instance.equals(other);

        byte[] bytes = new byte[0];
        int from = 0;
        int to = 0;
        Appendable appendable = null;
        instance.formatHex(bytes);
        instance.formatHex(bytes, from, to);
        instance.formatHex(appendable, bytes);
        instance.formatHex(appendable, bytes, from, to);


        int anInt = 0;
        int i = HexFormat.fromHexDigit(anInt);

        CharSequence charSequence = null;
        int i1 = HexFormat.fromHexDigits(charSequence);
        int i2 = HexFormat.fromHexDigits(charSequence, from, to);

        long l = HexFormat.fromHexDigitsToLong(charSequence);
        long l1 = HexFormat.fromHexDigitsToLong(charSequence, from, to);

        int i3 = instance.hashCode();

        boolean hexDigit = HexFormat.isHexDigit(anInt);

        boolean upperCase = instance.isUpperCase();

        HexFormat of = HexFormat.of();

        HexFormat hexFormat = HexFormat.ofDelimiter(delimiter);

        char[] chars = new char[0];
        byte[] bytes1 = instance.parseHex(charSequence);
        byte[] bytes2 = instance.parseHex(charSequence, from, to);
        byte[] bytes3 = instance.parseHex(chars, from, to);

        String prefix = instance.prefix();

        String suffix = instance.suffix();

        byte aByte = 0;
        short aShort = 0;
        long aLong = 0;
        int digits = 0;
        char aChar = 0;
        DummyAppendable out = null;
        String s = instance.toHexDigits(aByte);
        String s1 = instance.toHexDigits(aShort);
        String s2 = instance.toHexDigits(anInt);
        String s3 = instance.toHexDigits(aLong);
        String s4 = instance.toHexDigits(aLong, digits);
        String s5 = instance.toHexDigits(aChar);
        DummyAppendable dummyAppendable = instance.toHexDigits(out, aByte);

        char c = instance.toHighHexDigit(anInt);
        char c1 = instance.toLowHexDigit(anInt);

        String s6 = instance.toString();

        HexFormat hexFormat1 = instance.withDelimiter(delimiter);

        HexFormat hexFormat2 = instance.withLowerCase();

        HexFormat hexFormat3 = instance.withPrefix(prefix);

        HexFormat hexFormat4 = instance.withSuffix(suffix);

        HexFormat hexFormat5 = instance.withUpperCase();
    }
}

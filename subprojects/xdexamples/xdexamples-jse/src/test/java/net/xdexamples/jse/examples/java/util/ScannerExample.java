package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@Scaffolded
public class ScannerExample extends BaseExample<Scanner> {
    @Override
    public void scaffold(Scanner instance) throws IOException {
        Readable readable = null;
        InputStream inputStream = null;
        String charsetName = null;
        Charset charset = null;
        File file = null;
        Path path = null;
        String string = null;
        ReadableByteChannel readableByteChannel = null;
        ignore(
                new Scanner(readable),
                new Scanner(inputStream),
                new Scanner(inputStream, charsetName),
                new Scanner(inputStream, charset),
                new Scanner(file),
                new Scanner(file, charsetName),
                new Scanner(file, charset),
                new Scanner(path),
                new Scanner(path, charsetName),
                new Scanner(path, charset),
                new Scanner(string),
                new Scanner(readableByteChannel),
                new Scanner(readableByteChannel, charsetName),
                new Scanner(readableByteChannel, charset)
        );

        Pattern pattern = null;
        int horizon = 0;
        int radix = 0;

        instance.close();
        Pattern delimiter = instance.delimiter();
        Stream<MatchResult> all = instance.findAll(pattern);
        Stream<MatchResult> all1 = instance.findAll(string);
        String inLine = instance.findInLine(pattern);
        String inLine1 = instance.findInLine(string);
        String withinHorizon = instance.findWithinHorizon(pattern, horizon);
        String withinHorizon1 = instance.findWithinHorizon(string, horizon);
        boolean b = instance.hasNext();
        boolean b1 = instance.hasNext(pattern);
        boolean b2 = instance.hasNext(string);
        boolean b3 = instance.hasNextBigDecimal();
        boolean b4 = instance.hasNextBigInteger();
        boolean b5 = instance.hasNextBigInteger(radix);
        boolean b6 = instance.hasNextBoolean();
        boolean b7 = instance.hasNextByte();
        boolean b8 = instance.hasNextByte(radix);
        boolean b9 = instance.hasNextDouble();
        boolean b10 = instance.hasNextFloat();
        boolean b11 = instance.hasNextInt();
        boolean b12 = instance.hasNextInt(radix);
        boolean b13 = instance.hasNextLine();
        boolean b14 = instance.hasNextLong();
        boolean b15 = instance.hasNextLong(radix);
        boolean b16 = instance.hasNextShort();
        boolean b17 = instance.hasNextShort(radix);
        IOException ioException = instance.ioException();
        Locale locale = instance.locale();
        MatchResult match = instance.match();
        String next = instance.next();
        String next1 = instance.next(pattern);
        String next2 = instance.next(string);
        BigDecimal bigDecimal = instance.nextBigDecimal();
        BigInteger bigInteger = instance.nextBigInteger();
        BigInteger bigInteger1 = instance.nextBigInteger(radix);
        boolean b18 = instance.nextBoolean();
        byte b19 = instance.nextByte();
        byte b20 = instance.nextByte(radix);
        double v = instance.nextDouble();
        float v1 = instance.nextFloat();
        int i = instance.nextInt();
        int i1 = instance.nextInt(radix);
        String s = instance.nextLine();
        long l = instance.nextLong();
        long l1 = instance.nextLong(radix);
        short i2 = instance.nextShort();
        short i3 = instance.nextShort(radix);
        int radix1 = instance.radix();
        instance.remove();
        Scanner reset = instance.reset();
        Scanner skip = instance.skip(pattern);
        Scanner skip1 = instance.skip(string);
        String s1 = instance.toString();
        Stream<String> tokens = instance.tokens();
        Scanner scanner = instance.useDelimiter(pattern);
        Scanner scanner1 = instance.useDelimiter(string);
        Scanner scanner2 = instance.useLocale(locale);
        Scanner scanner3 = instance.useRadix(radix1);
    }
}

package net.xdexamples.jse.index.java.lang;


import net.xdexamples.jse.examples.java.lang.StringExample_bytesCharsetConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_bytesCharsetNameConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_bytesConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_bytesOffsetLengthCharsetConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_bytesOffsetLengthCharsetNameConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_bytesOffsetLengthConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_charAt;
import net.xdexamples.jse.examples.java.lang.StringExample_charsConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_codePointAt;
import net.xdexamples.jse.examples.java.lang.StringExample_codePointBefore;
import net.xdexamples.jse.examples.java.lang.StringExample_codePointCount;
import net.xdexamples.jse.examples.java.lang.StringExample_codePointsOffsetLengthConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_contentEqualsCharSequence;
import net.xdexamples.jse.examples.java.lang.StringExample_contentEqualsStringBuffer;
import net.xdexamples.jse.examples.java.lang.StringExample_defaultConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_endsWith;
import net.xdexamples.jse.examples.java.lang.StringExample_equals;
import net.xdexamples.jse.examples.java.lang.StringExample_equalsIgnoreCase;
import net.xdexamples.jse.examples.java.lang.StringExample_getBytes;
import net.xdexamples.jse.examples.java.lang.StringExample_getBytesCharset;
import net.xdexamples.jse.examples.java.lang.StringExample_getBytesCharsetName;
import net.xdexamples.jse.examples.java.lang.StringExample_getChars;
import net.xdexamples.jse.examples.java.lang.StringExample_isEmpty;
import net.xdexamples.jse.examples.java.lang.StringExample_length;
import net.xdexamples.jse.examples.java.lang.StringExample_startsWith;
import net.xdexamples.jse.examples.java.lang.StringExample_startsWithOffset;
import net.xdexamples.jse.examples.java.lang.StringExample_stringBufferConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_stringBuilderConstructor;
import net.xdexamples.jse.examples.java.lang.StringExample_stringConstructor;
import net.xdexamples.jse.examples.java.util.FormatterExample;
import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.Examples;
import org.junit.Test;
import xd.helpers.dummies.Dummy;
import xdtest.SeeAlso;

import java.lang.invoke.MethodHandles;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@Bundle(EBundle.CORE)
@Examples({
        @Example(value = StringExample_defaultConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_stringConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_charsConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_charsOffsetCountConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_codePointsOffsetLengthConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_bytesConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_bytesOffsetLengthConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_bytesCharsetConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_bytesCharsetNameConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_bytesOffsetLengthCharsetNameConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_bytesOffsetLengthCharsetConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_stringBufferConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_stringBuilderConstructor.class, illutratesConstructor = true),
        @Example(value = StringExample_length.class, illustrated = "length"),
        @Example(value = StringExample_isEmpty.class, illustrated = "isEmpty"),
        @Example(value = StringExample_charAt.class, illustrated = "charAt"),
        @Example(value = StringExample_codePointAt.class, illustrated = "codePointAt"),
        @Example(value = StringExample_codePointBefore.class, illustrated = "codePointBefore"),
        @Example(value = StringExample_codePointCount.class, illustrated = "codePointCount"),
        @Example(value = StringExample_getChars.class, illustrated = "getChars"),
        @Example(value = StringExample_getBytes.class, illustrated = "getBytes"),
        @Example(value = StringExample_getBytesCharset.class, illustrated = "getBytes"),
        @Example(value = StringExample_getBytesCharsetName.class, illustrated = "getBytes"),
        @Example(value = StringExample_startsWith.class, illustrated = "startsWith"),
        @Example(value = StringExample_startsWithOffset.class, illustrated = "startsWith"),
        @Example(value = StringExample_endsWith.class, illustrated = "endsWith"),
        @Example(value = StringExample_equals.class, illustrated = "equals"),
        @Example(value = StringExample_contentEqualsStringBuffer.class, illustrated = "contentEquals"),
        @Example(value = StringExample_contentEqualsCharSequence.class, illustrated = "contentEquals"),
        @Example(value = StringExample_equalsIgnoreCase.class, illustrated = "equalsIgnoreCase"),
})
public class StringIndex extends BaseExample<String> {

    @Override
    public void scaffold(String instance) throws Throwable {
        {
            // TODO offsetByCodePoints
            int index = 0;
            int offset = 0;
            int i3 = instance.offsetByCodePoints(index, offset);
            ignore(i3);
        }

        {
            String other = null;
            int result = instance.compareTo(other);
            seeExamples(this::compareToExample);
            ignore(result);
        }

        {
            String other = null;
            int result = instance.compareToIgnoreCase(other);
            seeExamples(this::compareToIgnoreCaseExample);
            ignore(result);
        }
        {
            // TODO regionMatches
            int toffset = 0;
            String other = null;
            int oofset = 0;
            int length = 0;
            boolean b5 = instance.regionMatches(toffset, other, oofset, length);
            ignore(b5);
        }
        {
            // TODO regionMatches
            boolean ignoreCase = false;
            int toffset = 0;
            String other = null;
            int oofset = 0;
            int length = 0;
            boolean b6 = instance.regionMatches(ignoreCase, toffset, other, oofset, length);
            ignore(b6);
        }


        {
            int result = instance.hashCode();
            seeExamples(this::hashCodeExample);
            ignore(result);
        }

        {
            int codePoint = 0;
            int index = instance.indexOf(codePoint);
            seeExamples(this::indexOfExample);
            ignore(index);
        }

        {
            int codePoint = 0;
            int fromIndex = 0;
            int index = instance.indexOf(codePoint, fromIndex);
            seeExamples(this::indexOfWithFromExample);
            ignore(index);
        }

        {
            String other = "";
            int index = instance.indexOf(other);
            seeExamples(this::indexOfStringExample);
            ignore(index);
        }

        {
            String other = "";
            int fromIndex = 0;
            int index = instance.indexOf(other, fromIndex);
            seeExamples(this::indexOfStringFromIndexExample);
            ignore(index);
        }

        {
            int codePoint = 0;
            int index = instance.lastIndexOf(codePoint);
            seeExamples(this::lastIndexOfExample);
            ignore(index);
        }

        {
            int codePoint = 0;
            int fromIndex = 0;
            int index = instance.lastIndexOf(codePoint, fromIndex);
            seeExamples(this::lastIndexOfWithFromExample);
            ignore(index);
        }

        {
            String other = "";
            int index = instance.lastIndexOf(other);
            seeExamples(this::lastIndexOfStringExample);
            ignore(index);
        }

        {
            String other = "";
            int fromIndex = 0;
            int index = instance.lastIndexOf(other, fromIndex);
            seeExamples(this::lastIndexOfStringFromIndexExample);
            ignore(index);
        }

        {
            int beginIndex = 0;
            String substring = instance.substring(beginIndex);
            seeExamples(this::substringExample);
            ignore(substring);
        }

        {
            int beginIndex = 0;
            int endIndex = 0;
            String substring1 = instance.substring(beginIndex, endIndex);
            seeExamples(this::substringBeginEndExample);
            ignore(substring1);
        }

        {
            // TODO subSequence
            int beginIndex = 0;
            int endIndex = 0;
            CharSequence charSequence1 = instance.subSequence(beginIndex, endIndex);
            ignore(charSequence1);
        }
        {
            // TODO concat
            String other = null;
            String concat = instance.concat(other);
            ignore(concat);
        }
        {
            // TODO replace
            char oldChar = 0;
            char newChar = 0;
            String replace = instance.replace(oldChar, newChar);
            ignore(replace);
        }
        {
            // TODO replace
            CharSequence target = null;
            CharSequence replacement = null;
            String replace1 = instance.replace(target, replacement);
            ignore(replace1);
        }
        {
            // TODO matches
            String regex = null;
            boolean matches = instance.matches(regex);
            ignore(matches);
        }
        {
            // TODO contains
            CharSequence charSequence = null;
            boolean contains = instance.contains(charSequence);
            ignore(contains);
        }
        {
            // TODO replaceFirst
            String regex = null;
            String replacement = null;
            String s13 = instance.replaceFirst(regex, replacement);
            ignore(s13);
        }
        {
            // TODO replaceAll
            String regex = null;
            String replacement = null;
            String s14 = instance.replaceAll(regex, replacement);
            ignore(s14);
        }
        {
            // TODO split
            String regex = null;
            String[] split = instance.split(regex);
            ignore(split);
        }
        {
            // TODO split
            String regex = null;
            int limit = 0;
            String[] split1 = instance.split(regex, limit);
            ignore(split1);
        }

        {
            CharSequence delimiter = ",";
            CharSequence s1 = null;
            CharSequence s2 = null;
            CharSequence s3 = null;
            String joined = String.join(delimiter, s1, s2, s3);
            seeExamples(this::joinExample);
            ignore(joined);
        }

        {
            CharSequence delimiter = ",";
            CharSequence[] parts = new CharSequence[0];
            String joined = String.join(delimiter, parts);
            seeExamples(this::joinExample);
            ignore(joined);
        }

        {
            CharSequence delimiter = ",";
            Iterable<CharSequence> elements = new ArrayList<>();
            String joined = String.join(delimiter, elements);
            seeExamples(this::joinWithIterableExample);
            ignore(joined);
        }

        {
            String string = instance.toLowerCase();
            seeExamples(this::toLowerCaseExample);
            ignore(string);
        }
        {
            Locale locale = Locale.getDefault();
            String string = instance.toLowerCase(locale);
            seeExamples(this::toLowerCaseWithLocaleExample);
            ignore(string);
        }
        {
            String string = instance.toUpperCase();
            seeExamples(this::toUpperCaseExample);
            ignore(string);
        }
        {
            Locale locale = Locale.getDefault();
            String string = instance.toUpperCase(locale);
            seeExamples(this::toUpperCaseWithLocaleExample);
            ignore(string);
        }

        {
            String trimmed = instance.trim();
            seeExamples(this::trimExample);
            ignore(trimmed);
        }

        {
            String stripped = instance.strip();
            seeExamples(this::stripExample);
            ignore(stripped);
        }

        {
            String stripped = instance.stripLeading();
            seeExamples(this::stripLeadingExample);
            ignore(stripped);
        }

        {
            String stripped = instance.stripTrailing();
            seeExamples(this::stripTrailingExample);
            ignore(stripped);
        }

        {
            boolean isBlank = instance.isBlank();
            seeExamples(this::isBlankExample);
            ignore(isBlank);
        }

        {
            Stream<String> lines = instance.lines();
            seeExamples(this::linesExample);
            ignore(lines);
        }

        {
            int indentation = 3;
            String indented = instance.indent(indentation);
            seeExamples(this::indentExample);
            ignore(indented);
        }

        {
            String string = instance.stripIndent();
            seeExamples(this::stripIndentExample);
            ignore(string);
        }

        {
            String result = instance.translateEscapes();
            seeExamples(this::translateEscapes);
            ignore(result);
        }

        {
            Function<String, Dummy> function = null;
            Dummy result = instance.transform(function);
            seeExamples(this::transformExample);
            ignore(result);
        }

        {
            String string = instance.toString();
            seeExamples(this::toStringExample);
            ignore(string);
        }

        {
            IntStream stream = instance.chars();
            seeExamples(this::charsExample);
            ignore(stream);
        }

        {
            IntStream intStream = instance.codePoints();
            seeExamples(this::codePointsExample);
            ignore(intStream);
        }

        {
            char[] chars = instance.toCharArray();
            seeExamples(this::toCharArrayExample);
            ignore(chars);
        }

        {
            String format = null;
            Object[] args = new Object[0];
            String formatted = String.format(format, args);
            seeExamples(this::formatExample);
            ignore(formatted);
        }

        {
            Locale locale = null;
            String format = null;
            Object[] args = new Object[0];
            String formatted = String.format(locale, format, args);
            seeExamples(this::formatWithLocaleExample);
            ignore(formatted);
        }

        {
            Object[] args = new Object[0];
            String formatted = instance.formatted(args);
            seeExamples(this::formattedExample);
            ignore(formatted);
        }

        {
            char[] chars = new char[]{'_'};
            String string = String.copyValueOf(chars);
            seeExamples(this::copyValueOfExample);
            ignore(string);
        }

        {
            char[] chars = new char[0];
            int offset = 0;
            int count = 0;
            String string = String.copyValueOf(chars, offset, count);
            seeExamples(this::copyValueOfExample);
            ignore(string);
        }

        {
            char value = '\0';
            String string = instance.valueOf(value);
            seeExamples(this::valueOfCharExample);
            ignore(string);
        }
        {
            int value = 0;
            String string = instance.valueOf(value);
            seeExamples(this::valueOfIntExample);
            ignore(string);
        }

        {
            long value = 0L;
            String string = instance.valueOf(value);
            seeExamples(this::valueOfLongExample);
            ignore(string);
        }

        {
            float value = 0F;
            String string = instance.valueOf(value);
            seeExamples(this::valueOfFloatExample);
            ignore(string);
        }

        {
            double value = 0D;
            String string = instance.valueOf(value);
            seeExamples(this::valueOfDoubleExample);
            ignore(string);
        }

        {
            boolean value = false;
            String string = instance.valueOf(value);
            seeExamples(this::valueOfBooleanExample);
            ignore(string);
        }

        {
            Object value = new Object();
            String string = instance.valueOf(value);
            seeExamples(this::valueOfObject);
            ignore(string);
        }

        {
            char[] value = new char[0];
            String string = instance.valueOf(value);
            seeExamples(this::valueOfCharsExample);
            ignore(string);
        }

        {
            char[] value = new char[0];
            int offset = 0;
            int count = 0;
            String string = instance.valueOf(value, offset, count);
            seeExamples(this::valueOfCharsExample);
            ignore(string);
        }

        {
            String interned = instance.intern();
            seeExamples(this::internExample);
            ignore(interned);
        }

        {
            int count = 0;
            String repeated = instance.repeat(count);
            seeExamples(this::repeatExample);
            ignore(repeated);
        }

        {
            Optional<String> result = instance.describeConstable();
            seeExamples(this::describeConstableExample);
            ignore(result);
        }
        {
            // TODO resolveConstantDesc
            MethodHandles.Lookup lookup = null;
            String s36 = instance.resolveConstantDesc(lookup);
            ignore(s36);
        }

        {
            Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
            seeExamples(this::caseInsensitiveOrderExample);
            ignore(comparator);
        }
    }


    @Test
    public void repeatExample() {
        String result = ".!.".repeat(3);
        assertEquals(".!..!..!.", result);
    }

    @Test
    public void internExample() {
        String s1 = new String("hello");
        String s2 = new String("hello");

        assertFalse(s1 == s2);

        String s3 = s1.intern();
        String s4 = s2.intern();

        assertTrue(s3 == s4);
        assertTrue(s3 == "hello");
        assertTrue(s4 == "hello");
    }

    @Test
    public void valueOfBooleanExample() {

        boolean value1 = true;
        boolean value2 = false;

        String string1 = String.valueOf(value1);
        String string2 = String.valueOf(value2);

        assertEquals("true", string1);
        assertEquals("false", string2);
    }

    @Test
    public void valueOfIntExample() {

        int value1 = Integer.MAX_VALUE;
        int value2 = Integer.MIN_VALUE;

        String string1 = String.valueOf(value1);
        String string2 = String.valueOf(value2);

        assertEquals("2147483647", string1);
        assertEquals("-2147483648", string2);
    }

    @Test
    public void valueOfLongExample() {

        long value1 = Long.MAX_VALUE;
        long value2 = Long.MIN_VALUE;

        String string1 = String.valueOf(value1);
        String string2 = String.valueOf(value2);

        assertEquals("9223372036854775807", string1);
        assertEquals("-9223372036854775808", string2);
    }

    @Test
    public void valueOfFloatExample() {

        float value1 = Float.MAX_VALUE;
        float value2 = Float.MIN_VALUE;
        float value3 = Float.MIN_NORMAL;

        String string1 = String.valueOf(value1);
        String string2 = String.valueOf(value2);
        String string3 = String.valueOf(value3);

        assertEquals("3.4028235E38", string1);
        assertEquals("1.4E-45", string2);
        assertEquals("1.17549435E-38", string3);
    }

    @Test
    public void valueOfDoubleExample() {

        double value1 = Double.MAX_VALUE;
        double value2 = Double.MIN_VALUE;
        double value3 = Double.MIN_NORMAL;

        String string1 = String.valueOf(value1);
        String string2 = String.valueOf(value2);
        String string3 = String.valueOf(value3);

        assertEquals("1.7976931348623157E308", string1);
        assertEquals("4.9E-324", string2);
        assertEquals("2.2250738585072014E-308", string3);
    }

    @Test
    public void valueOfCharExample() {

        char value = '_';

        String string = String.valueOf(value);

        assertEquals("_", string);

    }

    @Test
    public void valueOfCharsExample() {

        char[] value = new char[]{'h', 'e', 'l', 'l', 'o'};

        String string1 = String.valueOf(value);
        String string2 = String.valueOf(value, 1, 3);

        assertEquals("hello", string1);
        assertEquals("ell", string2);

    }

    @Test
    public void copyValueOfExample() {

        char[] value = new char[]{'h', 'e', 'l', 'l', 'o'};

        // same as value of
        String string1 = String.copyValueOf(value);
        String string2 = String.copyValueOf(value, 1, 3);

        assertEquals("hello", string1);
        assertEquals("ell", string2);

    }

    @Test
    public void valueOfObject() {

        Object value = new Date(0L);

        String string = String.valueOf(value);

        assertEquals("Thu Jan 01 01:00:00 CET 1970", string);

    }

    @Test
    public void toCharArrayExample() {
        String string = "hello";
        char[] chars = string.toCharArray();
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, chars);
    }

    @Test
    public void charsExample() {
        String string = "hello";
        IntStream chars = string.chars();
        assertArrayEquals(new int[]{'h', 'e', 'l', 'l', 'o'}, chars.toArray());
    }

    @Test
    public void toStringExample() {
        String string1 = new String("hello");
        String string2 = string1.toString();
        assertEquals(string1, string2);
        assertTrue(string1 == string2);
    }

    @Test
    public void transformExample() {
        String string = "hello";
        Integer result = string.transform(x -> 2 * x.length());
        assertEquals(10, result.intValue());
    }

    @Test
    public void linesExample() {
        String string1 = """
                hello
                world
                """;
        Stream<String> lines1 = string1.lines();
        assertArrayEquals(new String[]{"hello", "world"}, lines1.toArray());

        String string2 = """
                hello
                world""";
        Stream<String> lines2 = string2.lines();
        assertArrayEquals(new String[]{"hello", "world"}, lines2.toArray());
    }

    @Test
    public void indentExample() {
        {
            String input = """
                    hello world""";
            String expectedOutput = """
                    hello world
                    """;
            String actualOutput = input.indent(0);
            assertEquals(expectedOutput, actualOutput);
        }
        {
            String input = """
                    hello world""";
            String expectedOutput = """
                      hello world
                    """;
            String actualOutput = input.indent(2);
            assertEquals(expectedOutput, actualOutput);
        }
        {
            String input = """
                    hello
                      world""";
            String expectedOutput = """
                       hello
                         world
                    """;
            String actualOutput = input.indent(3);
            assertEquals(expectedOutput, actualOutput);
        }
    }

    @Test
    public void stripIndentExample() {
        {
            String input = "   hello world";
            String stripped = input.stripIndent();
            assertEquals("hello world", stripped);
        }
        {
            String input = """
                    \s   hello
                          wonderful
                        world""";
            String expectedOutput = """
                    hello
                      wonderful
                    world""";
            String actualOutput = input.stripIndent();
            assertEquals(expectedOutput, actualOutput);
        }
        {
            String input = """
                    \t hello
                      world""";
            String expectedOutput = """
                    hello
                    world""";
            String actualOutput = input.stripIndent();
            assertEquals(expectedOutput, actualOutput);
        }
    }

    @Test
    public void trimExample() {

        assertEquals("a", " a ".trim());

        // Watch out: trim also removes all C0 control characters, but not C1 control characters
        char c = '\0';
        do {
            if (c == ' ' || Character.isISOControl(c)) {
                char[] chars = {c, 'a', c};
                String string = String.valueOf(chars);
                String trimmed = string.trim();
                if (c <= ' ') {
                    // C0 control character or space
                    assertEquals("a", trimmed);
                } else {
                    // C1 control character
                    assertEquals(string, trimmed);
                }
            }

        } while (++c != '\0');
    }

    @Test
    public void stripExample() {

        assertEquals("a", " a ".strip());

        // This works for all whitespaces and only whitespaces
        char c = '\0';
        do {
            char[] chars = {c, 'a', c};
            String string = String.valueOf(chars);
            String stripped = string.strip();
            if (Character.isWhitespace(c)) {
                assertEquals("a", stripped);
            } else {
                assertEquals(string, stripped);
            }
        } while (++c != '\0');
    }

    @Test
    public void stripLeadingExample() {
        assertEquals("a ", " a ".stripLeading());
    }

    @Test
    public void stripTrailingExample() {
        assertEquals(" a", " a".stripTrailing());
    }

    @Test
    public void isBlankExample() {
        assertFalse("   a   ".isBlank());
        assertTrue(" \t  \t ".isBlank());
    }

    @Test
    public void toUpperCaseExample() {
        assertEquals("HELLO", "Hello".toUpperCase());
        assertEquals("ÉTÉ", "été".toUpperCase());
    }

    @Test
    public void toLowerCaseExample() {
        assertEquals("hello", "Hello".toLowerCase());
        assertEquals("été", "ÉTÉ".toLowerCase());
    }

    @Test
    public void toUpperCaseWithLocaleExample() {

        // Note: this is one of example of not so many

        Locale trLocale = Locale.forLanguageTag("tr");

        String lowercase = "i";
        String upperCaseDefault = lowercase.toUpperCase();
        String upperCaseTr = lowercase.toUpperCase(trLocale);

        assertEquals("I", upperCaseDefault);

        String codePointName = "LATIN CAPITAL LETTER I WITH DOT ABOVE";
        int codePoint = Character.codePointOf(codePointName);
        char[] chars = Character.toChars(codePoint);
        String expected = String.valueOf(chars);
        assertEquals(expected, upperCaseTr);
    }

    @Test
    public void toLowerCaseWithLocaleExample() {

        // Lituanian local
        Locale ltLocale = Locale.forLanguageTag("lt");

        // Common input for both
        String input = "Ì";

        // Default behavior can be represented literally
        String lowerCaseDefault = input.toLowerCase();
        assertEquals("ì", lowerCaseDefault);

        // Lituanian behavior
        String lowerCaseLt = input.toLowerCase(ltLocale);

        // The result has three characters, some of which I cannot type on my keyboard
        // So I use the Unicode code point names instead
        String[] expectedLtCodePointNames = new String[]{
                "LATIN SMALL LETTER I",
                "COMBINING DOT ABOVE",
                "COMBINING GRAVE ACCENT"
        };

        // Convert the code point names to a string
        String expectedString = Arrays.stream(expectedLtCodePointNames)
                .map(Character::codePointOf)
                .map(Character::toChars)
                .map(String::new)
                .collect(Collectors.joining());

        // Here we check it's the same
        assertEquals(expectedString, lowerCaseLt);

    }

    @Test
    public void joinExample() {

        String s1 = "hello";
        String s2 = "wonderful";
        String s3 = "world";

        String delimiter = ",";

        String expected = "hello,wonderful,world";

        String joined1 = String.join(delimiter, s1, s2, s3);
        assertEquals(expected, joined1);

        String[] parts = new String[]{s1, s2, s3};
        String joined2 = String.join(delimiter, parts);
        assertEquals(expected, joined2);
    }

    @Test
    public void joinWithIterableExample() {
        Iterable<String> set = new TreeSet<>(Arrays.asList("hello", "wonderful", "world"));
        String joined = String.join(",", set);
        assertEquals("hello,wonderful,world", joined);
    }


    @Test
    public void hashCodeExample() {
        // Not much to say here
        String string = "";
        int result = string.hashCode();
        assertEquals(0, result);
    }

    @Test
    public void indexOfExample() {

        String string = "hello wonderful world";

        // "purist" way
        {
            // We start with a char
            char ch = 'w';
            // We explicitly convert that char to its codepoint
            int codePoint = Character.codePointAt(new char[]{ch}, 0);
            // That way, we explicitly stick to the method signature (int)
            int index = string.indexOf(codePoint);
            assertEquals(6, index);
        }

        // more "natural" way, with all intermediate types shown
        {
            // We start with a char
            char ch = 'w';
            // Cast to int coincides with code poitns for characters in the basic multilingual plane
            int codePoint = ch;
            // That way, we explicitly stick to the method signature (int)
            int index = string.indexOf(codePoint);
            assertEquals(6, index);
        }

        // "natural" way, with everything hidden
        {
            // Same as above
            assertEquals(6, string.indexOf('w'));
            // Case of a character not present
            assertEquals(-1, string.indexOf('z'));
        }
    }

    @Test
    public void indexOfWithFromExample() {
        String string = "hello wonderful world";
        int firstOccurence = string.indexOf('w');
        int nextOccurence = string.indexOf('w', firstOccurence + 1);
        assertEquals(16, nextOccurence);
    }

    @Test
    public void indexOfStringExample() {
        String string = "hello wonderful world";
        int index = string.indexOf("wonderful");
        assertEquals(6, index);
    }

    @Test
    public void indexOfStringFromIndexExample() {
        String string = "hello wonderful world";
        int firstOccurence = string.indexOf("wo");
        int nextOccurence = string.indexOf("wo", firstOccurence + 1);
        assertEquals(16, nextOccurence);
    }

    @Test
    public void lastIndexOfExample() {
        String string = "hello wonderful world";
        int index = string.lastIndexOf('w');
        assertEquals(16, index);
    }

    @Test
    public void lastIndexOfWithFromExample() {
        String string = "hello wonderful world";
        int lastOccurence = string.lastIndexOf('w');
        int previousOccurence = string.lastIndexOf('w', lastOccurence - 1);
        assertEquals(6, previousOccurence);
    }

    @Test
    public void lastIndexOfStringExample() {
        String string = "hello wonderful world";
        int index = string.lastIndexOf("wo");
        assertEquals(16, index);
    }

    @Test
    public void lastIndexOfStringFromIndexExample() {
        String string = "hello wonderful world";
        int lastOccurence = string.lastIndexOf("wo");
        int previousOccurence = string.lastIndexOf("wo", lastOccurence - 1);
        assertEquals(6, previousOccurence);
    }

    @Test
    public void describeConstableExample() {
        String string = "hello";
        Optional<String> result = string.describeConstable();
        assertEquals("hello", result.get());
    }

    @Test
    public void caseInsensitiveOrderExample() {
        String string1 = "hello";
        String string2 = "HELLO";
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        int comparisonResult = comparator.compare(string1, string2);
        assertEquals(0, comparisonResult);
    }

    @Test
    @SeeAlso(FormatterExample.class)
    public void formatExample() {
        String middle = "wonderful";
        String formatted = String.format("hello %1s world", middle);
        assertEquals("hello wonderful world", formatted);
    }

    @Test
    @SeeAlso(FormatterExample.class)
    public void formatWithLocaleExample() {

        Double amount = 5000.05D;
        String format = "Price: $ %(,.2f";

        String defaultFormatted = String.format(format, amount);
        assertEquals("Price: $ 5,000.05", defaultFormatted);

        String localeFormatted = String.format(Locale.FRENCH, format, amount);
        String nsbp = new String(Character.toChars(Character.codePointOf("NARROW NO-BREAK SPACE")));
        assertEquals("Price: $ 5" + nsbp + "000,05", localeFormatted);
    }

    @Test
    @SeeAlso(FormatterExample.class)
    public void formattedExample() {
        String middle = "wonderful";
        String format = "hello %1s world";
        String formatted = format.formatted(middle);
        assertEquals("hello wonderful world", formatted);
    }

    @Test
    public void codePointsExample() {
        String hello = "hello";
        IntStream codePoints = hello.codePoints();
        String[] names = codePoints.mapToObj(Character::getName).toArray(String[]::new);
        assertArrayEquals(new String[]{
                "LATIN SMALL LETTER H",
                "LATIN SMALL LETTER E",
                "LATIN SMALL LETTER L",
                "LATIN SMALL LETTER L",
                "LATIN SMALL LETTER O"
        }, names);
    }

    @Test
    public void translateEscapes() {
        String string = "hello\\tworld";
        String translated = string.translateEscapes();
        assertEquals("hello\tworld", translated);
    }

    @Test
    public void contentsEqualsStringBufferExample() {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello").append(" ").append("world");

        boolean result = "hello world".contentEquals(stringBuffer);

        assertTrue(result);
    }

    @Test
    public void contentsEqualsCharSequeneExample() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello").append(" ").append("world");

        CharSequence other = stringBuilder;

        boolean result = "hello world".contentEquals(other);

        assertTrue(result);
    }

    @Test
    public void compareToExample() {
        String hello = "hello";
        String world = "world";

        int result1 = hello.compareTo(world);
        int result2 = world.compareTo(hello);
        int result3 = hello.compareTo(hello);

        assertTrue(result1 < 0);
        assertTrue(result2 > 0);
        assertTrue(result3 == 0);
    }

    @Test
    public void compareToIgnoreCaseExample() {

        int result1 = "hello".compareTo("HELLO");
        int result2 = "hello".compareToIgnoreCase("HELLO");

        assertTrue(result1 > 1);
        assertTrue(result2 == 0);
    }

    @Test
    public void substringExample() {
        String string = "hello world";
        String result = string.substring(string.indexOf(' '));
        assertEquals(" world", result);
    }

    @Test
    public void substringBeginEndExample() {
        String string = "hello wonderful world";
        int firstSpace = string.indexOf(' ');
        int lastSpace = string.indexOf(' ', firstSpace + 1);
        String result = string.substring(firstSpace, lastSpace);
        assertEquals(" wonderful", result);
        ResultSet.class.getName();
    }

}


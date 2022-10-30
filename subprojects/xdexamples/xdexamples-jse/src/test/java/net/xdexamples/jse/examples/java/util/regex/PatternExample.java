package net.xdexamples.jse.examples.java.util.regex;

import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import xdtest.ToBeContinued;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@ToBeContinued(todos = {
        "some remaining flags + flag combination example",
        "examples of regular expression syntax"
})
public class PatternExample extends BaseExample<Pattern> {

    @Override
    public void scaffold(Pattern instance) throws Throwable {
        {
            Pattern pattern = Pattern.compile("hello.*");
            seeExamples(this::compileExample);
            ignore(pattern);
        }
        {
            // TODO: continue with other flags
            Pattern pattern = Pattern.compile("hello.*world", Pattern.DOTALL);
            seeExamples(
                    this::dotAllExample,
                    this::caseInsensitiveExample,
                    this::literalExample
            );
            ignore(pattern);
        }
        {
            String regexp = instance.pattern();
            seeExamples(this::compileExample);
            ignore(regexp);
        }
        {
            String str = instance.toString();
            seeExamples(this::compileExample);
            ignore(str);
        }

        {
            Matcher matcher = instance.matcher("hello world");
            seeExamples(this::compileExample);
            ignore(matcher);
        }
        {
            // TODO: continue with other flags
            int flags = instance.flags();
            seeExamples(
                    this::compileExample,
                    this::dotAllExample,
                    this::caseInsensitiveExample,
                    this::literalExample
            );
            ignore(flags);
        }
        {
            boolean matches = Pattern.matches("hello.*", "hello world");
            seeExamples(this::matchesExample);
            ignore(matches);
        }
        {
            String[] parts = instance.split("a,b,c");
            seeExamples(this::splitExample);
            ignore((Object) parts);
        }
        {
            String[] parts = instance.split("a,b,c", 2);
            seeExamples(this::splitWithLimit);
            ignore((Object) parts);
        }
        {
            String quotedInput = Pattern.quote("input");
            seeExamples(this::quoteExample);
            ignore(quotedInput);
        }
        {
            Predicate<String> predicate = instance.asPredicate();
            seeExamples(this::predicateExample);
            ignore(predicate);
        }
        {
            Predicate<String> predicate = instance.asMatchPredicate();
            seeExamples(this::predicateExample);
            ignore(predicate);
        }
        {
            Stream<String> stream = instance.splitAsStream("a,b,c");
            seeExamples(this::splitStreamExample);
            ignore(stream);
        }
        {
            int dotall = Pattern.DOTALL;
            seeExamples(this::dotAllExample);
            ignore(dotall);
        }
        {
            int caseInsensitive = Pattern.CASE_INSENSITIVE;
            seeExamples(this::caseInsensitiveExample);
            ignore(caseInsensitive);
        }
        {
            int literal = Pattern.LITERAL;
            seeExamples(this::literalExample);
            ignore(literal);
        }
        {
            // TODO
            int unixLines = Pattern.UNIX_LINES;
            int comments = Pattern.COMMENTS;
            int multiline = Pattern.MULTILINE;
            int unicodeCase = Pattern.UNICODE_CASE;
            int canonEq = Pattern.CANON_EQ;
            int unicodeCharacterClass = Pattern.UNICODE_CHARACTER_CLASS;
            ignore(unixLines, comments, multiline, unicodeCase, canonEq,
                    unicodeCharacterClass);
        }
    }

    @Test
    public void compileExample() {
        String regexp = "hello.*";
        String input = "hello world";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);
        assertTrue(matcher.matches());

        assertEquals(regexp, pattern.pattern());
        assertEquals(regexp, pattern.toString());
        assertEquals(0, pattern.flags());

    }

    @Test
    public void matchesExample() {
        String regexp = "hello.*";
        String input = "hello world";
        assertTrue(Pattern.matches(regexp, input));
    }

    @Test
    public void splitExample() {
        String regexp = "\s*,\s*";
        String input = "a  ,   b   ,  c ,  d";
        Pattern pattern = Pattern.compile(regexp);
        String[] parts = pattern.split(input);
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, parts);
    }

    @Test
    public void splitWithLimit() {
        String regexp = ",";
        Pattern pattern = Pattern.compile(regexp);
        // limit = -1 : ignore trailing blank matches
        // limit = 0 : do not ignore trailing blank matches
        // limit = 1 : gives back the input, no split
        // limit > 1 : gives back an array with at most that many elements
        {
            String input = "a,b,c,d";
            assertArrayEquals(new String[]{"a,b,c,d"}, pattern.split(input, 1));
            assertArrayEquals(new String[]{"a", "b,c,d"}, pattern.split(input, 2));
            assertArrayEquals(new String[]{"a", "b", "c,d"}, pattern.split(input, 3));
            assertArrayEquals(new String[]{"a", "b", "c", "d"}, pattern.split(input, 4));
            assertArrayEquals(new String[]{"a", "b", "c", "d"}, pattern.split(input, 5));
            assertArrayEquals(new String[]{"a", "b", "c", "d"}, pattern.split(input, 0));
            assertArrayEquals(new String[]{"a", "b", "c", "d"}, pattern.split(input, -1));
        }
        {
            String input = "abcd";
            assertArrayEquals(new String[]{"abcd"}, pattern.split(input, -1));
            assertArrayEquals(new String[]{"abcd"}, pattern.split(input, 0));
            assertArrayEquals(new String[]{"abcd"}, pattern.split(input, 1));
        }
        {
            String input = "a,";
            assertArrayEquals(new String[]{"a", ""}, pattern.split(input, -1));
            assertArrayEquals(new String[]{"a"}, pattern.split(input, 0));
            assertArrayEquals(new String[]{"a,"}, pattern.split(input, 1));
        }
        {
            String input = ",a";
            assertArrayEquals(new String[]{"", "a"}, pattern.split(input, -1));
            assertArrayEquals(new String[]{"", "a"}, pattern.split(input, 0));
            assertArrayEquals(new String[]{",a"}, pattern.split(input, 1));
        }
        {
            String input = "";
            assertArrayEquals(new String[]{""}, pattern.split(input, -1));
            assertArrayEquals(new String[]{""}, pattern.split(input, 0));
            assertArrayEquals(new String[]{""}, pattern.split(input, 1));
        }
        {
            String input = "a,,b,,,";
            assertArrayEquals(new String[]{"a", "", "b", "", "", ""}, pattern.split(input, -1));
            assertArrayEquals(new String[]{"a", "", "b"}, pattern.split(input, 0));
            assertArrayEquals(new String[]{"a,,b,,,"}, pattern.split(input, 1));
        }
    }

    @Test
    public void splitStreamExample() {
        String regexp = ",";
        String input = "a,b,c,,";
        Pattern pattern = Pattern.compile(regexp);
        // NOTE: it's not possible to set the limit to -1
        String[] parts = pattern.splitAsStream(input)
                .map(String::toUpperCase)
                .toArray(String[]::new);
        assertArrayEquals(new String[]{"A", "B", "C"}, parts);
    }

    @Test
    public void predicateExample() {
        Pattern pattern = Pattern.compile("hello");

        // uses Matcher::matches to check the whole string
        Predicate<String> matchPredicate = pattern.asMatchPredicate();

        // uses Matcher::find to find a substring that matches
        Predicate<String> findPredicate = pattern.asPredicate();

        assertFalse(matchPredicate.test("hello world"));
        assertTrue(findPredicate.test("hello world"));

        assertTrue(matchPredicate.test("hello"));
        assertTrue(findPredicate.test("hello"));
    }

    @Test
    public void dotAllExample() {
        String regexp = "hello.*world";
        String input1 = "hello world";
        String input2 = "hello\nworld";
        {
            Pattern pattern = Pattern.compile(regexp);
            assertTrue(pattern.matcher(input1).matches());
            assertFalse(pattern.matcher(input2).matches());
            assertEquals(0, pattern.flags());
        }
        {
            // treat newlines as whitespaces for '.'
            Pattern pattern = Pattern.compile(regexp, Pattern.DOTALL);
            assertTrue(pattern.matcher(input1).matches());
            assertTrue(pattern.matcher(input2).matches());
            assertEquals(Pattern.DOTALL, pattern.flags());

        }
    }

    @Test
    public void caseInsensitiveExample() {
        {
            Pattern pattern = Pattern.compile("hello");
            assertTrue(pattern.matcher("hello").matches());
            assertFalse(pattern.matcher("hElLo").matches());
            assertEquals(0, pattern.flags());
        }
        {
            Pattern pattern = Pattern.compile("hello", Pattern.CASE_INSENSITIVE);
            assertTrue(pattern.matcher("hello").matches());
            assertTrue(pattern.matcher("hElLo").matches());
            assertEquals(Pattern.CASE_INSENSITIVE, pattern.flags());

        }
    }

    @Test
    public void literalExample() {
        String regex = "hello.*world";
        String input1 = "hello.*world";
        String input2 = "hello world";
        {
            Pattern pattern = Pattern.compile(regex);
            assertTrue(pattern.matcher(input1).matches());
            assertTrue(pattern.matcher(input2).matches());
            assertEquals(0, pattern.flags());
        }
        {
            Pattern pattern = Pattern.compile(regex, Pattern.LITERAL);
            assertTrue(pattern.matcher(input1).matches());
            assertFalse(pattern.matcher(input2).matches());
            assertEquals(Pattern.LITERAL, pattern.flags());

        }
    }


    @Test
    public void quoteExample() {
        // TODO: more real-life example for when to use that
        String input = "hello";
        String quoted1 = "\\Qhello\\E";
        String quoted2 = "\\Q\\Qhello\\E\\\\E\\Q\\E";
        assertEquals(quoted1, Pattern.quote(input));
        assertEquals(quoted2, Pattern.quote(quoted1));
        System.out.println(input + " => " + quoted1);
        System.out.println(quoted1 + " => " + quoted2);
    }
}

package net.xdexamples.jse.examples.java.util;

import org.junit.Test;
import net.xdexamples.BaseExample;
import net.xdexamples.Done;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.StringTokenizer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@Done
public class StringTokenizerExample extends BaseExample<StringTokenizer> {

    @Override
    public void scaffold(StringTokenizer instance) {
        {
            StringTokenizer stringTokenizer = new StringTokenizer("hello world");
            seeExamples(
                    this::example,
                    this::enumeratorExample
            );
            ignore(stringTokenizer);
        }

        {
            StringTokenizer stringTokenizer = new StringTokenizer("hello,world", ",");
            seeExamples(
                    this::delimExample,
                    this::countExample,
                    this::nextTokenWithDelimExample
            );
            ignore(stringTokenizer);
        }

        {
            StringTokenizer stringTokenizer = new StringTokenizer("hello,world", ",", true);
            seeExamples(this::returnDelimsExample);
            ignore(stringTokenizer);
        }

        {
            boolean hasMoreTokens = instance.hasMoreTokens();
            seeExamples(
                    this::example,
                    this::delimExample,
                    this::returnDelimsExample,
                    this::countExample,
                    this::nextTokenWithDelimExample
            );
            ignore(hasMoreTokens);
        }

        {
            boolean hasMoreElements = instance.hasMoreElements();
            seeExamples(
                    this::enumeratorExample
            );
            ignore(hasMoreElements);
        }

        {
            String nextToken = instance.nextToken();
            seeExamples(
                    this::example,
                    this::delimExample,
                    this::returnDelimsExample,
                    this::countExample,
                    this::nextTokenWithDelimExample

            );
            ignore(nextToken);
        }

        {
            String token = instance.nextToken("!");
            seeExamples(
                    this::nextTokenWithDelimExample
            );
            ignore(token);
        }

        {
            Object nextElement = instance.nextElement();
            seeExamples(this::enumeratorExample);
            ignore(nextElement);
        }

        {
            int count = instance.countTokens();
            seeExamples(this::countExample);
            ignore(count);
        }

    }

    @Test
    public void example() {
        StringTokenizer tokenizer = new StringTokenizer("a\tb\rc\nd\fe f");
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        assertArrayEquals(new String[]{"a", "b", "c", "d", "e", "f"}, tokens.toArray());
    }

    @Test
    public void enumeratorExample() {
        Enumeration<Object> tokenizer = new StringTokenizer("a\tb\rc\nd\fe f");
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            tokens.add((String) tokenizer.nextElement());
        }
        assertArrayEquals(new String[]{"a", "b", "c", "d", "e", "f"}, tokens.toArray());
    }

    @Test
    public void delimExample() {
        StringTokenizer tokenizer = new StringTokenizer("a,b,c,d,e,f", ",");
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        assertArrayEquals(new String[]{"a", "b", "c", "d", "e", "f"}, tokens.toArray());
    }

    @Test
    public void returnDelimsExample() {
        StringTokenizer tokenizer = new StringTokenizer("a,b,c", ",", true);
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        assertArrayEquals(new String[]{"a", ",", "b", ",", "c"}, tokens.toArray());
    }

    @Test
    public void countExample() {
        StringTokenizer tokenizer = new StringTokenizer("a,b,c", ",");

        String firstToken = tokenizer.nextToken();
        assertEquals("a", firstToken);

        assertEquals(2, tokenizer.countTokens());
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        assertArrayEquals(new String[]{"b", "c"}, tokens.toArray());
    }

    @Test
    public void nextTokenWithDelimExample() {
        StringTokenizer tokenizer = new StringTokenizer("a!b!c!d", ",");
        ArrayList<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken("!"));
        }
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, tokens.toArray());
    }
}

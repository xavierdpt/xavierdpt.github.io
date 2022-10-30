package net.xdexamples.jse.examples.java.util;

import org.junit.Test;
import net.xdexamples.BaseExample;
import net.xdexamples.AllMethodsCovered;

import java.util.StringJoiner;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@AllMethodsCovered
public class StringJoinerExample extends BaseExample<StringJoiner> {
    @Override
    public void scaffold(StringJoiner instance) throws Throwable {

        {
            StringJoiner stringJoiner = new StringJoiner(",");
            seeExamples(this::example);
            ignore(stringJoiner);
        }

        {
            StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
            seeExamples(
                    this::examplePrefixSuffix,
                    this::mergeExample
            );
            ignore(stringJoiner);
        }

        {
            StringJoiner stringJoiner = instance.add("hello");
            seeExamples(
                    this::example,
                    this::examplePrefixSuffix,
                    this::mergeExample
            );
            ignore(stringJoiner);
        }

        {
            String result = instance.toString();
            seeExamples(
                    this::example,
                    this::exampleEmpty,
                    this::examplePrefixSuffix,
                    this::mergeExample
            );
            ignore(result);
        }

        {
            int length = instance.length();
            seeExamples(
                    this::example,
                    this::exampleEmpty
            );
            ignore(length);
        }

        {
            StringJoiner stringJoiner = instance.setEmptyValue("empty!");
            seeExamples(
                    this::exampleEmpty,
                    this::examplePrefixSuffix
            );
            ignore(stringJoiner);
        }

        {
            StringJoiner other = new StringJoiner("!");
            StringJoiner merged = instance.merge(other);
            seeExamples(this::mergeExample);
            ignore(merged);
        }
    }

    @Test
    public void example() {
        String delimiter = ", ";
        StringJoiner stringJoiner = new StringJoiner(delimiter);
        String apple = "apple";
        String orange = "orange";
        String pear = "pear";
        String banana = "banana";
        stringJoiner.add(apple).add(orange).add(pear).add(banana);
        int expectedLength = Stream.of(apple, orange, pear, banana)
                                     .mapToInt(String::length)
                                     .sum()
                             + 3 * delimiter.length();
        assertEquals(expectedLength, stringJoiner.length());
        assertEquals("apple, orange, pear, banana", stringJoiner.toString());
    }

    @Test
    public void exampleEmpty() {

        StringJoiner stringJoiner = new StringJoiner(", ");
        assertEquals(0, stringJoiner.length());
        assertEquals("", stringJoiner.toString());

        String emptyValue = "empty!";
        stringJoiner.setEmptyValue(emptyValue);
        assertEquals(emptyValue.length(), stringJoiner.length());
        assertEquals(emptyValue, stringJoiner.toString());
    }

    @Test
    public void examplePrefixSuffix() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.setEmptyValue("!empty");
        assertEquals("!empty", stringJoiner.toString());

        stringJoiner.add("hello").add("world");
        assertEquals("[hello,world]", stringJoiner.toString());
    }

    @Test
    public void mergeExample() {
        StringJoiner stringJoiner1 = new StringJoiner(",", "[", "]");
        StringJoiner stringJoiner2 = new StringJoiner("!", "{", "}");
        stringJoiner1.add("hello").add("world");
        stringJoiner2.add("apple").add("tree");
        StringJoiner merged = stringJoiner1.merge(stringJoiner2);
        merged.add("something");
        assertEquals("[hello,world,apple!tree,something]", merged.toString());
    }

}

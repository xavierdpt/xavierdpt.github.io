package net.xdexamples.jse.examples.java.util;

import org.junit.Test;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.AllMethodsCovered;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@AllMethodsCovered
public class IteratorExample extends BaseExample<Iterator<Dummy>> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(Iterator<Dummy> instance) throws Throwable {
        {
            boolean hasNext = instance.hasNext();
            seeExamples(
                    this::example,
                    this::removeSupportedExample,
                    this::removeNotSupportedExample
            );
        }

        {
            Dummy value = instance.next();
            seeExamples(
                    this::example,
                    this::removeSupportedExample,
                    this::removeNotSupportedExample,
                    this::forEachRemainingExample
            );
        }

        {
            instance.remove();
            seeExamples(
                    this::removeSupportedExample,
                    this::removeNotSupportedExample
            );
        }

        {
            instance.forEachRemaining(System.out::println);
            seeExamples(this::forEachRemainingExample);
        }
    }

    @Test
    public void example() {
        List<String> values = Arrays.asList("hello", "world");
        Iterator<String> iterator = values.iterator();
        int count = -1;
        while (iterator.hasNext()) {
            String value = iterator.next();
            assertEquals(values.get(++count), value);
        }
    }

    @Test
    public void removeSupportedExample() {
        List<String> values = new ArrayList<>(Arrays.asList("hello", ",", "world"));
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (",".equals(value)) {
                iterator.remove();
            }
        }
        assertArrayEquals(new String[]{"hello", "world"}, values.toArray());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeNotSupportedExample() {
        List<String> values = Arrays.asList("hello", ",", "world");
        Iterator<String> iterator = values.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (",".equals(value)) {
                iterator.remove();
            }
        }
    }

    @Test
    public void forEachRemainingExample() {
        List<String> values = Arrays.asList("hello", "Java", "world");
        int[] sumLen = new int[1];
        Iterator<String> iterator = values.iterator();
        assertEquals("hello", iterator.next());
        iterator.forEachRemaining(x -> sumLen[0] += x.length());
        assertEquals("Java".length() + "world".length(), sumLen[0]);
    }

}

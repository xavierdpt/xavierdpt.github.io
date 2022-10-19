package xd.examples.java.util;

import org.junit.Test;
import xd.BaseExample;
import xd.examples.java.util.stream.StreamExample;
import xd.helpers.dummies.Dummy;
import xdtest.Done;
import xdtest.Scaffolded;
import xdtest.SeeOther;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Done
public class CollectionExample extends BaseExample<Collection<Dummy>> {

    @Override
    @SuppressWarnings("unused")
    public void scaffold(Collection<Dummy> instance) {

        {
            Dummy value = new Dummy();
            boolean added = instance.add(value);
            seeExamples(this::example);
        }


        {
            Dummy value = new Dummy();
            boolean contains = instance.contains(value);
            seeExamples(this::example);
        }

        {
            boolean empty = instance.isEmpty();
            seeExamples(this::example);
        }

        {
            Dummy value = new Dummy();
            boolean removed = instance.remove(value);
            seeExamples(this::example);
        }

        {
            int size = instance.size();
            seeExamples(this::example);
        }

        {
            Object[] array = instance.toArray();
            seeExamples(this::toArrayExample);
        }

        {
            Dummy[] array = instance.toArray(new Dummy[0]);
            seeExamples(this::toArrayExample);
        }

        {
            Dummy[] array = instance.toArray(Dummy[]::new);
            seeExamples(this::toArrayExample);
        }

        {
            Collection<Dummy> other = null;
            boolean modified = instance.removeAll(other);
            seeExamples(this::removeAllExample);
        }

        {
            Predicate<Dummy> predicate = null;
            boolean modified = instance.removeIf(predicate);
            seeExamples(this::removeIfExample);
        }


        {
            Collection<Dummy> other = null;
            boolean modified = instance.retainAll(other);
            seeExamples(this::retainAllExample);
        }

        {
            Spliterator<Dummy> spliterator = instance.spliterator();
            seeExamples(this::spliteratorExample);
        }

        {
            Stream<Dummy> stream = instance.stream();
            seeExamples(this::streamExample);
        }

        {
            Iterator<Dummy> iterator = instance.iterator();
            seeExamples(this::iteratorExample);
        }

        {
            Stream<Dummy> stream = instance.parallelStream();
            seeExamples(this::streamExample);
        }


        {
            Collection<Dummy> other = null;
            boolean equals = instance.equals(other);
            seeExamples(this::equalsExample);
        }

        {
            int hashCode = instance.hashCode();
            seeExamples(this::hashcodeExample);
        }

        {
            Collection<Dummy> other = null;
            boolean containsAll = instance.containsAll(other);
            seeExamples(this::containsAllExample);
        }

        {
            Collection<Dummy> other = null;
            boolean added = instance.addAll(other);
            seeExamples(this::addAllExample);
        }

        {
            instance.clear();
            seeExamples(
                    this::clearExample,
                    this::clearNotSupportedExample
            );
        }
    }

    @Test
    public void example() {
        Collection<String> collection = new ArrayList<>();

        assertTrue(collection.isEmpty());
        assertEquals(0, collection.size());

        assertTrue(collection.add("hello"));
        assertTrue(collection.add("world"));

        assertFalse(collection.isEmpty());
        assertEquals(2, collection.size());

        assertTrue(collection.contains("world"));
        assertFalse(collection.contains("you"));

        assertTrue(collection.remove("hello"));

        assertFalse(collection.contains("hello"));
        assertEquals(1, collection.size());

        assertFalse(collection.remove("hello"));
    }

    @Test
    public void toArrayExample() {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");

        Object[] array = collection.toArray();
        assertArrayEquals(new String[]{"hello", "world"}, array);

        String[] typedArray = collection.toArray(new String[0]);
        assertArrayEquals(new String[]{"hello", "world"}, typedArray);

        String[] larger = new String[]{".", ".", "."};
        String[] same = collection.toArray(larger);
        assertTrue(larger == same);
        assertArrayEquals(new String[]{"hello", "world", null}, larger);

        String[] smaller = new String[]{"."};
        String[] notSame = collection.toArray(smaller);
        assertArrayEquals(new String[]{"."}, smaller);
        assertArrayEquals(new String[]{"hello", "world"}, notSame);

        // Note: size is actually ignored because it is always called with size=0, at least for ArrayList
        IntFunction<String[]> generator = size -> new String[size];
        String[] generated = collection.toArray(generator);
        assertArrayEquals(new String[]{"hello", "world"}, generated);

        // This won't work as expected, it's called with size=0 so we don't get a larger array that has predefined value
        // but always String[0]
        IntFunction<String[]> generator2 = size -> {
            String[] newArray = new String[size + 1];
            Arrays.fill(newArray, ".");
            return newArray;
        };
        String[] generated2 = collection.toArray(generator2);
        assertArrayEquals(new String[]{"hello", "world"}, generated2);
    }

    @Test
    @SeeOther(StreamExample.class)
    public void streamExample() {
        Collection<String> collection = new ArrayList<>();

        Stream<String> stream = collection.stream();
        assertFalse(stream.isParallel());

        Stream<String> parallelStream = collection.parallelStream();
        assertTrue(parallelStream.isParallel());
    }

    @Test
    @SeeOther(SpliteratorExample.class)
    public void spliteratorExample() {
        Collection<String> collection = new ArrayList<>();
        Spliterator<String> spliterator = collection.spliterator();
        assertNotNull(spliterator);
    }

    @Test
    @SeeOther(IteratorExample.class)
    public void iteratorExample() {
        Collection<String> collection = new ArrayList<>();
        Iterator<String> iterator = collection.iterator();
        assertNotNull(iterator);
    }

    @Test
    public void clearExample() {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");

        assertFalse(collection.isEmpty());

        collection.clear();

        assertTrue(collection.isEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clearNotSupportedExample() {
        Collection<String> collection = Arrays.asList("hello", "world");
        collection.clear();
    }

    @Test
    public void hashcodeExample() {
        Collection<String> collection = new ArrayList<>();
        collection.add("hello");
        collection.add("world");

        int hashCode1 = collection.hashCode();

        collection.add(".");
        collection.remove(".");

        int hashCode3 = collection.hashCode();

        assertEquals(hashCode1, hashCode3);
    }

    @Test
    public void equalsExample() {

        Collection<String> elements = Arrays.asList("hello", "world");

        Collection<String> collection1 = new ArrayList<>(elements);
        Collection<String> collection2 = new LinkedList<>(elements);

        assertNotEquals(collection1.getClass(), collection2.getClass());
        assertTrue(collection1.equals(collection2));
    }

    @Test
    public void addAllExample() {

        Collection<String> array = Arrays.asList("hello", "world");

        Collection<String> collection = new ArrayList<>();
        collection.add("[");
        boolean added = collection.addAll(array);
        collection.add("]");

        assertTrue(added);
        assertArrayEquals(new String[]{"[", "hello", "world", "]"}, collection.toArray());
    }

    @Test
    public void containsAllExample() {

        Collection<String> array = Arrays.asList("hello", "world");
        Collection<String> collection = new ArrayList<>(Arrays.asList("[", "hello", ",", "world", "]"));

        assertTrue(collection.containsAll(array));
    }

    @Test
    public void retainAllExample() {

        Collection<String> array = Arrays.asList("world", "hello");
        Collection<String> collection = new ArrayList<>(Arrays.asList("[", "hello", ",", "world", "]"));

        boolean modified1 = collection.retainAll(array);

        assertTrue(modified1);
        assertArrayEquals(new String[]{"hello", "world"}, collection.toArray());

        boolean modified2 = collection.retainAll(array);
        assertFalse(modified2);
    }

    @Test
    public void removeAllExample() {

        Collection<String> array = Arrays.asList("world", "hello");
        Collection<String> collection = new ArrayList<>(Arrays.asList("[", "hello", ",", "world", "]"));

        boolean modified1 = collection.removeAll(array);

        assertTrue(modified1);
        assertArrayEquals(new String[]{"[", ",", "]"}, collection.toArray());

        boolean modified2 = collection.removeAll(array);
        assertFalse(modified2);
    }

    @Test
    public void removeIfExample() {


        Collection<String> collection = new ArrayList<>(Arrays.asList("hello", "wonderful", "world"));

        Predicate<String> predicate = s -> s.length() > "hello".length();

        boolean modified1 = collection.removeIf(predicate);

        assertTrue(modified1);
        assertArrayEquals(new String[]{"hello", "world"}, collection.toArray());

        boolean modified2 = collection.removeIf(predicate);
        assertFalse(modified2);
    }

}

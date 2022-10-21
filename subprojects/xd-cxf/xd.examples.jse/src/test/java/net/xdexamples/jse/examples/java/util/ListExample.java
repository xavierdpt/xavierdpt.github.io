package net.xdexamples.jse.examples.java.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.DummyClass;
import net.xdexamples.Scaffolded;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Scaffolded
public class ListExample extends BaseExample<List<DummyClass>> {

    @Override
    public void scaffold(List<DummyClass> instance) throws Throwable {
        DummyClass value = new DummyClass();
        {
            int size = instance.size();
            seeExamples(this::example);
            ignore(size);
        }
        {
            boolean empty = instance.isEmpty();
            seeExamples(this::example);
            ignore(empty);
        }
        Object x = null;
        {
            boolean contains = instance.contains(value);
            seeExamples(this::example);
            ignore(contains);
        }
        {
            // TODO
            Iterator<DummyClass> iterator = instance.iterator();
        }
        {
            Object[] objects = instance.toArray();
            seeExamples(this::example);
            ignore(objects);
        }
        {
            Object[] objects = instance.toArray(Object[]::new);
            seeExamples(this::example);
            ignore(objects);
        }
        DummyClass a = null;
        {
            boolean added = instance.add(value);
            seeExamples(this::example);
            ignore(added);
        }
        {
            boolean removed = instance.remove(a);
            seeExamples(this::example);
            ignore(removed);

        }
        Collection<?> coll = null;
        {
            // TODO
            boolean b = instance.containsAll(coll);
        }
        Collection<? extends DummyClass> coll1 = null;
        {
            // TODO
            boolean b1 = instance.addAll(coll1);
        }
        int index = 0;
        {
            // TODO
            instance.addAll(index, coll1);
        }
        {
            // TODO
            boolean b2 = instance.removeAll(coll);
        }
        {
            // TODO
            boolean b3 = instance.retainAll(coll);
        }
        {
            instance.replaceAll(item -> new DummyClass());
            seeExamples(this::replaceAllExample);
        }
        {
            instance.sort(Comparator.comparingInt(Object::hashCode));
            seeExamples(this::sortExample);
        }
        {
            instance.clear();
            seeExamples(this::clearExample);
        }

        {
            DummyClass value1 = instance.get(10);
            seeExamples(this::getAndSetExample);
            ignore(value1);
        }
        {
            DummyClass previousValue = instance.set(10, value);
            seeExamples(this::getAndSetExample);
            ignore(previousValue);
        }
        {
            boolean added = instance.add(value);
            seeExamples(this::addExample);
            ignore(added);
        }
        {
            boolean removed = instance.remove(value);
            seeExamples(this::removeExample);
            ignore(removed);
        }
        {
            int indexx = instance.indexOf(value);
            seeExamples(this::indexExample);
            ignore(indexx);
        }
        {
            int indexx = instance.lastIndexOf(value);
            seeExamples(this::indexExample);
            ignore(indexx);
        }
        {
            List<DummyClass> subList = instance.subList(1, 3);
            seeExamples(this::sublistExample);
            ignore(subList);
        }
        {
            List<DummyClass> value1 = List.of(value);
            List<DummyClass> value2 = List.of(value, value);
            List<DummyClass> value3 = List.of(value, value, value);
            // ...
            seeExamples(this::ofExamples);
            ignore(value1, value2, value3);
        }


        {
            // TODO
            ListIterator<DummyClass> iterator = instance.listIterator();
            ignore(iterator);
        }
        {
            // TODO
            ListIterator<DummyClass> iterator = instance.listIterator(index);
            ignore(iterator);
        }
        {
            // TODO
            Spliterator<DummyClass> spliterator = instance.spliterator();
            ignore(spliterator);
        }
        {
            // TODO
            List<?> result = List.copyOf(coll);
            ignore(result);
        }
        {
            // TODO
            List<DummyClass> other = null;
            boolean equals = instance.equals(other);
        }
        {
            // TODO
            int i = instance.hashCode();
        }
    }

    @Test
    public void example() {

        List<String> list = new ArrayList<>();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertFalse(list.contains(""));
        assertArrayEquals(new String[0], list.toArray());
        assertArrayEquals(new String[0], list.toArray(String[]::new));

        assertTrue(list.add("hello"));
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertArrayEquals(new String[]{"hello"}, list.toArray());
        assertArrayEquals(new String[]{"hello"}, list.toArray(String[]::new));

        assertFalse(list.remove("world"));
        assertTrue(list.remove("hello"));
        assertTrue(list.isEmpty());
    }

    @Test
    public void replaceAllExample() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.replaceAll(String::toUpperCase);
        assertArrayEquals(new String[]{"HELLO", "WORLD"}, list.toArray());
    }

    @Test
    public void sortExample() {
        List<String> list = new ArrayList<>();
        list.add("this");
        list.add("is");
        list.add("an");
        list.add("example");
        list.sort(Comparator.comparingInt(String::length));
        assertArrayEquals(new String[]{"is", "an", "this", "example"}, list.toArray());
    }

    @Test
    public void clearExample() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void getAndSetExample() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        assertEquals("world", list.get(1));
        assertArrayEquals(new String[]{"hello", "world"}, list.toArray());

        String previousValue = list.set(1, "you");
        assertEquals("you", list.get(1));
        assertArrayEquals(new String[]{"hello", "you"}, list.toArray());
        assertEquals("world", previousValue);
    }

    @Test
    public void addExample() {
        List<String> list = new ArrayList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        boolean added = list.add("hello");
        assertTrue(added);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("hello", list.get(0));
    }

    @Test
    public void removeExample() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        assertArrayEquals(new String[]{"hello", "world"}, list.toArray());

        boolean removed = list.remove("hello");
        assertArrayEquals(new String[]{"world"}, list.toArray());
        assertTrue(removed);

        removed = list.remove("hello");
        assertFalse(removed);
    }

    @Test
    public void indexExample() {
        List<String> list = new ArrayList<>();
        list.add("la");
        list.add("li");
        list.add("la");
        list.add("la");

        assertEquals(0, list.indexOf("la"));
        assertEquals(1, list.indexOf("li"));
        assertEquals(3, list.lastIndexOf("la"));
    }

    @Test
    public void ofExamples() throws NoSuchMethodException {
        final List<Integer> list1 = List.of(1);

        // Lists constructed with of(..) are immutables
        Assert.assertThrows(UnsupportedOperationException.class,
                () -> list1.add(2));

        // of(...) can accept arbitrarily many arguments
        // Note: up to 10 values, fixed-arity functions are defined for improved performance
        List<Integer> list2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14);
        assertEquals(14, list2.size());
    }

    @Test
    public void sublistExample() {
        List<String> list = List.of("I", "am", "the", "king");
        List<String> subList = list.subList(2, 4);
        assertArrayEquals(new String[]{"the", "king"}, subList.toArray());

        List<String> subList2 = list.subList(list.indexOf("the"), list.indexOf("king") + 1);
        assertArrayEquals(new String[]{"the", "king"}, subList2.toArray());
    }
}

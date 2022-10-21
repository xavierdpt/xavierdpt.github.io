package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.Scaffolded;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@Scaffolded
public class ArrayListExample extends BaseExample<ArrayList<Dummy>> {
    @Override
    public void scaffold(ArrayList<Dummy> instance) {
        int capacity = 0;
        Collection<? extends Dummy> collection = null;
        ignore(
                new ArrayList<Dummy>(),
                new ArrayList<Dummy>(capacity),
                new ArrayList<Dummy>(collection)
        );

        Dummy value = null;
        boolean add = instance.add(value);

        int index = 0;
        instance.add(index, value);

        boolean b = instance.addAll(collection);

        boolean b1 = instance.addAll(index, collection);

        instance.clear();

        Object clone = instance.clone();

        boolean contains = instance.contains(value);

        instance.ensureCapacity(capacity);

        ArrayList<Dummy> other = null;
        boolean equals = instance.equals(other);

        Consumer<? super Dummy> consumer = null;
        instance.forEach(consumer);

        Dummy dummy = instance.get(index);

        int i = instance.hashCode();

        int i1 = instance.indexOf(value);

        boolean empty = instance.isEmpty();

        Iterator<Dummy> iterator = instance.iterator();

        int i2 = instance.lastIndexOf(value);

        ListIterator<Dummy> dummyListIterator = instance.listIterator();

        ListIterator<Dummy> dummyListIterator1 = instance.listIterator(index);

        Dummy remove = instance.remove(index);

        boolean remove1 = instance.remove(value);

        boolean b2 = instance.removeAll(collection);

        Predicate<? super Dummy> predicate = null;
        boolean b3 = instance.removeIf(predicate);

        UnaryOperator<Dummy> operator = null;
        instance.replaceAll(operator);

        boolean b4 = instance.retainAll(collection);

        Dummy set = instance.set(index, value);

        int size = instance.size();

        Comparator<? super Dummy> comparator = null;
        instance.sort(comparator);

        Spliterator<Dummy> spliterator = instance.spliterator();

        int fromIndex = 0;
        int toIndex = 0;
        List<Dummy> dummies = instance.subList(fromIndex, toIndex);

        Object[] objects = instance.toArray();

        Dummy[] dummies1 = instance.toArray(new Dummy[0]);

        instance.trimToSize();
    }
}

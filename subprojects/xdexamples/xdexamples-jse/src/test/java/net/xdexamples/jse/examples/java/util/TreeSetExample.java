package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.Scaffolded;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;

@Scaffolded
public class TreeSetExample extends BaseExample<TreeSet<Dummy>> {

    @Override
    public void scaffold(TreeSet<Dummy> instance) {
        Comparator<Dummy> comparator = null;
        Collection<Dummy> collection = null;
        SortedSet<Dummy> sortedSet = null;
        ignore(
                new TreeSet<Dummy>(),
                new TreeSet<>(comparator),
                new TreeSet<>(collection),
                new TreeSet<>(sortedSet)
        );

        Dummy value = null;
        instance.add(value);

        boolean b = instance.addAll(collection);

        Dummy ceiling = instance.ceiling(value);

        instance.clear();

        Object clone = instance.clone();

        Comparator<? super Dummy> comparator1 = instance.comparator();

        Dummy object = null;
        instance.contains(object);

        Iterator<Dummy> dummyIterator = instance.descendingIterator();

        NavigableSet<Dummy> dummies = instance.descendingSet();

        Dummy first = instance.first();

        Dummy floor = instance.floor(value);

        SortedSet<Dummy> dummies1 = instance.headSet(value);

        boolean inclusive = false;
        NavigableSet<Dummy> dummies2 = instance.headSet(value, inclusive);

        Dummy higher = instance.higher(value);

        boolean empty = instance.isEmpty();

        Iterator<Dummy> iterator = instance.iterator();

        Dummy last = instance.last();

        Dummy lower = instance.lower(value);

        Dummy dummy = instance.pollFirst();

        Dummy dummy1 = instance.pollLast();

        Dummy obj = null;
        boolean remove = instance.remove(obj);

        int size = instance.size();

        Spliterator<Dummy> spliterator = instance.spliterator();

        Dummy fromElement = null;
        Dummy toElement = null;
        SortedSet<Dummy> dummies3 = instance.subSet(fromElement, toElement);

        NavigableSet<Dummy> dummies4 = instance.subSet(fromElement, inclusive, toElement, inclusive);

        SortedSet<Dummy> dummies5 = instance.tailSet(fromElement);

        NavigableSet<Dummy> dummies6 = instance.tailSet(fromElement, inclusive);

    }

}

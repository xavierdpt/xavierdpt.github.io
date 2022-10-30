package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.Scaffolded;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;

@Scaffolded
public class HashSetExample extends BaseExample<HashSet<Dummy>> {
    @Override
    public void scaffold(HashSet<Dummy> instance) throws Throwable {
        int capacity = 0;
        float loadFactor = 0;
        Collection<Dummy> collection = null;
        ignore(
                new HashSet<Dummy>(),
                new HashSet<Dummy>(capacity),
                new HashSet<Dummy>(capacity, loadFactor),
                new HashSet<>(collection)
        );

        Dummy value = null;
        boolean add = instance.add(value);

        instance.clear();

        Object clone = instance.clone();

        boolean contains = instance.contains(value);

        boolean empty = instance.isEmpty();

        Iterator<Dummy> iterator = instance.iterator();

        boolean remove = instance.remove(value);

        int size = instance.size();

        Spliterator<Dummy> spliterator = instance.spliterator();

        Object[] objects = instance.toArray();

        Dummy[] dummies = instance.toArray(new Dummy[0]);
    }
}

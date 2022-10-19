package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.Scaffolded;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Scaffolded
public class PriorityQueueExample extends BaseExample<PriorityQueue<Dummy>> {

    @Override
    public void scaffold(PriorityQueue<Dummy> instance) {
        int capacity = 0;
        Comparator<Dummy> comparator = null;
        Collection<Dummy> collection = null;
        PriorityQueue<Dummy> other = null;
        SortedSet<Dummy> sortedSet = null;
        ignore(
                new PriorityQueue<Dummy>(),
                new PriorityQueue<Dummy>(capacity),
                new PriorityQueue<Dummy>(comparator),
                new PriorityQueue<Dummy>(capacity, comparator),
                new PriorityQueue<Dummy>(collection),
                new PriorityQueue<Dummy>(other),
                new PriorityQueue<Dummy>(sortedSet)
        );

        Dummy value = null;
        Consumer<Dummy> consumer = null;
        Predicate<Dummy> predicate = null;

        instance.add(value);
        instance.clear();
        Comparator<? super Dummy> comparator1 = instance.comparator();
        boolean contains = instance.contains(value);
        instance.forEach(consumer);
        Iterator<Dummy> iterator = instance.iterator();
        boolean offer = instance.offer(value);
        Dummy peek = instance.peek();
        Dummy poll = instance.poll();
        boolean remove = instance.remove(value);
        boolean b = instance.removeAll(collection);
        boolean b1 = instance.removeIf(predicate);
        boolean b2 = instance.retainAll(collection);
        int size = instance.size();
        Spliterator<Dummy> spliterator = instance.spliterator();
        Object[] objects = instance.toArray();
        Dummy[] dummies = instance.toArray(new Dummy[0]);
    }

}

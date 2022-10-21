package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.Scaffolded;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Spliterator;

@Scaffolded
public class LinkedListExample extends BaseExample<LinkedList<Dummy>> {
    @Override
    public void scaffold(LinkedList<Dummy> instance) {
        Collection<Dummy> collection = null;
        ignore(
                new LinkedList<Dummy>(),
                new LinkedList<Dummy>(collection)
        );

        Dummy value = null;
        int index = 0;

        boolean add = instance.add(value);
        instance.add(index, value);
        boolean b = instance.addAll(collection);
        boolean b1 = instance.addAll(index, collection);
        instance.addFirst(value);
        instance.addLast(value);
        instance.clear();
        Object clone = instance.clone();
        boolean contains = instance.contains(value);
        Iterator<Dummy> dummyIterator = instance.descendingIterator();
        Dummy element = instance.element();
        Dummy dummy = instance.get(index);
        Dummy first = instance.getFirst();
        Dummy last = instance.getLast();
        int i = instance.indexOf(value);
        int i1 = instance.lastIndexOf(value);
        ListIterator<Dummy> dummyListIterator = instance.listIterator(index);
        boolean offer = instance.offer(value);
        boolean b2 = instance.offerFirst(value);
        boolean b3 = instance.offerLast(value);
        Dummy peek = instance.peek();
        Dummy dummy1 = instance.peekFirst();
        Dummy dummy2 = instance.peekLast();
        Dummy poll = instance.poll();
        Dummy dummy3 = instance.pollFirst();
        Dummy dummy4 = instance.pollLast();
        Dummy pop = instance.pop();
        instance.push(value);
        Dummy remove = instance.remove();
        Dummy remove1 = instance.remove(index);
        boolean remove2 = instance.remove(value);
        Dummy dummy5 = instance.removeFirst();
        boolean b4 = instance.removeFirstOccurrence(value);
        Dummy dummy6 = instance.removeLast();
        boolean b5 = instance.removeLastOccurrence(value);
        Dummy set = instance.set(index, value);
        int size = instance.size();
        Spliterator<Dummy> spliterator = instance.spliterator();
        Object[] objects = instance.toArray();
        Dummy[] dummies = instance.toArray(new Dummy[0]);

    }
}

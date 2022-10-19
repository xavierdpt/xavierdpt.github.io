package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ArrayDequeExample extends BaseExample<ArrayDeque<Dummy>> {
    @Override
    public void scaffold(ArrayDeque<Dummy> instance) {
        int num = 0;
        Collection<? extends Dummy> collection = null;
        ignore(
                new ArrayDeque<Dummy>(),
                new ArrayDeque<Dummy>(num),
                new ArrayDeque<Dummy>(collection)
        );

        Dummy value = null;
        boolean add = instance.add(value);

        boolean b = instance.addAll(collection);

        instance.addFirst(value);

        instance.addLast(value);

        instance.clear();

        ArrayDeque<Dummy> clone = instance.clone();

        boolean contains = instance.contains(value);

        Iterator<Dummy> dummyIterator = instance.descendingIterator();

        Dummy element = instance.element();

        Consumer<? super Dummy> action = null;
        instance.forEach(action);

        Dummy first = instance.getFirst();

        Dummy last = instance.getLast();

        boolean empty = instance.isEmpty();

        Iterator<Dummy> iterator = instance.iterator();

        boolean offer = instance.offer(value);

        boolean b1 = instance.offerFirst(value);

        boolean b2 = instance.offerLast(value);

        Dummy peek = instance.peek();

        Dummy dummy = instance.peekFirst();

        Dummy dummy1 = instance.peekLast();

        Dummy poll = instance.poll();

        Dummy dummy2 = instance.pollFirst();

        Dummy dummy3 = instance.pollLast();

        Dummy pop = instance.pop();

        instance.push(value);

        Dummy remove = instance.remove();

        boolean remove1 = instance.remove(value);

        boolean b3 = instance.removeAll(collection);

        Dummy dummy4 = instance.removeFirst();

        boolean b4 = instance.removeFirstOccurrence(value);

        Predicate<? super Dummy> predicate = null;
        boolean b5 = instance.removeIf(predicate);

        Dummy dummy5 = instance.removeLast();

        boolean b6 = instance.removeLastOccurrence(value);

        boolean b7 = instance.retainAll(collection);

        int size = instance.size();

        Spliterator<Dummy> spliterator = instance.spliterator();

        Object[] objects = instance.toArray();

        Dummy[] dummies = instance.toArray(new Dummy[0]);

    }
}

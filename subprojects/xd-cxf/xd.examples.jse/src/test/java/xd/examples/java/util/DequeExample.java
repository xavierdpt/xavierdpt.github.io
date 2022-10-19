package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.Scaffolded;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

@Scaffolded
public class DequeExample extends BaseExample<Deque<Dummy>> {
    @Override
    public void scaffold(Deque<Dummy> instance) throws Throwable {
        Dummy value = null;
        boolean add = instance.add(value);

        Collection<Dummy> collection = null;
        boolean b = instance.addAll(collection);

        instance.addFirst(value);

        instance.addLast(value);

        boolean contains = instance.contains(value);

        Iterator<Dummy> dummyIterator = instance.descendingIterator();

        Dummy element = instance.element();

        Dummy first = instance.getFirst();

        Dummy last = instance.getLast();

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

        Dummy dummy4 = instance.removeFirst();

        boolean b3 = instance.removeFirstOccurrence(value);

        Dummy dummy5 = instance.removeLast();

        boolean b4 = instance.removeLastOccurrence(value);

        int size = instance.size();
    }
}

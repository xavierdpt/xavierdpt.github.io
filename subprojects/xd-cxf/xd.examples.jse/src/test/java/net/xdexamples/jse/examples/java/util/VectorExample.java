package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.Scaffolded;

import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

@Scaffolded
public class VectorExample extends BaseExample<Vector<Dummy>> {

    @Override
    public void scaffold(Vector<Dummy> instance) throws Throwable {
        int capacity = 0;
        int increment = 0;
        Collection<Dummy> collection = null;
        ignore(
                new Vector<Dummy>(),
                new Vector<Dummy>(capacity),
                new Vector<Dummy>(capacity, increment),
                new Vector<Dummy>(collection)
        );
        Dummy value = null;
        boolean add = instance.add(value);
        int index = 0;
        instance.add(index, value);
        boolean b = instance.addAll(collection);
        boolean b1 = instance.addAll(index, collection);
        instance.addElement(value);
        int capacity1 = instance.capacity();
        instance.clear();
        Object clone = instance.clone();
        boolean contains = instance.contains(value);
        boolean b2 = instance.containsAll(collection);
        Object[] array = new Object[0];
        instance.copyInto(array);
        Dummy dummy = instance.elementAt(index);
        Enumeration<Dummy> elements = instance.elements();
        instance.ensureCapacity(capacity);
        Vector<Dummy> other = null;
        boolean equals = instance.equals(other);
        Dummy dummy1 = instance.firstElement();
        Consumer<Dummy> consumer = null;
        instance.forEach(consumer);
        Dummy dummy2 = instance.get(index);
        int i = instance.hashCode();
        Dummy object = null;
        int i1 = instance.indexOf(object);
        Object object2 = null;
        int i2 = instance.indexOf(object2, index);
        instance.insertElementAt(value, index);
        boolean empty = instance.isEmpty();
        Iterator<Dummy> iterator = instance.iterator();
        Dummy dummy3 = instance.lastElement();
        Dummy xxx = null;
        int i3 = instance.lastIndexOf(xxx);
        Object yyy = null;
        int i4 = instance.lastIndexOf(yyy, index);
        ListIterator<Dummy> dummyListIterator = instance.listIterator();
        ListIterator<Dummy> dummyListIterator1 = instance.listIterator(index);

        Dummy remove = instance.remove(index);
        Dummy zzz = null;
        boolean remove1 = instance.remove(zzz);
        boolean b3 = instance.removeAll(collection);
        instance.removeAllElements();
        instance.removeElementAt(index);
        Object uuu = null;
        boolean b4 = instance.removeElement(uuu);
        Predicate<Dummy> predicate = null;
        boolean b5 = instance.removeIf(predicate);
        UnaryOperator<Dummy> operator = null;
        instance.replaceAll(operator);
        boolean b6 = instance.retainAll(collection);
        Dummy ttt = null;
        Dummy set = instance.set(index, ttt);
        instance.setElementAt(value, index);
        int size = 0;
        instance.setSize(size);
        Comparator<Dummy> cmp = null;
        instance.sort(cmp);
        Spliterator<Dummy> spliterator = instance.spliterator();
        int from = 0;
        int to = 0;
        List<Dummy> dummies = instance.subList(from, to);
        Object[] objects = instance.toArray();
        Dummy[] dummies1 = instance.toArray(new Dummy[0]);
        String s = instance.toString();
        instance.trimToSize();
    }

}

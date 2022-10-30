package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class AbstractListExample extends BaseExample<AbstractList<Dummy>> {

    @Override
    public void scaffold(AbstractList<Dummy> instance) throws Throwable {

        Dummy value = null;
        boolean add = instance.add(value);

        int index = 0;
        Dummy dummy = instance.get(index);

        Dummy set = instance.set(index, value);

        instance.add(index, value);

        Dummy remove = instance.remove(index);


        int i = instance.indexOf(value);

        int i1 = instance.lastIndexOf(value);

        instance.clear();

        Collection<? extends Dummy> collection = null;
        boolean b = instance.addAll(index, collection);


        Iterator<Dummy> iterator = instance.iterator();

        ListIterator<Dummy> dummyListIterator = instance.listIterator();

        ListIterator<Dummy> dummyListIterator1 = instance.listIterator(index);

        int fromIndex = 0;
        int toIndex = 0;
        instance.subList(fromIndex, toIndex);

        AbstractList<Dummy> other = null;
        boolean equals = instance.equals(other);

        int i2 = instance.hashCode();
    }

}

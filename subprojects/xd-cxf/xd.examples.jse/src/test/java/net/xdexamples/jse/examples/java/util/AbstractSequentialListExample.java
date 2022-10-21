package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class AbstractSequentialListExample extends BaseExample<AbstractSequentialList<Dummy>> {
    @Override
    public void scaffold(AbstractSequentialList<Dummy> instance) throws Throwable {
        int index = 0;
        Dummy dummy = instance.get(index);

        Dummy value = null;
        Dummy set = instance.set(index, value);

        instance.add(index, value);

        instance.remove(index);

        Collection<? extends Dummy> collection = null;
        boolean b = instance.addAll(index, collection);

        Iterator<Dummy> iterator = instance.iterator();

        ListIterator<Dummy> dummyListIterator = instance.listIterator(index);
    }
}

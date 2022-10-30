package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.support.internal.Scaffolded;

import java.util.ListIterator;

@Scaffolded
public class ListIteratorExample extends BaseExample<ListIterator<Dummy>> {

    @Override
    public void scaffold(ListIterator<Dummy> instance) throws Throwable {
        Dummy value = null;
        boolean b = instance.hasNext();
        Dummy next = instance.next();
        boolean b1 = instance.hasPrevious();
        Dummy previous = instance.previous();
        int i = instance.nextIndex();
        int i1 = instance.previousIndex();
        instance.remove();
        instance.set(value);
        instance.add(value);
    }

}

package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.Scaffolded;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.Spliterator;

@Scaffolded
public class SortedSetExample extends BaseExample<SortedSet<Dummy>> {

    @Override
    public void scaffold(SortedSet<Dummy> instance) throws Throwable {

        Dummy element = null;
        Dummy fromElement = null;
        Dummy toElement = null;

        Comparator<? super Dummy> comparator = instance.comparator();
        Dummy first = instance.first();
        SortedSet<Dummy> dummies = instance.headSet(element);
        Dummy last = instance.last();
        Spliterator<Dummy> spliterator = instance.spliterator();
        SortedSet<Dummy> dummies1 = instance.subSet(fromElement, toElement);
        SortedSet<Dummy> dummies2 = instance.tailSet(fromElement);
    }

}

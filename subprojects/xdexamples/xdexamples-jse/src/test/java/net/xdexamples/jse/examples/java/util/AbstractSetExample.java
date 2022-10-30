package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import xd.helpers.dummies.Dummy;

import java.util.AbstractSet;
import java.util.Collection;

@Scaffolded
public class AbstractSetExample extends BaseExample<AbstractSet<Dummy>> {
    @Override
    public void scaffold(AbstractSet<Dummy> instance) {
        AbstractSet<Dummy> other = null;
        boolean equals = instance.equals(other);

        int i = instance.hashCode();

        Collection<?> collection = null;
        boolean b = instance.removeAll(collection);
    }
}

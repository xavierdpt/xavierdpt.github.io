package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xdtest.Scaffolded;

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

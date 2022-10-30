package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.support.internal.Scaffolded;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Scaffolded
public class AbstractMapExample extends BaseExample<AbstractMap<DummyKey, Dummy>> {

    @Override
    public void scaffold(AbstractMap<DummyKey, Dummy> instance) throws Throwable {
        int size = instance.size();
        boolean empty = instance.isEmpty();
        Dummy value = null;
        boolean b = instance.containsValue(value);
        DummyKey key = null;
        boolean b1 = instance.containsKey(key);
        Dummy dummy = instance.get(key);
        Dummy put = instance.put(key, value);
        instance.remove(key);
        Map<? extends DummyKey, ? extends Dummy> otherMap = null;
        instance.putAll(otherMap);
        instance.clear();
        Set<DummyKey> dummyKeys = instance.keySet();
        Collection<Dummy> values = instance.values();
        Set<Map.Entry<DummyKey, Dummy>> entries = instance.entrySet();
        AbstractMap<DummyKey, Dummy> other = null;
        boolean equals = instance.equals(other);
        int i = instance.hashCode();
        String s = instance.toString();
    }
}

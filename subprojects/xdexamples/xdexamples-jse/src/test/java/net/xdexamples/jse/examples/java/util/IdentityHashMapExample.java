package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@Scaffolded
public class IdentityHashMapExample extends BaseExample<IdentityHashMap<DummyKey, Dummy>> {

    @Override
    public void scaffold(IdentityHashMap<DummyKey, Dummy> instance) throws Throwable {
        int expectedMaxSize = 0;
        Map<DummyKey, Dummy> otherMap = null;
        ignore(
                new IdentityHashMap<DummyKey, Dummy>(),
                new IdentityHashMap<DummyKey, Dummy>(expectedMaxSize),
                new IdentityHashMap<>(otherMap)
        );

        DummyKey key = null;
        Dummy value = null;
        IdentityHashMap<DummyKey, Dummy> other = null;
        BiConsumer<DummyKey, Dummy> biConsumer = null;
        BiFunction<DummyKey, Dummy, Dummy> biFunction = null;

        int size = instance.size();
        boolean empty = instance.isEmpty();
        Dummy dummy = instance.get(key);
        boolean b = instance.containsKey(key);
        boolean b1 = instance.containsValue(value);
        Dummy put = instance.put(key, value);
        instance.putAll(otherMap);
        Dummy remove = instance.remove(key);
        boolean remove1 = instance.remove(key, value);
        instance.clear();
        boolean equals = instance.equals(other);
        int i = instance.hashCode();
        Object clone = instance.clone();
        Set<DummyKey> dummyKeys = instance.keySet();
        Collection<Dummy> values = instance.values();
        Set<Map.Entry<DummyKey, Dummy>> entries = instance.entrySet();
        instance.forEach(biConsumer);
        instance.replaceAll(biFunction);
    }

}

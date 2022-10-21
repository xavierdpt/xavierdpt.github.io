package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.Scaffolded;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Scaffolded
public class HashtableExample extends BaseExample<Hashtable<DummyKey, Dummy>> {

    @Override
    public void scaffold(Hashtable<DummyKey, Dummy> instance) throws Throwable {
        int capacity = 0;
        float loadFactor = 0;
        Map<DummyKey, Dummy> otherMap = null;
        ignore(
                new Hashtable<DummyKey, Dummy>(),
                new Hashtable<DummyKey, Dummy>(capacity),
                new Hashtable<DummyKey, Dummy>(capacity, loadFactor),
                new Hashtable<>(otherMap)
        );

        DummyKey key = null;
        Dummy value = null;
        Hashtable<DummyKey, Dummy> other = null;

        BiConsumer<DummyKey, Dummy> biConsumer = null;
        BiFunction<Dummy, Dummy, Dummy> dummyDummyToDummy = null;
        BiFunction<DummyKey, Dummy, Dummy> dummyKeyDummyToDummy = null;
        Function<DummyKey, Dummy> keyToDummy = null;

        instance.clear();
        Object clone = instance.clone();
        Dummy compute = instance.compute(key, dummyKeyDummyToDummy);
        Dummy dummy = instance.computeIfAbsent(key, keyToDummy);
        Dummy dummy1 = instance.computeIfPresent(key, dummyKeyDummyToDummy);
        boolean contains = instance.contains(value);
        boolean b = instance.containsKey(key);
        boolean b1 = instance.containsValue(value);
        Enumeration<Dummy> elements = instance.elements();
        Set<Map.Entry<DummyKey, Dummy>> entries = instance.entrySet();
        boolean equals = instance.equals(other);
        instance.forEach(biConsumer);
        instance.get(key);
        instance.getOrDefault(key, value);
        int i = instance.hashCode();
        boolean empty = instance.isEmpty();
        Set<DummyKey> dummyKeys = instance.keySet();
        Enumeration<DummyKey> keys = instance.keys();
        Dummy merge = instance.merge(key, value, dummyDummyToDummy);
        Dummy put = instance.put(key, value);
        instance.putAll(otherMap);
        Dummy dummy2 = instance.putIfAbsent(key, value);
        Dummy remove = instance.remove(key);
        boolean remove1 = instance.remove(key, value);
        Dummy replace = instance.replace(key, value);
        boolean replace1 = instance.replace(key, value, value);
        instance.replaceAll(dummyKeyDummyToDummy);
        int size = instance.size();
        String s = instance.toString();
        Collection<Dummy> values = instance.values();
    }

}

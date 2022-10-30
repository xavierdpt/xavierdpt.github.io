package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

@Scaffolded
public class SortedMapExample extends BaseExample<SortedMap<DummyKey, Dummy>> {

    @Override
    public void scaffold(SortedMap<DummyKey, Dummy> instance) {

        DummyKey key = null;
        DummyKey fromKey = null;
        DummyKey toKey = null;

        Comparator<? super DummyKey> comparator = instance.comparator();
        Set<Map.Entry<DummyKey, Dummy>> entries = instance.entrySet();
        DummyKey dummyKey = instance.firstKey();
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap = instance.headMap(key);
        Set<DummyKey> dummyKeys = instance.keySet();
        DummyKey dummyKey1 = instance.lastKey();
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap1 = instance.subMap(fromKey, toKey);
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap2 = instance.tailMap(fromKey);
        Collection<Dummy> values = instance.values();
    }

}

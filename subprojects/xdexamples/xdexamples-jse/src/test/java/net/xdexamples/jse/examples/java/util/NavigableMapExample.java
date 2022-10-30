package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;

@Scaffolded
public class NavigableMapExample extends BaseExample<NavigableMap<DummyKey, Dummy>> {

    @Override
    public void scaffold(NavigableMap<DummyKey, Dummy> instance) {
        DummyKey key = null;
        DummyKey fromKey = null;
        DummyKey toKey = null;
        boolean inclusive = false;

        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry = instance.ceilingEntry(key);
        DummyKey dummyKey = instance.ceilingKey(key);
        NavigableSet<DummyKey> dummyKeys = instance.descendingKeySet();
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap = instance.descendingMap();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry1 = instance.firstEntry();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry2 = instance.floorEntry(key);
        DummyKey dummyKey1 = instance.floorKey(key);
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap = instance.headMap(toKey);
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap1 = instance.headMap(toKey, inclusive);
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry3 = instance.higherEntry(key);
        DummyKey dummyKey2 = instance.higherKey(key);
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry4 = instance.lastEntry();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry5 = instance.lowerEntry(key);
        DummyKey dummyKey3 = instance.lowerKey(key);
        NavigableSet<DummyKey> dummyKeys1 = instance.navigableKeySet();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry6 = instance.pollFirstEntry();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry7 = instance.pollLastEntry();
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap1 = instance.subMap(fromKey, toKey);
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap2 = instance.subMap(fromKey, inclusive, toKey, inclusive);
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap2 = instance.tailMap(fromKey);
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap3 = instance.tailMap(fromKey, inclusive);

    }
}

package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.Scaffolded;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Scaffolded
public class TreeMapExample extends BaseExample<TreeMap<DummyKey, Dummy>> {

    @Override
    public void scaffold(TreeMap<DummyKey, Dummy> instance) {
        Comparator<DummyKey> comparator = null;
        Map<DummyKey, Dummy> otherMap = null;
        SortedMap<DummyKey, Dummy> sortedMap = null;
        ignore(
                new TreeMap<DummyKey, Dummy>(),
                new TreeMap<DummyKey, Dummy>(comparator),
                new TreeMap<>(otherMap),
                new TreeMap<>(sortedMap)
        );

        DummyKey key = null;
        DummyKey fromKey = null;
        DummyKey toKey = null;
        Dummy value = null;
        boolean inclusive = false;
        BiFunction<DummyKey, Dummy, Dummy> aaa = null;
        Function<DummyKey, Dummy> bbb = null;
        BiFunction<DummyKey, Dummy, Dummy> ccc = null;
        BiConsumer<DummyKey, Dummy> ddd = null;
        BiFunction<Dummy, Dummy, Dummy> eee = null;
        BiFunction<DummyKey, Dummy, Dummy> fff = null;

        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry = instance.ceilingEntry(key);
        DummyKey dummyKey = instance.ceilingKey(key);
        instance.clear();
        Object clone = instance.clone();
        Comparator<? super DummyKey> comparator1 = instance.comparator();
        Dummy compute = instance.compute(key, aaa);
        Dummy dummy = instance.computeIfAbsent(key, bbb);
        Dummy dummy1 = instance.computeIfPresent(key, ccc);
        boolean b = instance.containsKey(key);
        boolean b1 = instance.containsValue(value);
        NavigableSet<DummyKey> dummyKeys = instance.descendingKeySet();
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap = instance.descendingMap();
        Set<Map.Entry<DummyKey, Dummy>> entries = instance.entrySet();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry1 = instance.firstEntry();
        DummyKey dummyKey1 = instance.firstKey();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry2 = instance.floorEntry(key);
        DummyKey dummyKey2 = instance.floorKey(key);
        instance.forEach(ddd);
        Dummy dummy2 = instance.get(key);
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap = instance.headMap(key);
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap1 = instance.headMap(key, inclusive);
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry3 = instance.higherEntry(key);
        DummyKey dummyKey3 = instance.higherKey(key);
        Set<DummyKey> dummyKeys1 = instance.keySet();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry4 = instance.lastEntry();
        DummyKey dummyKey4 = instance.lastKey();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry5 = instance.lowerEntry(key);
        DummyKey dummyKey5 = instance.lowerKey(key);
        Dummy merge = instance.merge(key, value, eee);
        NavigableSet<DummyKey> dummyKeys2 = instance.navigableKeySet();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry6 = instance.pollFirstEntry();
        Map.Entry<DummyKey, Dummy> dummyKeyDummyEntry7 = instance.pollLastEntry();
        Dummy put = instance.put(key, value);
        instance.putAll(otherMap);
        Dummy dummy3 = instance.putIfAbsent(key, value);
        Dummy remove = instance.remove(key);
        Dummy replace = instance.replace(key, value);
        boolean replace1 = instance.replace(key, value, value);
        instance.replaceAll(fff);
        int size = instance.size();
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap1 = instance.subMap(fromKey, toKey);
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap2 = instance.subMap(fromKey, inclusive, toKey, inclusive);
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap2 = instance.tailMap(fromKey);
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap3 = instance.tailMap(fromKey, inclusive);
        Collection<Dummy> values = instance.values();
    }

}

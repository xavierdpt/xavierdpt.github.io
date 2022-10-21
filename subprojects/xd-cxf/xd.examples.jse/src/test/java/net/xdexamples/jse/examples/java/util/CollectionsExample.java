package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyComparable;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.Scaffolded;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@Scaffolded
public class CollectionsExample extends BaseExample<Collections> {
    @Override
    public void scaffold(Collections instance) {

        List emptyList = Collections.EMPTY_LIST;
        Map emptyMap = Collections.EMPTY_MAP;
        Set emptySet = Collections.EMPTY_SET;

        Collection<Dummy> other = null;
        Dummy value = null;
        Collections.addAll(other, value, value, value);

        Deque<Dummy> deque = null;
        Queue<Dummy> dummies = Collections.asLifoQueue(deque);

        List<DummyComparable> list = null;
        DummyComparable key = null;
        int i = Collections.binarySearch(list, key);

        List<Dummy> list1 = null;
        Dummy key1 = null;
        Comparator<Dummy> comparator = null;
        int i1 = Collections.binarySearch(list1, key1, comparator);

        Class<Dummy> type = null;
        Collection<Dummy> dummies1 = Collections.checkedCollection(other, type);

        List<Dummy> dummyList = null;
        List<Dummy> dummies2 = Collections.checkedList(dummyList, type);

        Map<DummyKey, Dummy> map = null;
        Class<DummyKey> keyType = null;
        Class<Dummy> valueType = null;
        Map<DummyKey, Dummy> dummyKeyDummyMap = Collections.checkedMap(map, keyType, valueType);

        NavigableMap<DummyKey, Dummy> nmap = null;
        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap = Collections.checkedNavigableMap(nmap, keyType, valueType);

        NavigableSet<Dummy> nset = null;
        NavigableSet<Dummy> dummies3 = Collections.checkedNavigableSet(nset, type);

        Queue<Dummy> queue = null;
        Queue<Dummy> dummies4 = Collections.checkedQueue(queue, type);

        Set<Dummy> set = null;
        Set<Dummy> dummies5 = Collections.checkedSet(set, type);

        SortedMap<DummyKey, Dummy> smap = null;
        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap = Collections.checkedSortedMap(smap, keyType, valueType);

        SortedSet<Dummy> sset = null;
        SortedSet<Dummy> dummies6 = Collections.checkedSortedSet(sset, type);

        List<Dummy> source = null;
        List<Dummy> destination = null;
        Collections.copy(destination, source);

        Collection<Dummy> collection = null;
        boolean disjoint = Collections.disjoint(collection, collection);

        Enumeration<Dummy> dummyEnumeration = Collections.emptyEnumeration();

        Iterator<Dummy> dummyIterator = Collections.emptyIterator();

        List<Dummy> dummies7 = Collections.emptyList();

        ListIterator<Dummy> dummyListIterator = Collections.emptyListIterator();

        Map<DummyKey, Dummy> dummyKeyDummyMap1 = Collections.emptyMap();

        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap1 = Collections.emptyNavigableMap();

        NavigableSet<Dummy> dummies8 = Collections.emptyNavigableSet();

        Set<Dummy> dummies9 = Collections.emptySet();

        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap1 = Collections.emptySortedMap();

        SortedSet<Dummy> dummies10 = Collections.emptySortedSet();

        Enumeration<Dummy> enumeration = Collections.enumeration(collection);

        Dummy value1 = null;
        Collections.fill(list1, value1);

        int frequency = Collections.frequency(collection, value1);

        List<Dummy> target = null;
        int i2 = Collections.indexOfSubList(source, target);

        int i3 = Collections.lastIndexOfSubList(source, target);

        ArrayList<Dummy> list2 = Collections.list(enumeration);

        Collection<DummyComparable> c1 = null;
        DummyComparable max = Collections.max(c1);

        Collection<Dummy> c2 = null;
        Dummy max1 = Collections.max(c2, comparator);

        DummyComparable min = Collections.min(c1);

        Dummy min1 = Collections.min(c2, comparator);

        int n = 0;
        List<Dummy> dummies11 = Collections.nCopies(n, value);

        Map<DummyKey, Boolean> mapp = null;
        Set<DummyKey> dummyKeys = Collections.newSetFromMap(mapp);

        Dummy newValue = null;
        boolean b = Collections.replaceAll(list1, value, newValue);

        Collections.reverse(list1);

        Comparator<DummyComparable> dummyComparator = Collections.reverseOrder();

        Comparator<Dummy> dummyComparator1 = Collections.reverseOrder(comparator);

        int distance = 0;
        Collections.rotate(list1, distance);

        Collections.shuffle(list1);

        Random random = null;
        Collections.shuffle(list1, random);

        Set<Dummy> singleton = Collections.singleton(value);

        List<Dummy> dummies12 = Collections.singletonList(value);

        DummyKey dummyKey = null;
        Dummy dummyValue = null;
        Map<DummyKey, Dummy> dummyKeyDummyMap2 = Collections.singletonMap(dummyKey, dummyValue);

        Collections.sort(list);

        Collections.sort(list1, comparator);

        int j = 0;
        Collections.swap(list1, i, j);

        Collection<Dummy> dummies13 = Collections.synchronizedCollection(collection);

        List<Dummy> dummies14 = Collections.synchronizedList(list1);

        Map<DummyKey, Dummy> dummyKeyDummyMap3 = Collections.synchronizedMap(map);

        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap2 = Collections.synchronizedNavigableMap(nmap);

        NavigableSet<Dummy> dummies15 = Collections.synchronizedNavigableSet(nset);

        Set<Dummy> dummies16 = Collections.synchronizedSet(set);

        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap2 = Collections.synchronizedSortedMap(smap);

        SortedSet<Dummy> dummies17 = Collections.synchronizedSortedSet(sset);

        Collection<Dummy> dummies18 = Collections.unmodifiableCollection(collection);

        List<Dummy> dummies19 = Collections.unmodifiableList(list1);

        Map<DummyKey, Dummy> dummyKeyDummyMap4 = Collections.unmodifiableMap(map);

        NavigableMap<DummyKey, Dummy> dummyKeyDummyNavigableMap3 = Collections.unmodifiableNavigableMap(nmap);

        NavigableSet<Dummy> dummies20 = Collections.unmodifiableNavigableSet(nset);

        Set<Dummy> dummies21 = Collections.unmodifiableSet(set);

        SortedMap<DummyKey, Dummy> dummyKeyDummySortedMap3 = Collections.unmodifiableSortedMap(smap);

        SortedSet<Dummy> dummies22 = Collections.unmodifiableSortedSet(sset);

    }
}

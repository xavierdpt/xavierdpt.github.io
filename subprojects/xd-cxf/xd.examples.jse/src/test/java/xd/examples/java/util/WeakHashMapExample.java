package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import xdtest.Scaffolded;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

@Scaffolded
public class WeakHashMapExample extends BaseExample<WeakHashMap<DummyKey, Dummy>> {

    @Override
    public void scaffold(WeakHashMap<DummyKey, Dummy> instance) throws Throwable {
        int capacity = 0;
        float loadFactor = 0;
        Map<DummyKey, Dummy> otherMap = null;
        ignore(
                new WeakHashMap<DummyKey, Dummy>(),
                new WeakHashMap<DummyKey, Dummy>(capacity),
                new WeakHashMap<DummyKey, Dummy>(capacity, loadFactor),
                new WeakHashMap<DummyKey, Dummy>(otherMap)
        );

        instance.clear();
        DummyKey key = null;
        boolean b = instance.containsKey(key);
        Dummy value = null;
        boolean b1 = instance.containsValue(value);
        Set<Map.Entry<DummyKey, Dummy>> entries = instance.entrySet();
        BiConsumer<DummyKey, Dummy> consumer = null;
        instance.forEach(consumer);
        Dummy dummy = instance.get(key);
        boolean empty = instance.isEmpty();
        Set<DummyKey> dummyKeys = instance.keySet();
        Dummy put = instance.put(key, value);
        instance.putAll(otherMap);
        Dummy remove = instance.remove(key);
        BiFunction<DummyKey, Dummy, Dummy> bifunction = null;
        instance.replaceAll(bifunction);
        int size = instance.size();
        Collection<Dummy> values = instance.values();
    }

}

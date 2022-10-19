package xd.examples.java.util;

import xd.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import xdtest.Scaffolded;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Scaffolded
public class HashMapExample extends BaseExample<HashMap<DummyKey, Dummy>> {

    @Override
    public void scaffold(HashMap<DummyKey, Dummy> instance) throws Throwable {
        int capacity = 0;
        float loadFactor = 0;
        Map<DummyKey, Dummy> otherMap = null;
        ignore(
                new HashMap<DummyKey, Dummy>(),
                new HashMap<DummyKey, Dummy>(capacity),
                new HashMap<DummyKey, Dummy>(capacity, loadFactor),
                new HashMap<>(otherMap)
        );

        instance.clear();

        Object clone = instance.clone();

        DummyKey key = null;
        BiFunction<DummyKey, Dummy, Dummy> biFunction = null;
        Dummy compute = instance.compute(key, biFunction);

        Function<DummyKey, Dummy> function = null;
        Dummy dummy = instance.computeIfAbsent(key, function);

        Dummy dummy1 = instance.computeIfPresent(key, biFunction);

        boolean b = instance.containsKey(key);

        Dummy value = null;
        boolean b1 = instance.containsValue(value);

        Set<Map.Entry<DummyKey, Dummy>> entries = instance.entrySet();

        BiConsumer<DummyKey, Dummy> biConsumer = null;
        instance.forEach(biConsumer);

        Dummy dummy2 = instance.get(key);

        Dummy orDefault = instance.getOrDefault(key, value);

        boolean empty = instance.isEmpty();

        Set<DummyKey> dummyKeys = instance.keySet();

        BiFunction<Dummy, Dummy, Dummy> mergeFunction = null;
        Dummy merge = instance.merge(key, value, mergeFunction);

        Dummy put = instance.put(key, value);

        instance.putAll(otherMap);

        Dummy dummy3 = instance.putIfAbsent(key, value);

        Dummy remove = instance.remove(key);

        boolean remove1 = instance.remove(key, value);

        Dummy replace = instance.replace(key, value);

        boolean replace1 = instance.replace(key, value, value);

        BiFunction<DummyKey, Dummy, Dummy> replaceFunction = null;
        instance.replaceAll(replaceFunction);

        int size = instance.size();

        Collection<Dummy> values = instance.values();
    }

}

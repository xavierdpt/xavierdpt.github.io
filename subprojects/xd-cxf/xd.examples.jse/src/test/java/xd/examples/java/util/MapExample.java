package xd.examples.java.util;

import org.junit.Assert;
import org.junit.Test;
import xd.BaseExample;
import xd.helpers.dummies.DummyKey;
import xd.helpers.dummies.DummyValue;
import xdtest.Done;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@Done
public class MapExample extends BaseExample<Map<DummyKey, DummyValue>> {

    @Override
    @SuppressWarnings({"unused", "SuspiciousMethodCalls"})
    protected void scaffold(Map<DummyKey, DummyValue> instance) {
        {
            Map<DummyKey, DummyValue> other = any();
            Map<DummyKey, DummyValue> copy = Map.copyOf(other);
            seeExamples(this::copyOfExample);
        }

        {
            DummyKey k1 = any();
            DummyValue v1 = any();
            DummyKey k2 = any();
            DummyValue v2 = any();
            DummyKey k3 = any();
            DummyValue v3 = any();
            DummyKey k4 = any();
            DummyValue v4 = any();
            DummyKey k5 = any();
            DummyValue v5 = any();
            DummyKey k6 = any();
            DummyValue v6 = any();
            DummyKey k7 = any();
            DummyValue v7 = any();
            DummyKey k8 = any();
            DummyValue v8 = any();
            DummyKey k9 = any();
            DummyValue v9 = any();
            DummyKey k10 = any();
            DummyValue v10 = any();
            Map<DummyKey, DummyValue> m1 = Map.of(k1, v1);
            Map<DummyKey, DummyValue> m2 = Map.of(k1, v1, k2, v2);
            Map<DummyKey, DummyValue> m3 = Map.of(k1, v1, k2, v2, k3, v3);
            Map<DummyKey, DummyValue> m4 = Map.of(k1, v1, k2, v2, k3, v3, k4, v4);
            Map<DummyKey, DummyValue> m5 = Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5);
            Map<DummyKey, DummyValue> m6 = Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6);
            Map<DummyKey, DummyValue> m7 = Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7);
            Map<DummyKey, DummyValue> m8 = Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8);
            Map<DummyKey, DummyValue> m9 = Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8,
                    k9, v9);
            Map<DummyKey, DummyValue> m10 = Map.of(k1, v1, k2, v2, k3, v3, k4, v4, k5, v5, k6, v6, k7, v7, k8, v8,
                    k9, v9, k10, v10);
            seeExamples(this::ofExample);
        }
        {
            DummyKey key = any();
            DummyValue value = any();
            Map.Entry<DummyKey, DummyValue> entry = Map.entry(key, value);
            seeExamples(this::ofEntriesExample);
        }
        {
            Map.Entry<DummyKey, DummyValue>[] entries = any();
            Map<DummyKey, DummyValue> map = Map.ofEntries(entries);
            seeExamples(this::ofEntriesExample);
        }
        {
            instance.clear();
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            BiFunction<DummyKey, DummyValue, DummyValue> function = any();
            DummyValue value = instance.compute(key, function);
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            Function<DummyKey, DummyValue> function = any();
            DummyValue value = instance.computeIfAbsent(key, function);
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            BiFunction<DummyKey, DummyValue, DummyValue> function = any();
            instance.computeIfPresent(key, function);
            seeOthers(HashMapExample.class);
        }
        {
            Object key = any();
            boolean result = instance.containsKey(key);
            seeOthers(HashMapExample.class);
        }
        {
            Object value = any();
            boolean result = instance.containsValue(value);
            seeOthers(HashMapExample.class);
        }
        {
            Set<Map.Entry<DummyKey, DummyValue>> entries = instance.entrySet();
            seeOthers(HashMapExample.class);
        }
        {
            Object other = any();
            boolean result = instance.equals(other);
            seeOthers(HashMapExample.class);
        }
        {
            BiConsumer<DummyKey, DummyValue> consumer = any();
            instance.forEach(consumer);
            seeOthers(HashMapExample.class);
        }
        {
            Object key = any();
            Object value = instance.get(key);
            seeOthers(HashMapExample.class);
        }
        {
            Object key = any();
            DummyValue defaultValue = any();
            DummyValue value = instance.getOrDefault(key, defaultValue);
            seeOthers(HashMapExample.class);
        }
        {
            int result = instance.hashCode();
            seeOthers(HashMapExample.class);
        }
        {
            boolean result = instance.isEmpty();
            seeOthers(HashMapExample.class);
        }
        {
            Set<DummyKey> keySet = instance.keySet();
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            DummyValue value = any();
            BiFunction<DummyValue, DummyValue, DummyValue> function = any();
            DummyValue result = instance.merge(key, value, function);
            seeOthers(HashMapExample.class);
        }

        {
            DummyKey key = any();
            DummyValue value = any();
            DummyValue previousValue = instance.put(key, value);
            seeOthers(HashMapExample.class);
        }
        {
            Map<DummyKey, DummyValue> other = any();
            instance.putAll(other);
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            DummyValue value = any();
            DummyValue previousValue = instance.putIfAbsent(key, value);
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            DummyValue value = instance.remove(key);
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            DummyValue value = any();
            boolean removed = instance.remove(key, value);
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            DummyValue value = any();
            DummyValue previousValue = instance.replace(key, value);
            seeOthers(HashMapExample.class);
        }
        {
            DummyKey key = any();
            DummyValue existingValue = any();
            DummyValue newValue = any();
            boolean replaced = instance.replace(key, existingValue, newValue);
            seeOthers(HashMapExample.class);
        }
        {
            BiFunction<DummyKey, DummyValue, DummyValue> function = any();
            instance.replaceAll(function);
            seeOthers(HashMapExample.class);
        }
        {
            int size = instance.size();
            seeOthers(HashMapExample.class);
        }
        {
            Collection<DummyValue> values = instance.values();
            seeOthers(HashMapExample.class);
        }
    }

    @Test
    @SuppressWarnings({"unchecked", "InfiniteLoopStatement", "JavaReflectionMemberAccess", "OverwrittenKey"})
    public void ofExample() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        {
            // This factory method returns an immutable collection
            Map<String, Integer> map = Map.of("hello", 5);
            assertEquals(1, map.size());
            assertEquals(5, map.get("hello").intValue());
            assertThrows(UnsupportedOperationException.class,
                    () -> map.put("world", 5));
        }
        {
            // Duplicate keys are not supported
            assertThrows(IllegalArgumentException.class, () -> {
                Map<String, Integer> map = Map.of("hello", 5, "hello", 6);
                ignore(map);
            });
        }
        {
            // Map.of supports at most 10 arguments
            List<Object> arguments = new ArrayList<>();
            List<Class<Object>> signature = new ArrayList<>();
            int[] i = new int[]{1};
            Map<String, Integer>[] map = new Map[]{null};
            assertThrows(NoSuchMethodException.class, () -> {
                while (true) {
                    arguments.add(String.valueOf(i[0]));
                    arguments.add(i[0]);
                    signature.add(Object.class);
                    signature.add(Object.class);
                    Method of = Map.class.getMethod("of", signature.toArray(Class[]::new));
                    map[0] = (Map<String, Integer>) of.invoke(null, arguments.toArray(Object[]::new));
                    assertEquals(i[0], map[0].size());
                    ++i[0];
                }
            });
            assertEquals(10, map[0].size());
            assertEquals(1, map[0].get("1").intValue());
            assertEquals(2, map[0].get("2").intValue());
            assertEquals(3, map[0].get("3").intValue());
            assertEquals(4, map[0].get("4").intValue());
            assertEquals(5, map[0].get("5").intValue());
            assertEquals(6, map[0].get("6").intValue());
            assertEquals(7, map[0].get("7").intValue());
            assertEquals(8, map[0].get("8").intValue());
            assertEquals(9, map[0].get("9").intValue());
            assertEquals(10, map[0].get("10").intValue());

        }
    }

    @SuppressWarnings("OverwrittenKey")
    @Test
    public void ofEntriesExample() {
        {
            // ofEntries supports any number of entries and returns an immutable collection
            Map<String, Integer> map = Map.ofEntries(
                    Map.entry("hello", 5),
                    Map.entry("world", 5)
            );
            assertEquals(2, map.size());
            assertEquals(5, map.get("hello").intValue());
            assertEquals(5, map.get("world").intValue());
            assertThrows(UnsupportedOperationException.class,
                    () -> map.put("wonderful", 5));
        }
        {
            // Duplicate keys not supported
            assertThrows(IllegalArgumentException.class, () -> {
                Map<String, Integer> map = Map.ofEntries(
                        Map.entry("hello", 5),
                        Map.entry("hello", 6)
                );
                ignore(map);
            });

        }
    }

    @Test
    public void copyOfExample() {
        {
            // Map.copyOf returns a map that is equal (same keys, same values), but is an immutable map
            // Adding values to the original map does not add them to the copy
            HashMap<String, Integer> map = new HashMap<>(Map.of("hello", 5));
            Map<String, Integer> copy = Map.copyOf(map);
            Assert.assertEquals(map, copy);
            assertThrows(UnsupportedOperationException.class,
                    () -> copy.put("world", 5));
            map.put("world", 5);
            Assert.assertFalse(copy.containsKey("world"));
        }
        {
            // But watch out, the keys and values are literally the same!
            // Modification of the keys or values themselves will be visible in the copy, they are not cloned
            HashMap<DummyKey, DummyValue> map = new HashMap<>(Map.of(new DummyKey("hello"), new DummyValue()));
            Map<DummyKey, DummyValue> copy = Map.copyOf(map);
            Assert.assertSame(map.keySet().iterator().next(), copy.keySet().iterator().next());
            Assert.assertSame(map.values().iterator().next(), copy.values().iterator().next());

        }
    }
}

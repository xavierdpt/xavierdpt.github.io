package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyEnum;
import net.xdexamples.Scaffolded;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@Scaffolded
public class EnumMapExample extends BaseExample<EnumMap<DummyEnum, Dummy>> {

    @Override
    public void scaffold(EnumMap<DummyEnum, Dummy> instance) throws Throwable {

        Class<DummyEnum> keyType = null;
        EnumMap<DummyEnum, Dummy> other = null;
        Map<DummyEnum, Dummy> otherMap = null;
        ignore(
                new EnumMap<DummyEnum, Dummy>(keyType),
                new EnumMap<>(other),
                new EnumMap<>(otherMap)
        );
        instance.clear();
        Map<DummyEnum, Dummy> clone = instance.clone();
        DummyEnum key = null;
        boolean b = instance.containsKey(key);
        Dummy value = null;
        boolean b1 = instance.containsValue(value);
        Set<Map.Entry<DummyEnum, Dummy>> entries = instance.entrySet();
        boolean equals = instance.equals(other);
        Dummy dummy = instance.get(key);
        int i = instance.hashCode();
        Set<DummyEnum> dummyEnums = instance.keySet();
        Dummy put = instance.put(key, value);
        instance.putAll(otherMap);
        instance.remove(key);
        int size = instance.size();
        Collection<Dummy> values = instance.values();
    }

}

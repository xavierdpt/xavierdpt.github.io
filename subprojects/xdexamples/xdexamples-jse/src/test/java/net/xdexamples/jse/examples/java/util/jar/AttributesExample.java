package net.xdexamples.jse.examples.java.util.jar;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;

@Scaffolded
public class AttributesExample extends BaseExample<Attributes> {
    @Override
    public void scaffold(Attributes instance) {

        int size = 0;
        int attributes = 0;

        ignore(
                new Attributes(),
                new Attributes(size),
                new Attributes(attributes)
        );

        Object name = null;
        Object o = instance.get(name);
        Attributes.Name namen = null;
        String value = instance.getValue(namen);
        String names = null;
        String value1 = instance.getValue(names);
        Object valueo = null;
        Object put = instance.put(name, valueo);
        String s = instance.putValue(names, value);
        Object remove = instance.remove(name);
        boolean remove1 = instance.remove(name, valueo);
        boolean b = instance.containsKey(name);
        boolean b1 = instance.containsKey(name);
        Map<?, ?> map = null;
        instance.putAll(map);
        instance.clear();
        int size1 = instance.size();
        boolean empty = instance.isEmpty();
        Set<Object> objects = instance.keySet();
        Collection<Object> values = instance.values();
        Set<Map.Entry<Object, Object>> entries = instance.entrySet();
        Attributes other = null;
        instance.equals(other);
        int i = instance.hashCode();
        Object clone = instance.clone();
    }
}

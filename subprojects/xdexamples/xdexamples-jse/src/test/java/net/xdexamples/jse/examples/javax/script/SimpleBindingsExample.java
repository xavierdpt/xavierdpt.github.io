package net.xdexamples.jse.examples.javax.script;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import javax.script.SimpleBindings;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Scaffolded
public class SimpleBindingsExample extends BaseExample<SimpleBindings> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(SimpleBindings instance) {
        {
            SimpleBindings simpleBindings = new SimpleBindings();
        }
        {
            Map<String, Object> map = any();
            SimpleBindings simpleBindings = new SimpleBindings(map);
        }
        {
            instance.clear();
        }
        {
            String key = any();
            boolean b = instance.containsKey(key);
        }
        {
            Object value = any();
            boolean b = instance.containsValue(value);
        }
        {
            Set<Map.Entry<String, Object>> entries = instance.entrySet();
        }
        {
            String key = any();
            Object o = instance.get(key);
        }
        {
            boolean empty = instance.isEmpty();
        }
        {
            Set<String> strings = instance.keySet();
        }
        {
            String name = any();
            Object value = any();
            Object put = instance.put(name, value);
        }
        {
            Map<String, Object> other = any();
            instance.putAll(other);
        }
        {
            String key = any();
            instance.remove(key);
        }
        {
            int size = instance.size();
        }
        {
            Collection<Object> values = instance.values();
        }
    }
}

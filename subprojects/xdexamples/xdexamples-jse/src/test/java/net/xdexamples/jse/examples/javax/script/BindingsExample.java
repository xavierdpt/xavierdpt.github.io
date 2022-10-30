package net.xdexamples.jse.examples.javax.script;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import javax.script.Bindings;
import java.util.Map;

@Scaffolded
public class BindingsExample extends BaseExample<Bindings> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(Bindings instance) throws Throwable {
        {
            String key = any();
            boolean b = instance.containsKey(key);
        }
        {
            String key = any();
            Object o = instance.get(key);
        }
        {
            String key = any();
            Object value = any();
            Object put = instance.put(key, value);
        }
        {
            Map<String, Object> other = any();
            instance.putAll(other);
        }
        {
            String key = any();
            instance.remove(key);
        }
    }
}

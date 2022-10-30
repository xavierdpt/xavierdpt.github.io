package net.xdexamples.jse.examples.javax.script;

import org.junit.Test;
import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

import static org.junit.Assert.assertTrue;

@Scaffolded
public class ScriptEngineManagerExample extends BaseExample<ScriptEngineManager> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(ScriptEngineManager instance) {
        {
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        }
        {
            ClassLoader classLoader = any();
            ScriptEngineManager scriptEngineManager = new ScriptEngineManager(classLoader);
        }
        {
            String key = any();
            Object o = instance.get(key);
        }
        {
            Bindings bindings = instance.getBindings();
        }
        {
            String extension = any();
            ScriptEngine engineByExtension = instance.getEngineByExtension(extension);
        }
        {
            String mimeType = any();
            ScriptEngine engineByMimeType = instance.getEngineByMimeType(mimeType);
        }
        {
            String name = any();
            ScriptEngine engineByName = instance.getEngineByName(name);
        }
        {
            List<ScriptEngineFactory> engineFactories = instance.getEngineFactories();
        }
        {
            String key = any();
            Object value = any();
            instance.put(key, value);
        }
        {
            String extension = any();
            ScriptEngineFactory factory = any();
            instance.registerEngineExtension(extension, factory);
        }
        {
            String mimeType = any();
            ScriptEngineFactory factory = any();
            instance.registerEngineMimeType(mimeType, factory);
        }
        {
            String name = any();
            ScriptEngineFactory factory = any();
            instance.registerEngineName(name, factory);
        }
        {
            Bindings bindings = any();
            instance.setBindings(bindings);
        }
    }

    @Test
    public void example() {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        // Nashorn has been removed in Java 15 and no alternatives are bundled with the jdk :(.
        assertTrue(scriptEngineManager.getEngineFactories().isEmpty());
    }
}

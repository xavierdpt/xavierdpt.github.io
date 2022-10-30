package net.xdexamples.jse.examples.javax.script;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptException;
import java.io.Reader;

@Scaffolded
public class AbstractScriptEngineExample extends BaseExample<AbstractScriptEngine> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(AbstractScriptEngine instance) throws ScriptException {
        {
            Reader reader = any();
            Bindings bindings = any();
            Object eval = instance.eval(reader, bindings);
        }
        {
            String script = any();
            Bindings bindings = any();
            Object eval = instance.eval(script, bindings);
        }
        {
            Reader reader = any();
            Object eval = instance.eval(reader);
        }
        {
            String script = any();
            Object eval = instance.eval(script);
        }
        {
            String key = any();
            Object o = instance.get(key);
        }
        {
            int scope = 0;
            Bindings bindings = instance.getBindings(scope);
        }
        {
            ScriptContext context = instance.getContext();
        }
        {
            String key = any();
            Object value = any();
            instance.put(key, value);
        }
        {
            Bindings bindings = any();
            int scope = 0;
            instance.setBindings(bindings, scope);
        }
        {
            ScriptContext context = any();
            instance.setContext(context);
        }
    }
}

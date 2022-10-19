package xd.examples.javax.script;

import xd.BaseExample;
import xdtest.Scaffolded;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import java.io.Reader;

@Scaffolded
public class ScriptEngineExample extends BaseExample<ScriptEngine> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(ScriptEngine instance) throws ScriptException {
        {
            Bindings bindings = instance.createBindings();
        }
        {
            String script = any();
            ScriptContext context = any();
            Object eval = instance.eval(script, context);
        }

        {
            Reader reader = any();
            ScriptContext context = any();
            Object eval = instance.eval(reader, context);
        }
        {
            String script = any();
            Object eval = instance.eval(script);
        }
        {
            Reader reader = any();
            Object eval = instance.eval(reader);
        }

        {
            String script = any();
            ScriptContext bindings = any();
            Object eval = instance.eval(script, bindings);
        }
        {
            Reader reader = any();
            ScriptContext bindings = any();
            Object eval = instance.eval(reader, bindings);
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
            ScriptEngineFactory factory = instance.getFactory();
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
        {
            String argv = ScriptEngine.ARGV;
        }
        {
            String engine = ScriptEngine.ENGINE;
        }
        {
            String engineVersion = ScriptEngine.ENGINE_VERSION;
        }
        {
            String filename = ScriptEngine.FILENAME;
        }
        {
            String language = ScriptEngine.LANGUAGE;
        }
        {
            String languageVersion = ScriptEngine.LANGUAGE_VERSION;
        }
        {
            String name = ScriptEngine.NAME;
        }
    }
}

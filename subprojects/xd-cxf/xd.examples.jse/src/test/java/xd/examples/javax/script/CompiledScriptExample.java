package xd.examples.javax.script;

import xd.BaseExample;

import javax.script.Bindings;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class CompiledScriptExample extends BaseExample<CompiledScript> {
    @Override
    protected void scaffold(CompiledScript instance) throws ScriptException {

        {
            Object eval = instance.eval();
        }
        {
            Bindings bindings=any();
            Object eval = instance.eval(bindings);
        }
        {

            ScriptContext context=any();
            Object eval = instance.eval(context);
        }
        {
            ScriptEngine engine = instance.getEngine();
        }
    }
}

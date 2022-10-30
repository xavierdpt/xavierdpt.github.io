package net.xdexamples.jse.examples.javax.script;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptException;
import java.io.Reader;

@Scaffolded
public class CompilableExample extends BaseExample<Compilable> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(Compilable instance) throws ScriptException {
        {
            String script = any();
            CompiledScript compile = instance.compile(script);
        }
        {
            Reader reader = any();
            CompiledScript compile = instance.compile(reader);
        }
    }
}

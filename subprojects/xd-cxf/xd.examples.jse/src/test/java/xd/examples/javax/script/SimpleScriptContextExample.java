package xd.examples.javax.script;

import xd.BaseExample;
import xdtest.Scaffolded;

import javax.script.Bindings;
import javax.script.SimpleScriptContext;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

@Scaffolded
public class SimpleScriptContextExample extends BaseExample<SimpleScriptContext> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(SimpleScriptContext instance) {
        {
            SimpleScriptContext simpleScriptContext = new SimpleScriptContext();
        }
        {
            String name = any();
            Object attribute = instance.getAttribute(name);
        }
        {
            String name = any();
            int scope = 0;
            Object attribute = instance.getAttribute(name, scope);
        }
        {
            String name = any();
            int attributesScope = instance.getAttributesScope(name);
        }
        {
            int scope = 0;
            Bindings bindings = instance.getBindings(scope);
        }
        {
            Writer errorWriter = instance.getErrorWriter();
        }
        {
            Reader reader = instance.getReader();
        }
        {
            List<Integer> scopes = instance.getScopes();
        }
        {
            Writer writer = instance.getWriter();
        }
        {
            String name = any();
            int scope = 0;
            Object o = instance.removeAttribute(name, scope);
        }
        {
            String name = any();
            Object value = any();
            int scope = 0;
            instance.setAttribute(name, value, scope);
        }
        {
            Bindings bindings = any();
            int scope = 0;
            instance.setBindings(bindings, scope);
        }
        {
            Writer writer = any();
            instance.setErrorWriter(writer);
        }
        {
            Reader reader = any();
            instance.setReader(reader);
        }
        {
            Writer writer = any();
            instance.setWriter(writer);
        }
    }
}

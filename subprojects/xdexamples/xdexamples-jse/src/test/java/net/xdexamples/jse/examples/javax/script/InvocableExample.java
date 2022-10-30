package net.xdexamples.jse.examples.javax.script;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyInterface;
import net.xdexamples.Scaffolded;

import javax.script.Invocable;
import javax.script.ScriptException;

@Scaffolded
public class InvocableExample extends BaseExample<Invocable> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(Invocable instance) throws ScriptException, NoSuchMethodException {
        {
            Class<DummyInterface> clazz = any();
            DummyInterface anInterface = instance.getInterface(clazz);
        }
        {
            Dummy thiz = any();
            Class<DummyInterface> clazz = any();
            DummyInterface anInterface = instance.getInterface(thiz, clazz);
        }


        {
            String name = any();
            Object[] args = new Object[0];
            instance.invokeFunction(name, args);
        }
        {
            Dummy thiz = any();
            String name = any();
            Object[] args = new Object[0];
            Object o = instance.invokeMethod(thiz, name, args);
        }
    }
}

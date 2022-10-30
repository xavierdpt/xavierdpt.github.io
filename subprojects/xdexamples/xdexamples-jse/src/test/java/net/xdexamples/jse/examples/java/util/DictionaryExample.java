package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Dictionary;
import java.util.Enumeration;

@Scaffolded
public class DictionaryExample extends BaseExample<Dictionary<DummyKey, Dummy>> {

    @Override
    public void scaffold(Dictionary<DummyKey, Dummy> instance) throws Throwable {

        Enumeration<Dummy> elements = instance.elements();

        DummyKey key = null;
        Dummy dummy = instance.get(key);

        boolean empty = instance.isEmpty();

        Enumeration<DummyKey> keys = instance.keys();

        Dummy value = null;
        instance.put(key, value);

        Dummy remove = instance.remove(key);

        int size = instance.size();
    }
}

package net.xdexamples.jse.examples.java.util;

import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyClass;
import net.xdexamples.Scaffolded;

import java.util.PrimitiveIterator;

@Scaffolded
public class PrimitiveIteratorExample extends BaseExample<PrimitiveIterator<Dummy, DummyClass>> {
    @Override
    public void scaffold(PrimitiveIterator<Dummy, DummyClass> instance) throws Throwable {
        DummyClass x = null;
        instance.forEachRemaining(x);
    }
}

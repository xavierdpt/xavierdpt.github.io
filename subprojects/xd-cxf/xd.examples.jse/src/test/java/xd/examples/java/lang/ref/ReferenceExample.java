package xd.examples.java.lang.ref;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.ref.Reference;

@Scaffolded
public class ReferenceExample extends BaseExample<Reference<ReferenceExample.Dummy>> {
    @Override
    public void scaffold(Reference<Dummy> instance) throws Throwable {
        Dummy dummy = instance.get();

        Dummy object = null;
        boolean b = instance.refersTo(object);

        instance.clear();

        boolean enqueue = instance.enqueue();
        Reference.reachabilityFence(object);
    }

    public static class Dummy {
    }
}

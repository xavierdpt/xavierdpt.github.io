package net.xdexamples.jse.examples.java.lang.ref;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

@Scaffolded
public class PhantomReferenceExample extends BaseExample<PhantomReference<PhantomReferenceExample.Dummy>> {
    @Override
    public void scaffold(PhantomReference<Dummy> instance) throws Throwable {
        Dummy referent = null;
        ReferenceQueue<? super Dummy> queue = null;
        ignore(
                new PhantomReference<Dummy>(referent, queue)
        );
        Dummy dummy = instance.get();
    }

    public static class Dummy {
    }
}

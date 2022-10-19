package xd.examples.java.lang.ref;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

@Scaffolded
public class WeakReferenceExample extends BaseExample<WeakReference<WeakReferenceExample.Dummy>> {
    @Override
    public void scaffold(WeakReference<Dummy> instance) throws Throwable {
        Dummy referent = null;
        ReferenceQueue<? super Dummy> queue = null;
        ignore(
                new WeakReference<>(referent),
                new WeakReference<>(referent, queue)
        );
    }

    public static class Dummy {
    }

}

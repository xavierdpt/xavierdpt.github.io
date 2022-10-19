package xd.examples.java.lang.ref;

import xd.BaseExample;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftReferenceExample extends BaseExample<SoftReference<SoftReferenceExample.Dummy>> {

    @Override
    public void scaffold(SoftReference<Dummy> instance) throws Throwable {
        Dummy referent = null;
        ReferenceQueue<? super Dummy> queue = null;
        ignore(
                new SoftReference<Dummy>(referent),
                new SoftReference<Dummy>(referent, queue)
        );
        Dummy dummy = instance.get();
    }

    public static class Dummy {
    }
}

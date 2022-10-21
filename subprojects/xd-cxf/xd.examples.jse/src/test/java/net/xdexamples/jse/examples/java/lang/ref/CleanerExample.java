package net.xdexamples.jse.examples.java.lang.ref;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.ref.Cleaner;
import java.util.concurrent.ThreadFactory;

@Scaffolded
public class CleanerExample extends BaseExample<Cleaner> {
    @Override
    public void scaffold(Cleaner instance) {
        ThreadFactory threadFactory = null;
        Cleaner cleaner = Cleaner.create();
        Cleaner cleaner1 = Cleaner.create(threadFactory);
        Object object = null;
        Runnable runnable = null;
        Cleaner.Cleanable register = instance.register(object, runnable);
    }
}

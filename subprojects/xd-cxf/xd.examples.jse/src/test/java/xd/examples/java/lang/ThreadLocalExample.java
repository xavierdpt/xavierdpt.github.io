package xd.examples.java.lang;

import xd.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.util.function.Supplier;

@ToBeContinued
public class ThreadLocalExample {

    public void scaffold() throws ClassNotFoundException, IOException {
        if (ExampleUtils.skip()) {
            ThreadLocal<Dummy> instance = ExampleUtils.makeInstance(ThreadLocal.class);

            ThreadLocal<Dummy> dummyThreadLocal = new ThreadLocal<>();

            Supplier<Dummy> supplier = null;
            ThreadLocal<Dummy> dummyThreadLocal1 = ThreadLocal.withInitial(supplier);

            Dummy dummy = instance.get();
            instance.set(dummy);
            instance.remove();

        }
    }

    public static class Dummy {
    }

}

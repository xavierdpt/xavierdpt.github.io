package net.xdexamples;

import net.xdexamples.ExampleUtils.ThrowingRunnable;

public abstract class BaseExample<T> {

    protected abstract void scaffold(T instance) throws Throwable;

    protected void ignore(Object... objects) {
        ExampleUtils.ignore(objects);
    }

    protected void seeExamples(ThrowingRunnable... examples) {
        ignore((Object[]) examples);
    }

    protected <T> T any() {
        return null;
    }

    @SafeVarargs
    protected final void seeOthers(Class<? extends BaseExample<?>>... others) {
        ignore((Object[]) others);
    }

}

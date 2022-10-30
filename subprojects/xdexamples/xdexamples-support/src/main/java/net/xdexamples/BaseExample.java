package net.xdexamples;

public abstract class BaseExample<T> {

    protected abstract void scaffold(T instance) throws Throwable;

    /**
     * @deprecated Use @SuppressWarnings
     */
    @Deprecated
    protected void ignore(Object... objects) {
        if (objects == null && f()) {
            throw new RuntimeException("That's not supposed to happen");
        }
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

    private static boolean f() {
        return Math.abs(System.currentTimeMillis()) < 0;
    }

    /**
     * @deprecated Is that still useful ?
     */
    @Deprecated
    public interface ThrowingRunnable {
        public void run() throws Throwable;
    }
}

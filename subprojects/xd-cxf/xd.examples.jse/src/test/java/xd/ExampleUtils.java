package xd;

import xdtest.TestUtils;

import java.util.concurrent.CountDownLatch;

public class ExampleUtils<C> {
    public static boolean skip() {
        return TestUtils.scaffold();
    }

    public static void ignore(Object... objects) {
        TestUtils.ignore(objects);
    }

    public static <T> T makeInstance(Class<T> clazz) {
        return TestUtils.makeInstance(clazz);
    }

    public static String bytesToHex(byte[] bytes) {
        return TestUtils.bytesToHex(bytes);
    }

    public static void parallel(ThrowingRunnable... runnables) {
        if (runnables == null || runnables.length == 0) {
            return;
        }
        CountDownLatch cdl = new CountDownLatch(runnables.length);
        for (ThrowingRunnable runnable : runnables) {
            new Thread(() -> {
                try {
                    runnable.run();
                } catch (Throwable e) {
                    System.out.println(e.getClass().getName() + ": " + e.getMessage());
                } finally {
                    cdl.countDown();
                }
            }).start();
        }
        try {
            synchronized (cdl) {
                cdl.await();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void withSystemProperty(String name, String value, ThrowingRunnable runnable) throws Throwable {
        String previousValue = System.getProperty(name);
        try {
            System.setProperty(name, value);
            runnable.run();
        } finally {
            if (previousValue == null) {
                System.clearProperty(name);
            } else {
                System.setProperty(name, previousValue);
            }
        }
    }

    public interface ThrowingRunnable {
        public void run() throws Throwable;
    }
}

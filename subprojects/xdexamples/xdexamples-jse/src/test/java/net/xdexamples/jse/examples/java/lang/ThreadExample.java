package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;
import java.util.Map;

@Scaffolded
public class ThreadExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            Thread instance = ExampleUtils.makeInstance(Thread.class);

            Runnable target = null;
            ThreadGroup group = null;
            String name = null;
            long stackSize = 0;
            boolean inheritThreadLocals = false;
            ExampleUtils.ignore(
                    new Thread(),
                    new Thread(target),
                    new Thread(group, target),
                    new Thread(name),
                    new Thread(group, name),
                    new Thread(target, name),
                    new Thread(group, target, name),
                    new Thread(group, target, name, stackSize),
                    new Thread(group, target, name, stackSize, inheritThreadLocals)
            );

            Thread thread = instance.currentThread();
            Thread.yield();
            long millis = 0;
            Thread.sleep(millis);
            int nanos = 0;
            Thread.sleep(millis, nanos);
            Thread.onSpinWait();
            instance.start();
            instance.run();
            instance.interrupt();
            boolean interrupted = Thread.interrupted();
            boolean interrupted1 = instance.isInterrupted();
            boolean alive = instance.isAlive();
            int priority = 0;
            instance.setPriority(priority);
            int priority1 = instance.getPriority();
            instance.setName(name);
            String name1 = instance.getName();
            ThreadGroup threadGroup = instance.getThreadGroup();
            int i = instance.activeCount();
            Thread[] array = new Thread[0];
            int enumerate = Thread.enumerate(array);
            instance.join();
            instance.join(millis);
            instance.join(millis, nanos);
            Thread.dumpStack();
            boolean daemon = false;
            instance.setDaemon(daemon);
            boolean daemon1 = instance.isDaemon();
            String s = instance.toString();
            ClassLoader contextClassLoader = instance.getContextClassLoader();
            ClassLoader classLoader = null;
            instance.setContextClassLoader(classLoader);
            Object object = null;
            boolean b = Thread.holdsLock(object);
            StackTraceElement[] stackTrace = instance.getStackTrace();
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            long id = instance.getId();
            Thread.State state = instance.getState();
            Thread.UncaughtExceptionHandler handler = null;
            Thread.setDefaultUncaughtExceptionHandler(handler);
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = instance.getUncaughtExceptionHandler();
            instance.setUncaughtExceptionHandler(handler);
            int minPriority = instance.MIN_PRIORITY;
            int normPriority = instance.NORM_PRIORITY;
            int maxPriority = instance.MAX_PRIORITY;
        }
    }

}

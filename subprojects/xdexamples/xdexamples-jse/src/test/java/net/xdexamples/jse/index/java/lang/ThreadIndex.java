package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ThreadExample_DefaultConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_GroupNameConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_GroupTargetNameStackSize;
import net.xdexamples.jse.examples.java.lang.ThreadExample_GroupTargetNameStackSizeInheritThreadLocalsConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_MIN_NORMAL_MAX_Priority;
import net.xdexamples.jse.examples.java.lang.ThreadExample_NameConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_TargetConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_TargetNameConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_ThreadGroupTargetConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_ThreadGroupTargetNameConstructor;
import net.xdexamples.jse.examples.java.lang.ThreadExample_activeCount;
import net.xdexamples.jse.examples.java.lang.ThreadExample_currentThread;
import net.xdexamples.jse.examples.java.lang.ThreadExample_defaultUncaughtExceptionHandler;
import net.xdexamples.jse.examples.java.lang.ThreadExample_dumpStack;
import net.xdexamples.jse.examples.java.lang.ThreadExample_enumerate;
import net.xdexamples.jse.examples.java.lang.ThreadExample_getAllStackTraces;
import net.xdexamples.jse.examples.java.lang.ThreadExample_getId;
import net.xdexamples.jse.examples.java.lang.ThreadExample_getStackTrace;
import net.xdexamples.jse.examples.java.lang.ThreadExample_getState;
import net.xdexamples.jse.examples.java.lang.ThreadExample_getThreadGroup;
import net.xdexamples.jse.examples.java.lang.ThreadExample_holdsLock;
import net.xdexamples.jse.examples.java.lang.ThreadExample_interrupt;
import net.xdexamples.jse.examples.java.lang.ThreadExample_interrupted;
import net.xdexamples.jse.examples.java.lang.ThreadExample_isAlive;
import net.xdexamples.jse.examples.java.lang.ThreadExample_isDaemon;
import net.xdexamples.jse.examples.java.lang.ThreadExample_isInterrupted;
import net.xdexamples.jse.examples.java.lang.ThreadExample_onSpinWait;
import net.xdexamples.jse.examples.java.lang.ThreadExample_priority;
import net.xdexamples.jse.examples.java.lang.ThreadExample_run;
import net.xdexamples.jse.examples.java.lang.ThreadExample_setContextClassLoader;
import net.xdexamples.jse.examples.java.lang.ThreadExample_setDaemon;
import net.xdexamples.jse.examples.java.lang.ThreadExample_setName;
import net.xdexamples.jse.examples.java.lang.ThreadExample_start_join_sleep;
import net.xdexamples.jse.examples.java.lang.ThreadExample_toString;
import net.xdexamples.jse.examples.java.lang.ThreadExample_uncaughtExceptionHandler;
import net.xdexamples.jse.examples.java.lang.ThreadExample_yield;
import net.xdexamples.support.internal.AccessLevel;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CONCURRENCY)
@AccessLevel(EAccessLevel.PROTECTED)
@Examples({
        @Example(value = ThreadExample_TargetConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_TargetNameConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_ThreadGroupTargetConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_ThreadGroupTargetNameConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_DefaultConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_NameConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_GroupNameConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_GroupTargetNameStackSize.class, illutratesConstructor = true),
        @Example(value = ThreadExample_GroupTargetNameStackSizeInheritThreadLocalsConstructor.class, illutratesConstructor = true),
        @Example(value = ThreadExample_currentThread.class, illustrated = "currentThread"),
        @Example(value = ThreadExample_yield.class, illustrated = "yield"),
        @Example(value = ThreadExample_onSpinWait.class, illustrated = "onSpinWait"),
        @Example(value = ThreadExample_interrupt.class, illustrated = "interrupt"),
        @Example(value = ThreadExample_interrupted.class, illustrated = "interrupted"),
        @Example(value = ThreadExample_isInterrupted.class, illustrated = "interrupted"),
        @Example(value = ThreadExample_MIN_NORMAL_MAX_Priority.class, illustrated = {"MIN_PRIORITY", "NORM_PRIORITY", "MAX_PRIORITY"}),
        @Example(value = ThreadExample_getState.class, illustrated = "getState"),
        @Example(value = ThreadExample_start_join_sleep.class, illustrated = {"start", "join", "sleep"}),
        @Example(value = ThreadExample_setDaemon.class, illustrated = {"setDaemon"}),
        @Example(value = ThreadExample_isDaemon.class, illustrated = {"isDaemon"}),
        @Example(value = ThreadExample_priority.class, illustrated = {"setPriority", "getPriority", "setName"}),
        @Example(value = ThreadExample_setName.class, illustrated = {"setName", "getName"}),
        @Example(value = ThreadExample_isAlive.class, illustrated = {"setName", "isAlive"}),
        @Example(value = ThreadExample_getThreadGroup.class, illustrated = {"getThreadGroup"}),
        @Example(value = ThreadExample_activeCount.class, illustrated = {"activeCount"}),
        @Example(value = ThreadExample_run.class, illustrated = {"run"}),
        @Example(value = ThreadExample_setContextClassLoader.class, illustrated = {"getContextClassLoader", "setContextClassLoader"}),
        @Example(value = ThreadExample_getId.class, illustrated = {"getId"}),
        @Example(value = ThreadExample_defaultUncaughtExceptionHandler.class,
                illustrated = {"getDefaultUncaughtExceptionHandler", "setDefaultUncaughtExceptionHandler"}),
        @Example(value = ThreadExample_uncaughtExceptionHandler.class,
                illustrated = {"getUncaughtExceptionHandler", "setUncaughtExceptionHandler"}),
        @Example(value = ThreadExample_holdsLock.class, illustrated = {"holdsLock"}),
        @Example(value = ThreadExample_enumerate.class, illustrated = {"enumerate"}),
        @Example(value = ThreadExample_toString.class, illustrated = {"toString"}),
        @Example(value = ThreadExample_dumpStack.class, illustrated = {"toString"}),
        @Example(value = ThreadExample_getStackTrace.class, illustrated = {"getStackTrace"}),
        @Example(value = ThreadExample_getAllStackTraces.class, illustrated = {"getAllStackTraces"}),

})
public class ThreadIndex extends ExampleComplete<Thread> {
}

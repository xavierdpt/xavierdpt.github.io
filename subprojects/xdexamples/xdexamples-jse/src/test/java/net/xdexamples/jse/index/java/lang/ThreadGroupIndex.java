package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_activeCount;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_activeGroupCount;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_enumerateThreadGroup;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_enumerateThreadGroupRecurse;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_enumerateThreadRecurse;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_enumerateThreads;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_getMaxPriority;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_getName;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_getParent;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_interrupt;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_list;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_parentOf;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_setMaxPriority;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_toString;
import net.xdexamples.jse.examples.java.lang.ThreadGroupExample_uncaughtException;
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
        @Example(
                value = ThreadGroupExample_getName.class,
                illustrated = "getName",
                illutratesConstructor = true
        ),
        @Example(
                value = ThreadGroupExample_getParent.class,
                illustrated = "getParent",
                illutratesConstructor = true
        ),
        @Example(
                value = ThreadGroupExample_getMaxPriority.class,
                illustrated = "getMaxPriority"
        ),
        @Example(
                value = ThreadGroupExample_setMaxPriority.class,
                illustrated = {"getMaxPriority", "setMaxPriority"}
        ),
        @Example(
                value = ThreadGroupExample_list.class,
                illustrated = {"list"}
        ),
        @Example(
                value = ThreadGroupExample_activeCount.class,
                illustrated = {"activeCount"}
        ),
        @Example(
                value = ThreadGroupExample_activeGroupCount.class,
                illustrated = {"activeGroupCount"}
        ),
        @Example(
                value = ThreadGroupExample_enumerateThreads.class,
                illustrated = {"enumerate"}
        ),
        @Example(
                value = ThreadGroupExample_toString.class,
                illustrated = {"toString"}
        ),
        @Example(
                value = ThreadGroupExample_uncaughtException.class,
                illustrated = {"uncaughtException"}
        ),
        @Example(
                value = ThreadGroupExample_interrupt.class,
                illustrated = {"interrupt"}
        ),
        @Example(
                value = ThreadGroupExample_parentOf.class,
                illustrated = {"parentOf"}
        ),
        @Example(
                value = ThreadGroupExample_enumerateThreadRecurse.class,
                illustrated = {"enumerate"}
        ),
        @Example(
                value = ThreadGroupExample_enumerateThreadGroupRecurse.class,
                illustrated = {"enumerate"}
        ),
        @Example(
                value = ThreadGroupExample_enumerateThreadGroup.class,
                illustrated = {"enumerate"}
        ),
})
public class ThreadGroupIndex extends ExampleComplete<ThreadGroup> {
}

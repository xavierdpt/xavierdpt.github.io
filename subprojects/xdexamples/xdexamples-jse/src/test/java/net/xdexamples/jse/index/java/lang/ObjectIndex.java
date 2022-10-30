package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ObjectExample_deadlock;
import net.xdexamples.jse.examples.java.lang.ObjectExample_equality;
import net.xdexamples.jse.examples.java.lang.ObjectExample_getClass;
import net.xdexamples.jse.examples.java.lang.ObjectExample_hashCode;
import net.xdexamples.jse.examples.java.lang.ObjectExample_toString;
import net.xdexamples.jse.examples.java.lang.ObjectExample_waitAndNotify;
import net.xdexamples.jse.examples.java.lang.ObjectExample_waitAndNotifyAll;
import net.xdexamples.jse.examples.java.lang.ObjectExample_waitAndNotifyImpatient;
import net.xdexamples.support.internal.AccessLevel;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;


@Bundle(EBundle.CORE)
@AccessLevel(EAccessLevel.PUBLIC)
@Examples({
        @Example(value = ObjectExample_getClass.class, illustrated = "getClass"),
        @Example(value = ObjectExample_equality.class, illustrated = "equals"),
        @Example(value = ObjectExample_hashCode.class, illustrated = "hashCode"),
        @Example(value = ObjectExample_toString.class, illustrated = "toString"),
        // TODO: check illustrated
        @Example(
                value = ObjectExample_waitAndNotify.class,
                illustrated = {"wait", "notify"},
                bundle = EBundle.CONCURRENCY,
                access = EAccessLevel.PROTECTED
        ),
        @Example(
                value = ObjectExample_waitAndNotifyImpatient.class,
                illustrated = {"wait", "notify"},
                bundle = EBundle.CONCURRENCY,
                access = EAccessLevel.PROTECTED
        ),
        @Example(
                value = ObjectExample_waitAndNotifyAll.class,
                illustrated = {"wait", "notifyAll"},
                bundle = EBundle.CONCURRENCY,
                access = EAccessLevel.PROTECTED
        ),
        @Example(
                value = ObjectExample_deadlock.class,
                illustrated = {"synchronized", "deadlock"},
                bundle = EBundle.CONCURRENCY,
                access = EAccessLevel.PROTECTED
        )
})
public class ObjectIndex extends ExampleComplete<Object> {
}

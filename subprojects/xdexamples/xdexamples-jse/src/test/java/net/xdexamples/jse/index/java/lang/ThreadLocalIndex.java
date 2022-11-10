package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ThreadLocalExample_get_set;
import net.xdexamples.jse.examples.java.lang.ThreadLocalExample_remove;
import net.xdexamples.jse.examples.java.lang.ThreadLocalExample_withInitial;
import net.xdexamples.support.internal.AccessLevel;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;
import xd.helpers.dummies.Dummy;

@Bundle(EBundle.CONCURRENCY)
@AccessLevel(EAccessLevel.PROTECTED)
@Examples({
        @Example(
                value = ThreadLocalExample_get_set.class,
                illustrated = {"get", "set"},
                illutratesConstructor = true
        ),
        @Example(
                value = ThreadLocalExample_withInitial.class,
                illustrated = {"get", "set", "withInitial"}
        ),
        @Example(
                value = ThreadLocalExample_remove.class,
                illustrated = {"get", "set", "withInitial", "remove"}
        ),
})
public class ThreadLocalIndex extends ExampleComplete<ThreadLocal<Dummy>> {
}

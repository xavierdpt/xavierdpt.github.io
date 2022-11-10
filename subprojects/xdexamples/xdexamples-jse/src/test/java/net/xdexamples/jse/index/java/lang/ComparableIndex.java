package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ComparableExample_basic;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;
import xd.helpers.dummies.Dummy;

@Bundle(EBundle.CORE)
@Examples({
        @Example(value = ComparableExample_basic.class)
})
public class ComparableIndex extends ExampleComplete<Comparable<Dummy>> {

}

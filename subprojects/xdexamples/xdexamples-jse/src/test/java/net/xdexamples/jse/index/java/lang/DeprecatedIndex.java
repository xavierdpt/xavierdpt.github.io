package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.DeprecatedExample;
import net.xdexamples.jse.examples.java.lang.DeprecatedExample_forRemoval;
import net.xdexamples.jse.examples.java.lang.DeprecatedExample_since;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CORE)
@Examples({
        @Example(value = DeprecatedExample.class, illustrated = {"since", "forRemoval"}),
        @Example(value = DeprecatedExample_since.class, illustrated = "since"),
        @Example(value = DeprecatedExample_forRemoval.class, illustrated = "forRemoval"),
})
public class DeprecatedIndex extends ExampleComplete<Deprecated> {
}

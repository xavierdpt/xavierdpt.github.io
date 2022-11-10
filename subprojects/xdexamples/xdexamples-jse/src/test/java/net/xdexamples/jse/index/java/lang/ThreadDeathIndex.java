package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ThreadDeathExample;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CONCURRENCY)
@Examples({
        @Example(value = ThreadDeathExample.class)
})
public class ThreadDeathIndex extends ExampleComplete<ThreadDeath> {

}

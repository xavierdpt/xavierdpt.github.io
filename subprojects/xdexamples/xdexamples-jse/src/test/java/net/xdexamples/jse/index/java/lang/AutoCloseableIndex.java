package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.AutoCloseableExample_vsCloseable;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;
import xdtest.ExternalLinks;


@Bundle(EBundle.CORE)
@Examples({
        @Example(value = AutoCloseableExample_vsCloseable.class)
})
@ExternalLinks({
        "https://stackoverflow.com/questions/13141302/implements-closeable-or-implements-autocloseable"
})
public class AutoCloseableIndex extends ExampleComplete<AutoCloseable> {
}

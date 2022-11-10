package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.ReadableExample;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CORE)
@Examples({
        @Example(value = ReadableExample.class, illustrated = "read", improvable = true)
})
public class ReadableIndex extends ExampleComplete<Readable> {
}

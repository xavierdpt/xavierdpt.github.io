package net.xdexamples.jse.index.java.lang;

import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CORE)
@Examples({
        @Example(
                value = NumberExample_values.class,
                illustrated = {"doubleValue", "floatValue", "longValue", "intValue", "shortValue", "byteValue"}
        ),
        @Example(value = NumberExample_subTypes.class)
})
public class NumberIndex extends ExampleComplete<Number> {

}

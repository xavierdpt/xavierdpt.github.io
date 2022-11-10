package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.AppendableExample_char;
import net.xdexamples.jse.examples.java.lang.AppendableExample_charSequence;
import net.xdexamples.jse.examples.java.lang.AppendableExample_charSequenceStartEnd;
import net.xdexamples.jse.examples.java.lang.AppendableExample_subTypes;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;


@Bundle(EBundle.CORE)
@Examples({
        @Example(value = AppendableExample_char.class, illustrated = "append"),
        @Example(value = AppendableExample_charSequence.class, illustrated = "append"),
        @Example(value = AppendableExample_charSequenceStartEnd.class, illustrated = "append"),
        @Example(value = AppendableExample_subTypes.class),
})
public class AppendableIndex extends ExampleComplete<Appendable> {
}

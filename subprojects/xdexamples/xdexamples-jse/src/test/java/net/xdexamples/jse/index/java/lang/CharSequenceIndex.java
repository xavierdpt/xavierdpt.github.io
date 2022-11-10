package net.xdexamples.jse.index.java.lang;

import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CORE)
@Examples({
        @Example(value = CharSequenceExample_length.class, illustrated = "length"),
        @Example(value = CharSequenceExample_charAt.class, illustrated = "charAt"),
        @Example(value = CharSequenceExample_isEmpty.class, illustrated = "isEmpty"),
        @Example(value = CharSequenceExample_toString.class, illustrated = "toString"),
        @Example(value = CharSequenceExample_chars.class, illustrated = "chars"),
        @Example(value = CharSequenceExample_codePoints.class, illustrated = "codePoints"),
        @Example(value = CharSequenceExample_subSequence.class, illustrated = "subSequence"),
        @Example(value = CharSequenceExample_compare.class, illustrated = "compare"),
})
public class CharSequenceIndex extends ExampleComplete<CharSequence> {
}

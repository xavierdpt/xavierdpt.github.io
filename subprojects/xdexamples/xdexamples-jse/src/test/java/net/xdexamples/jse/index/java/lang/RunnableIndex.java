package net.xdexamples.jse.index.java.lang;

import net.xdexamples.jse.examples.java.lang.RunnableExample_run_explicit;
import net.xdexamples.jse.examples.java.lang.RunnableExample_run_lambda;
import net.xdexamples.jse.examples.java.lang.RunnableExample_thread;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.support.internal.EAccessLevel;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.ExampleComplete;
import net.xdexamples.support.internal.Examples;

@Bundle(EBundle.CORE)
@Examples({
        @Example(value = RunnableExample_run_explicit.class, illustrated = "run"),
        @Example(value = RunnableExample_run_lambda.class, illustrated = "run"),
        @Example(value = RunnableExample_thread.class, illustrated = "run",
                bundle = EBundle.CONCURRENCY, access = EAccessLevel.PROTECTED)
})
public class RunnableIndex extends ExampleComplete<Runnable> {
}

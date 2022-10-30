package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Bundle;
import net.xdexamples.AllMethodsCovered;
import net.xdexamples.support.internal.EBundle;
import net.xdexamples.jse.summary.java.lang.RunnableSummary;
import net.xdexamples.support.internal.Example;
import net.xdexamples.support.internal.Examples;
import net.xdexamples.support.internal.Summary;

@Bundle(EBundle.CORE)
@AllMethodsCovered
@Examples({
        @Example(value = RunnableExample_run_explicit.class, illustrated = "run"),
        @Example(value = RunnableExample_run_lambda.class, illustrated = "run")
})
@Summary(RunnableSummary.class)
public class RunnableExample extends BaseExample<Runnable> {
    @Override
    protected void scaffold(Runnable instance) throws Throwable {
        instance.run();
    }
}

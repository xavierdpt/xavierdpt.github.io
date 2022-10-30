package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.BaseExample;
import net.xdexamples.Bundle;
import net.xdexamples.AllMethodsCovered;
import net.xdexamples.EBundle;
import net.xdexamples.jse.summary.java.lang.RunnableSummary;
import net.xdexamples.support.Example;
import net.xdexamples.support.Examples;
import net.xdexamples.support.Summary;

@Bundle(EBundle.CORE)
@AllMethodsCovered
@Examples({
        @Example(value = RunnableExample_run_explicit.class, illustratedMethods = "run"),
        @Example(value = RunnableExample_run_lambda.class, illustratedMethods = "run")
})
@Summary(RunnableSummary.class)
public class RunnableExample extends BaseExample<Runnable> {
    @Override
    protected void scaffold(Runnable instance) throws Throwable {
        instance.run();
    }
}

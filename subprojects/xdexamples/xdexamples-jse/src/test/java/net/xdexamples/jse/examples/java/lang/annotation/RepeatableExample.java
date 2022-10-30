package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;

@Scaffolded
public class RepeatableExample extends BaseExample<Repeatable> {
    @Override
    public void scaffold(Repeatable instance) {
        Class<? extends Annotation> value = instance.value();
    }
}

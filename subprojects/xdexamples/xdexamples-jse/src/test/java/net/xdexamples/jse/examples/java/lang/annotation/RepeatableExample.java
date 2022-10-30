package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;

@Scaffolded
public class RepeatableExample extends BaseExample<Repeatable> {
    @Override
    public void scaffold(Repeatable instance) {
        Class<? extends Annotation> value = instance.value();
    }
}

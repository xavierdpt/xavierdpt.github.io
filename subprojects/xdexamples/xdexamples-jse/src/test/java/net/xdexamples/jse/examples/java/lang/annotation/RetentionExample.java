package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Scaffolded
public class RetentionExample extends BaseExample<Retention> {
    @Override
    public void scaffold(Retention instance) {
        RetentionPolicy value = instance.value();
    }
}

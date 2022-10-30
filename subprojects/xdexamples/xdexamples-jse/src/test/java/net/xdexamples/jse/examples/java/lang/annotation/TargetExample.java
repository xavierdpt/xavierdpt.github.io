package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Scaffolded
public class TargetExample extends BaseExample<Target> {
    @Override
    public void scaffold(Target instance) {
        ElementType[] value = instance.value();
    }
}

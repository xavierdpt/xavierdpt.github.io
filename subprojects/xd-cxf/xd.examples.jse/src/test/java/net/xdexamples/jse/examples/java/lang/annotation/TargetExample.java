package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.Scaffolded;
import net.xdexamples.BaseExample;
import xdtest.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Scaffolded
@Annotation
public class TargetExample extends BaseExample<Target> {
    @Override
    public void scaffold(Target instance) {
        ElementType[] value = instance.value();
    }
}

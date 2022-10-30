package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.annotation.Annotation;

@Scaffolded
public class AnnotationExample extends BaseExample<Annotation> {
    @Override
    public void scaffold(Annotation instance) {
        Annotation other = null;
        boolean equals = instance.equals(other);
        int i = instance.hashCode();
        String s = instance.toString();
        Class<? extends Annotation> aClass = instance.annotationType();
    }
}

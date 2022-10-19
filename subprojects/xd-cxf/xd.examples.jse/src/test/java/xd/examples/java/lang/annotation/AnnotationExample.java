package xd.examples.java.lang.annotation;

import xd.BaseExample;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.lang.annotation.Annotation;

@Scaffolded
@Interface
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

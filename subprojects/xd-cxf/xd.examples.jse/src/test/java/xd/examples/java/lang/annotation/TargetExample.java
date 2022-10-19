package xd.examples.java.lang.annotation;

import xd.BaseExample;
import xdtest.Annotation;
import xdtest.Scaffolded;

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

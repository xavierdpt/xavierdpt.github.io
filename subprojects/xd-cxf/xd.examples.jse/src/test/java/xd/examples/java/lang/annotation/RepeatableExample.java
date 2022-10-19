package xd.examples.java.lang.annotation;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;

@Scaffolded
@xdtest.Annotation
public class RepeatableExample extends BaseExample<Repeatable> {
    @Override
    public void scaffold(Repeatable instance) {
        Class<? extends Annotation> value = instance.value();
    }
}

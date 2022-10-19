package xd.examples.java.lang.annotation;

import xd.BaseExample;
import xdtest.Annotation;
import xdtest.Scaffolded;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Scaffolded
@Annotation
public class RetentionExample extends BaseExample<Retention> {
    @Override
    public void scaffold(Retention instance) {
        RetentionPolicy value = instance.value();
    }
}

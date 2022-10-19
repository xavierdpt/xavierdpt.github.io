package xd.examples.java.lang.annotation;

import xd.BaseExample;
import xdtest.Annotation;
import xdtest.Scaffolded;

import java.lang.annotation.Documented;

@Scaffolded
@Annotation
public class DocumentedExample extends BaseExample<Documented> {
    @Override
    public void scaffold(Documented instance) {
        // nothing
    }
}

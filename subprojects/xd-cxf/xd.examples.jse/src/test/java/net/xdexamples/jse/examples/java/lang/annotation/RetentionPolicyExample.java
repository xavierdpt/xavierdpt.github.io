package net.xdexamples.jse.examples.java.lang.annotation;

import net.xdexamples.BaseExample;
import xdtest.Enum;
import net.xdexamples.Scaffolded;

import java.lang.annotation.RetentionPolicy;

@Scaffolded
@Enum
public class RetentionPolicyExample extends BaseExample<RetentionPolicy> {
    @Override
    public void scaffold(RetentionPolicy instance) throws Throwable {
        ignore(
                RetentionPolicy.SOURCE,
                RetentionPolicy.CLASS,
                RetentionPolicy.RUNTIME
        );
    }
}

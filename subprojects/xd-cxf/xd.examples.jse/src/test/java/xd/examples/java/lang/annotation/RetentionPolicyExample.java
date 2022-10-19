package xd.examples.java.lang.annotation;

import xd.BaseExample;
import xdtest.Enum;
import xdtest.Scaffolded;

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

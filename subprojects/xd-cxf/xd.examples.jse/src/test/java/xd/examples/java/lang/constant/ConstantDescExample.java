package xd.examples.java.lang.constant;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.constant.ConstantDesc;
import java.lang.invoke.MethodHandles;

@Scaffolded
public class ConstantDescExample extends BaseExample<ConstantDesc> {
    @Override
    public void scaffold(ConstantDesc instance) throws ReflectiveOperationException {
        MethodHandles.Lookup lookup = null;
        Object o = instance.resolveConstantDesc(lookup);
    }
}

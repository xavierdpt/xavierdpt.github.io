package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.Scaffolded;
import net.xdexamples.BaseExample;

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

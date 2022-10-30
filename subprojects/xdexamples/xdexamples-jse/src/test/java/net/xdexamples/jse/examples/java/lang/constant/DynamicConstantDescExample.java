package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.constant.ClassDesc;
import java.lang.constant.ConstantDesc;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.constant.DynamicConstantDesc;
import java.lang.invoke.MethodHandles;
import java.util.List;

@Scaffolded
public class DynamicConstantDescExample extends BaseExample<DynamicConstantDesc<DynamicConstantDescExample.Dummy>> {

    @Override
    public void scaffold(DynamicConstantDesc<Dummy> instance) throws ReflectiveOperationException {
        DirectMethodHandleDesc bootstrapMethod = null;
        String constantName = null;
        ClassDesc constantType = null;
        ConstantDesc[] boostrapArgs = new ConstantDesc[0];
        ConstantDesc constantDesc = DynamicConstantDesc.ofCanonical(bootstrapMethod, constantName, constantType, boostrapArgs);
        DynamicConstantDesc<Object> objectDynamicConstantDesc = DynamicConstantDesc.ofNamed(bootstrapMethod, constantName, constantType, boostrapArgs);
        DynamicConstantDesc<Object> of = DynamicConstantDesc.of(bootstrapMethod, boostrapArgs);
        DynamicConstantDesc<Object> of1 = DynamicConstantDesc.of(bootstrapMethod);

        String s = instance.constantName();
        ClassDesc classDesc = instance.constantType();
        DirectMethodHandleDesc directMethodHandleDesc = instance.bootstrapMethod();
        ConstantDesc[] constantDescs = instance.bootstrapArgs();
        List<ConstantDesc> constantDescs1 = instance.bootstrapArgsList();
        MethodHandles.Lookup lookup = null;
        Dummy dummy = instance.resolveConstantDesc(lookup);

        DynamicConstantDesc<Dummy> other = null;
        boolean equals = instance.equals(other);

        int i = instance.hashCode();
        String s1 = instance.toString();
    }

    public static class Dummy {
    }
}

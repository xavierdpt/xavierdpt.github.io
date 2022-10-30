package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.constant.ConstantDesc;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.constant.DynamicCallSiteDesc;
import java.lang.constant.MethodHandleDesc;
import java.lang.constant.MethodTypeDesc;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;

@Scaffolded
public class DynamicCallSiteDescExample extends BaseExample<DynamicCallSiteDesc> {
    @Override
    public void scaffold(DynamicCallSiteDesc instance) throws Throwable {
        DirectMethodHandleDesc bootstrapMethod = null;
        String invocationName = null;
        MethodTypeDesc invocationType = null;
        ConstantDesc[] boostrapArgs = new ConstantDesc[0];
        DynamicCallSiteDesc of = DynamicCallSiteDesc.of(bootstrapMethod, invocationName, invocationType, boostrapArgs);
        DynamicCallSiteDesc of1 = DynamicCallSiteDesc.of(bootstrapMethod, invocationName, invocationType);
        DynamicCallSiteDesc of2 = DynamicCallSiteDesc.of(bootstrapMethod, invocationType);

        DynamicCallSiteDesc dynamicCallSiteDesc = instance.withArgs(boostrapArgs);

        DynamicCallSiteDesc dynamicCallSiteDesc1 = instance.withNameAndType(invocationName, invocationType);

        String s = instance.invocationName();
        MethodTypeDesc methodTypeDesc = instance.invocationType();
        MethodHandleDesc methodHandleDesc = instance.bootstrapMethod();
        ConstantDesc[] constantDescs = instance.bootstrapArgs();

        MethodHandles.Lookup lookup = null;
        CallSite callSite = instance.resolveCallSiteDesc(lookup);

        DynamicCallSiteDesc other = null;
        boolean equals = instance.equals(other);
        int i = instance.hashCode();
        String s1 = instance.toString();
    }
}

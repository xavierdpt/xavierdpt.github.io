package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

@Scaffolded
public class CallSiteExample extends BaseExample<CallSite> {
    @Override
    public void scaffold(CallSite instance) {
        MethodType type = instance.type();
        MethodHandle target = instance.getTarget();
        instance.setTarget(target);
        MethodHandle methodHandle = instance.dynamicInvoker();
    }
}

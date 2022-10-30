package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;

@Scaffolded
public class ConstantCallSiteExample extends BaseExample<ConstantCallSite> {
    @Override
    public void scaffold(ConstantCallSite instance) {
        MethodHandle methodHandle = null;
        ignore(
                new ConstantCallSite(methodHandle)
        );

        MethodHandle target = instance.getTarget();
        instance.setTarget(target);
        MethodHandle methodHandle1 = instance.dynamicInvoker();
    }
}

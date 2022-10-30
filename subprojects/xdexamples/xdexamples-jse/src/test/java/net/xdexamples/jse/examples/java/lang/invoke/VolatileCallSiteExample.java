package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.BaseExample;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.VolatileCallSite;

public class VolatileCallSiteExample extends BaseExample<VolatileCallSite> {
    @Override
    public void scaffold(VolatileCallSite instance) {
        MethodHandle methodType = null;
        MethodHandle methodHandle = null;
        ignore(
                new VolatileCallSite(methodType),
                new VolatileCallSite(methodHandle)
        );
        MethodHandle target = instance.getTarget();
        instance.setTarget(target);
        MethodHandle methodHandle1 = instance.dynamicInvoker();
    }
}

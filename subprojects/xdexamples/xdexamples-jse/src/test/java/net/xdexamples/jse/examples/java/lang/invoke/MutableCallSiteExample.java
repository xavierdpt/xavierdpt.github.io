package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MutableCallSite;

@Scaffolded
public class MutableCallSiteExample extends BaseExample<MutableCallSite> {
    @Override
    public void scaffold(MutableCallSite instance) {
        MethodHandle methodType = null;
        MethodHandle methodHandle = null;
        ignore(
                new MutableCallSite(methodType),
                new MutableCallSite(methodHandle)
        );
        MethodHandle target = instance.getTarget();
        instance.setTarget(target);
        MethodHandle methodHandle1 = instance.dynamicInvoker();
        MutableCallSite[] sites = new MutableCallSite[0];
        MutableCallSite.syncAll(sites);
    }
}

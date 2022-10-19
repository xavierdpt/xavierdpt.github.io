package xd.examples.java.lang.invoke;

import xd.BaseExample;
import xdtest.Scaffolded;

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

package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.constant.ClassDesc;
import java.lang.constant.DirectMethodHandleDesc;

@Scaffolded
public class DirectMethodHandleDescExample extends BaseExample<DirectMethodHandleDesc> {
    @Override
    public void scaffold(DirectMethodHandleDesc instance) {
        DirectMethodHandleDesc.Kind kind = instance.kind();
        int i = instance.refKind();
        boolean ownerInterface = instance.isOwnerInterface();
        ClassDesc owner = instance.owner();
        String s = instance.methodName();
        String s1 = instance.lookupDescriptor();
    }
}

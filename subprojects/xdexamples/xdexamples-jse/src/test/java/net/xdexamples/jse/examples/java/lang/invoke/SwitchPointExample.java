package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.BaseExample;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.SwitchPoint;

public class SwitchPointExample extends BaseExample<SwitchPoint> {
    @Override
    public void scaffold(SwitchPoint instance) {
        ignore(
                new SwitchPoint()
        );
        boolean b = instance.hasBeenInvalidated();
        MethodHandle target = null;
        MethodHandle fallback = null;
        MethodHandle methodHandle = instance.guardWithTest(target, fallback);
        SwitchPoint[] switchPoints = new SwitchPoint[0];
        SwitchPoint.invalidateAll(switchPoints);
    }
}

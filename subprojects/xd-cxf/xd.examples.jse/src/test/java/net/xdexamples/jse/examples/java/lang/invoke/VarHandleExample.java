package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Optional;

@Scaffolded
public class VarHandleExample extends BaseExample<VarHandle> {
    @Override
    public void scaffold(VarHandle instance) {

        boolean b = instance.hasInvokeExactBehavior();
        Object[] args = new Object[0];
        Object o = instance.get(args);
        instance.set(args);
        Object aVolatile = instance.getVolatile(args);
        instance.setVolatile(args);
        Object opaque = instance.getOpaque(args);
        instance.setOpaque(args);
        Object acquire = instance.getAcquire(args);
        instance.setRelease(args);
        boolean b1 = instance.compareAndSet(args);
        Object o1 = instance.compareAndExchange(args);
        Object o2 = instance.compareAndExchangeAcquire(args);
        Object o3 = instance.compareAndExchangeRelease(args);
        boolean b2 = instance.weakCompareAndSetPlain(args);
        boolean b3 = instance.weakCompareAndSet(args);
        boolean b4 = instance.weakCompareAndSetAcquire(args);
        boolean b5 = instance.weakCompareAndSetRelease(args);
        Object andSet = instance.getAndSet(args);
        Object andSetAcquire = instance.getAndSetAcquire(args);
        Object andSetRelease = instance.getAndSetRelease(args);
        Object andAdd = instance.getAndAdd(args);
        Object andAddAcquire = instance.getAndAddAcquire(andAdd);
        Object andAddRelease = instance.getAndAddRelease(args);
        Object andBitwiseOr = instance.getAndBitwiseOr(args);
        Object andBitwiseOrAcquire = instance.getAndBitwiseOrAcquire(args);
        Object andBitwiseOrRelease = instance.getAndBitwiseOrRelease(args);
        Object andBitwiseAnd = instance.getAndBitwiseAnd(args);
        Object andBitwiseAndAcquire = instance.getAndBitwiseAndAcquire(args);
        Object andBitwiseAndRelease = instance.getAndBitwiseAndRelease(args);
        Object andBitwiseXor = instance.getAndBitwiseXor(args);
        Object andBitwiseXorAcquire = instance.getAndBitwiseXorAcquire(args);
        Object andBitwiseXorRelease = instance.getAndBitwiseXorRelease(args);
        VarHandle varHandle = instance.withInvokeExactBehavior();
        VarHandle varHandle1 = instance.withInvokeBehavior();
        String s = instance.toString();
        Class<?> aClass = instance.varType();
        List<Class<?>> classes = instance.coordinateTypes();
        VarHandle.AccessMode accessMode = null;
        MethodType methodType = instance.accessModeType(accessMode);
        boolean accessModeSupported = instance.isAccessModeSupported(accessMode);
        MethodHandle methodHandle = instance.toMethodHandle(accessMode);
        Optional<VarHandle.VarHandleDesc> varHandleDesc = instance.describeConstable();
        VarHandle.fullFence();
        VarHandle.acquireFence();
        VarHandle.releaseFence();
        VarHandle.loadLoadFence();
        VarHandle.storeStoreFence();
    }
}

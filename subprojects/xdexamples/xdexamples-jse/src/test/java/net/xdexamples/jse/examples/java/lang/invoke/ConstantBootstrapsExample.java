package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.invoke.ConstantBootstraps;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;

@Scaffolded
public class ConstantBootstrapsExample extends BaseExample<ConstantBootstraps> {
    @Override
    public void scaffold(ConstantBootstraps instance) throws Throwable {

        MethodHandles.Lookup lookup = null;
        String name = null;
        Class<Dummy> type = null;
        Object o = ConstantBootstraps.nullConstant(lookup, name, type);

        Class<?> aClass = ConstantBootstraps.primitiveClass(lookup, name, type);

        Class<DummyEnum> typeE = null;
        DummyEnum dummyEnum = instance.enumConstant(lookup, name, typeE);

        Class<Dummy2> declaringClass = null;
        Object staticFinal = ConstantBootstraps.getStaticFinal(lookup, name, type, declaringClass);
        Object staticFinal1 = ConstantBootstraps.getStaticFinal(lookup, name, type);

        MethodHandle methodHandle = null;
        Object[] args = new Object[0];
        Object invoke = instance.invoke(lookup, name, type, methodHandle, args);

        Class<VarHandle> varHandleType = null;
        Class<Dummy> fieldtype = null;
        VarHandle varHandle = ConstantBootstraps.fieldVarHandle(lookup, name, varHandleType, declaringClass, fieldtype);
        VarHandle varHandle1 = ConstantBootstraps.staticFieldVarHandle(lookup, name, varHandleType, declaringClass, fieldtype);

        VarHandle varHandle2 = ConstantBootstraps.arrayVarHandle(lookup, name, varHandleType, type);

        Object value = null;
        Object o1 = ConstantBootstraps.explicitCast(lookup, name, type, value);

    }

    public static class Dummy {
    }

    public static class Dummy2 {
    }

    public static enum DummyEnum {
    }
}

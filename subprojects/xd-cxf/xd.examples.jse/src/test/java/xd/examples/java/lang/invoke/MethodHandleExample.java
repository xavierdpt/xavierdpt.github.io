package xd.examples.java.lang.invoke;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.constant.MethodHandleDesc;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Optional;

@Scaffolded
public class MethodHandleExample extends BaseExample<MethodHandle> {
    @Override
    public void scaffold(MethodHandle instance) throws Throwable {

        MethodType type = instance.type();

        Object[] args = new Object[0];
        Object o = instance.invokeExact(args);

        Object invoke = instance.invoke(args);

        Object o1 = instance.invokeWithArguments(args);

        List<?> argsList = null;
        Object o2 = instance.invokeWithArguments(argsList);

        MethodType methodType = null;
        MethodHandle methodHandle = instance.asType(methodType);

        Class<?> arrayType = null;
        int arrayLength = 0;
        MethodHandle methodHandle1 = instance.asSpreader(arrayType, arrayLength);

        int pos = 0;
        MethodHandle methodHandle2 = instance.asSpreader(pos, arrayType, arrayLength);

        boolean hasVarArgs = false;
        MethodHandle methodHandle3 = instance.withVarargs(hasVarArgs);

        MethodHandle methodHandle4 = instance.asCollector(arrayType, arrayLength);
        MethodHandle methodHandle5 = instance.asCollector(pos, arrayType, arrayLength);

        MethodHandle methodHandle6 = instance.asVarargsCollector(arrayType);

        boolean varargsCollector = instance.isVarargsCollector();

        MethodHandle methodHandle7 = instance.asFixedArity();

        Object object = null;
        MethodHandle methodHandle8 = instance.bindTo(object);

        Optional<MethodHandleDesc> methodHandleDesc = instance.describeConstable();

        String s = instance.toString();

    }
}

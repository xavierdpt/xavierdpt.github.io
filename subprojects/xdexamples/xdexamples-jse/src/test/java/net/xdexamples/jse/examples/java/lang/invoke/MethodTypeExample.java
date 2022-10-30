package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.constant.MethodTypeDesc;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Optional;

@Scaffolded
public class MethodTypeExample extends BaseExample<MethodType> {
    @Override
    public void scaffold(MethodType instance) {

        Class<Dummy> returnType = null;
        Class<?>[] parameterTypes = new Class[0];
        List<Class<?>> parameterTypeList = null;
        Class<?> parameterType = null;
        Class<?>[] moreParameterTypes = new Class[0];
        MethodType methodType = null;

        MethodType methodType0 = MethodType.methodType(returnType);
        MethodType methodType1 = MethodType.methodType(returnType, parameterTypes);
        MethodType methodType2 = MethodType.methodType(returnType, parameterTypeList);
        MethodType.methodType(returnType, parameterType, moreParameterTypes);
        MethodType methodType3 = MethodType.methodType(returnType, parameterType);
        MethodType methodType4 = MethodType.methodType(returnType, methodType);

        int count = 0;
        boolean finalArray = false;
        MethodType methodType5 = MethodType.genericMethodType(count);
        MethodType methodType6 = MethodType.genericMethodType(count, finalArray);

        int index = 0;
        Class<?> dummyType = null;
        MethodType methodType7 = instance.changeParameterType(index, dummyType);

        MethodType methodType8 = instance.insertParameterTypes(index, parameterTypes);
        MethodType methodType9 = instance.insertParameterTypes(index, parameterTypeList);

        MethodType methodType10 = instance.appendParameterTypes(parameterTypes);
        MethodType methodType11 = instance.appendParameterTypes(parameterTypeList);

        int start = 0;
        int end = 0;
        MethodType methodType12 = instance.dropParameterTypes(start, end);

        MethodType methodType13 = instance.changeReturnType(returnType);

        boolean b = instance.hasPrimitives();
        boolean b1 = instance.hasWrappers();
        MethodType erase = instance.erase();
        MethodType generic = instance.generic();
        MethodType wrap = instance.wrap();
        MethodType unwrap = instance.unwrap();
        Class<?> aClass = instance.parameterType(index);
        int i = instance.parameterCount();
        Class<?> aClass1 = instance.returnType();
        List<Class<?>> classes = instance.parameterList();
        Class<?> aClass2 = instance.lastParameterType();
        Class<?>[] classes1 = instance.parameterArray();
        MethodType other = null;
        boolean equals = instance.equals(other);

        int i1 = instance.hashCode();
        String s = instance.toString();

        String descriptor = null;
        ClassLoader classLoader = null;
        MethodType methodType14 = MethodType.fromMethodDescriptorString(descriptor, classLoader);

        String s1 = instance.toMethodDescriptorString();

        String s2 = instance.descriptorString();
        Optional<MethodTypeDesc> methodTypeDesc = instance.describeConstable();

    }

    public static class Dummy {
    }
}

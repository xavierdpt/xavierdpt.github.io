package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Member;
import java.nio.ByteOrder;
import java.util.List;

@Scaffolded
public class MethodHandlesExample extends BaseExample<MethodHandles> {
    @Override
    public void scaffold(MethodHandles instance) throws IllegalAccessException {

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandles.Lookup lookup1 = MethodHandles.publicLookup();

        Class<Dummy> dummyClass = null;
        MethodHandles.Lookup lookup2 = MethodHandles.privateLookupIn(dummyClass, lookup);

        String name = null;
        Dummy dummy = MethodHandles.classData(lookup, name, dummyClass);


        int index = 0;
        Dummy dummy1 = MethodHandles.classDataAt(lookup, name, dummyClass, index);

        Class<DummyMember> expected = null;
        MethodHandle methodHandle = null;
        DummyMember dummyMember = MethodHandles.reflectAs(expected, methodHandle);

        Class<Dummy> arrayClass = null;
        MethodHandle methodHandle1 = MethodHandles.arrayConstructor(arrayClass);

        MethodHandle methodHandle2 = MethodHandles.arrayLength(arrayClass);

        MethodHandle methodHandle3 = MethodHandles.arrayElementGetter(arrayClass);

        MethodHandle methodHandle4 = MethodHandles.arrayElementSetter(arrayClass);

        VarHandle varHandle = MethodHandles.arrayElementVarHandle(arrayClass);

        Class<Dummy> viewArrayClass = null;
        ByteOrder byteOrder = null;
        VarHandle varHandle1 = MethodHandles.byteArrayViewVarHandle(viewArrayClass, byteOrder);

        VarHandle varHandle2 = MethodHandles.byteBufferViewVarHandle(viewArrayClass, byteOrder);

        MethodType methodType = null;
        int count = 0;
        MethodHandle methodHandle5 = MethodHandles.spreadInvoker(methodType, count);

        MethodHandle methodHandle6 = MethodHandles.exactInvoker(methodType);

        MethodHandle invoker = MethodHandles.invoker(methodType);

        VarHandle.AccessMode accessMode = null;
        MethodHandle methodHandle7 = MethodHandles.varHandleExactInvoker(accessMode, methodType);

        MethodHandle methodHandle8 = MethodHandles.varHandleInvoker(accessMode, methodType);

        MethodHandle methodHandle9 = MethodHandles.explicitCastArguments(methodHandle, methodType);

        int[] reorder = new int[0];
        MethodHandle methodHandle10 = MethodHandles.permuteArguments(methodHandle, methodType, reorder);

        Class<Dummy> dummyType = null;
        Object value = null;
        MethodHandle constant = MethodHandles.constant(dummyType, value);

        MethodHandle identity = MethodHandles.identity(dummyType);

        MethodHandle zero = MethodHandles.zero(dummyType);

        MethodHandle empty = MethodHandles.empty(methodType);

        int position = 0;
        Object[] values = new Object[0];
        MethodHandle methodHandle11 = MethodHandles.insertArguments(methodHandle, position, values);

        MethodHandle target = null;
        Class<?>[] types = new Class[0];
        MethodHandle methodHandle12 = MethodHandles.dropArguments(target, position, types);

        List<Class<?>> typeList = null;
        MethodHandle methodHandle13 = MethodHandles.dropArguments(target, position, typeList);

        int skip = 0;
        List<Class<?>> newTypes = null;
        MethodHandle methodHandle14 = MethodHandles.dropArgumentsToMatch(target, skip, newTypes, position);

        MethodHandle methodHandle15 = MethodHandles.dropReturn(target);

        MethodHandle[] filters = new MethodHandle[0];
        MethodHandle methodHandle16 = MethodHandles.filterArguments(target, position, filters);

        MethodHandle filter = null;
        MethodHandle methodHandle17 = MethodHandles.collectArguments(target, position, filter);

        MethodHandle methodHandle18 = MethodHandles.filterReturnValue(target, filter);

        MethodHandle combiner = null;
        MethodHandle methodHandle19 = MethodHandles.foldArguments(target, combiner);

        MethodHandle methodHandle20 = MethodHandles.foldArguments(target, position, combiner);

        MethodHandle test = null;
        MethodHandle fallback = null;
        MethodHandle methodHandle21 = MethodHandles.guardWithTest(test, target, fallback);

        Class<Throwable> exceptionType = null;
        MethodHandle methodHandle22 = MethodHandles.catchException(target, exceptionType, methodHandle);

        Class<?> returnType = null;
        MethodHandle methodHandle23 = MethodHandles.throwException(returnType, exceptionType);

        MethodHandle[][] clauses = new MethodHandle[0][];
        MethodHandle loop = MethodHandles.loop(clauses);

        MethodHandle init = null;
        MethodHandle pred = null;
        MethodHandle body = null;
        MethodHandle methodHandle24 = MethodHandles.whileLoop(init, pred, body);

        MethodHandle methodHandle25 = MethodHandles.doWhileLoop(init, body, pred);

        MethodHandle iterations = null;
        MethodHandle methodHandle26 = MethodHandles.countedLoop(iterations, init, body);

        MethodHandle start = null;
        MethodHandle end = null;
        MethodHandle methodHandle27 = MethodHandles.countedLoop(start, end, init, body);

        MethodHandle iterator = null;
        MethodHandle methodHandle28 = MethodHandles.iteratedLoop(iterator, init, body);

        MethodHandle cleanup = null;
        MethodHandle methodHandle29 = MethodHandles.tryFinally(target, cleanup);

        MethodHandle[] targets = new MethodHandle[0];
        MethodHandle methodHandle30 = MethodHandles.tableSwitch(fallback, targets);

    }

    public static class Dummy {
    }

    public interface DummyMember extends Member {
    }
}

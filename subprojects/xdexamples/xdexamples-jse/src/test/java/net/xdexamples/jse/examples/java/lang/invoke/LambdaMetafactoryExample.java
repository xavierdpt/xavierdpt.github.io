package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

@Scaffolded
public class LambdaMetafactoryExample extends BaseExample<LambdaMetafactory> {
    @Override
    public void scaffold(LambdaMetafactory instance) throws LambdaConversionException {
        MethodHandles.Lookup lookup = null;
        String interfaceMethodName = null;
        MethodType factoryType = null;
        MethodType interfaceMethodType = null;
        MethodHandle methodHandle = null;
        MethodType methodType = null;
        CallSite metafactory = LambdaMetafactory.metafactory(lookup, interfaceMethodName, factoryType, interfaceMethodType, methodHandle, methodType);

        Object[] args = new Object[0];
        CallSite callSite = LambdaMetafactory.altMetafactory(lookup, interfaceMethodName, factoryType, args);

        int flagSerializable = LambdaMetafactory.FLAG_SERIALIZABLE;
        int flagMarkers = LambdaMetafactory.FLAG_MARKERS;
        int flagBridges = LambdaMetafactory.FLAG_BRIDGES;
    }
}

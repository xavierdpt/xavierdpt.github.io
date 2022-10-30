package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.Scaffolded;
import net.xdexamples.support.internal.BaseExample;

import java.lang.invoke.SerializedLambda;


@Scaffolded
public class SerializedLambdaExample extends BaseExample<SerializedLambda> {
    @Override
    public void scaffold(SerializedLambda instance) {
        Class<?> capturingClass = null;
        String functionalInterfaceClass = null;
        String functionalInterfaceMethodName = null;
        String functionalInterfaceMethodSignature = null;
        int implMethodKind = 0;
        String implClass = null;
        String implMethodName = null;
        String implMethodSignature = null;
        String instantiatedMethodType = null;
        Object[] capturedArgs = new Object[0];
        ignore(
                new SerializedLambda(
                        capturingClass,
                        functionalInterfaceClass,
                        functionalInterfaceMethodName,
                        functionalInterfaceMethodSignature,
                        implMethodKind,
                        implClass,
                        implMethodName,
                        implMethodSignature,
                        instantiatedMethodType,
                        capturedArgs
                )
        );

        String capturingClass1 = instance.getCapturingClass();
        String functionalInterfaceClass1 = instance.getFunctionalInterfaceClass();
        String functionalInterfaceMethodName1 = instance.getFunctionalInterfaceMethodName();
        String functionalInterfaceMethodSignature1 = instance.getFunctionalInterfaceMethodSignature();
        String implClass1 = instance.getImplClass();
        String implMethodName1 = instance.getImplMethodName();
        String implMethodSignature1 = instance.getImplMethodSignature();
        int implMethodKind1 = instance.getImplMethodKind();
        String instantiatedMethodType1 = instance.getInstantiatedMethodType();
        int capturedArgCount = instance.getCapturedArgCount();
        int index = 0;
        Object capturedArg = instance.getCapturedArg(index);
        String s = instance.toString();
    }

}

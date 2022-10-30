package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Member;

@Scaffolded
public class MethodHandleInfoExample extends BaseExample<MethodHandleInfo> {
    @Override
    public void scaffold(MethodHandleInfo instance) {

        int referenceKind = instance.getReferenceKind();

        Class<?> declaringClass = instance.getDeclaringClass();

        String name = instance.getName();

        MethodType methodType = instance.getMethodType();

        Class<DummyMember> expected = null;
        MethodHandles.Lookup lookup = null;
        DummyMember dummyMember = instance.reflectAs(expected, lookup);

        int modifiers = instance.getModifiers();

        boolean varArgs = instance.isVarArgs();

        String s = MethodHandleInfo.referenceKindToString(referenceKind);

        String s1 = instance.toString();

        int ref_getField = MethodHandleInfo.REF_getField;
        int ref_getStatic = MethodHandleInfo.REF_getStatic;
        int ref_putField = MethodHandleInfo.REF_putField;
        int ref_putStatic = MethodHandleInfo.REF_putStatic;
        int ref_invokeVirtual = MethodHandleInfo.REF_invokeVirtual;
        int ref_invokeStatic = MethodHandleInfo.REF_invokeStatic;
        int ref_invokeSpecial = MethodHandleInfo.REF_invokeSpecial;
        int ref_newInvokeSpecial = MethodHandleInfo.REF_newInvokeSpecial;
        int ref_invokeInterface = MethodHandleInfo.REF_invokeInterface;
    }

    public interface DummyMember extends Member {
    }
}

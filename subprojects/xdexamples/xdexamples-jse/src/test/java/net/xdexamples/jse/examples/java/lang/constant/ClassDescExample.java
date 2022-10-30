package net.xdexamples.jse.examples.java.lang.constant;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.lang.constant.ClassDesc;

@Scaffolded
public class ClassDescExample extends BaseExample<ClassDesc> {
    @Override
    public void scaffold(ClassDesc instance) {

        String name = null;
        ClassDesc of = ClassDesc.of(name);

        String packageName = null;
        String className = null;
        ClassDesc of1 = ClassDesc.of(packageName, className);

        String descriptor = null;
        ClassDesc classDesc = ClassDesc.ofDescriptor(descriptor);

        ClassDesc classDesc1 = instance.arrayType();

        int rank = 0;
        ClassDesc classDesc2 = instance.arrayType(rank);

        String nestedName = null;
        ClassDesc nested = instance.nested(nestedName);

        String firstNestedName = null;
        String moreNames = null;
        ClassDesc nested1 = instance.nested(firstNestedName, moreNames);

        boolean array = instance.isArray();
        boolean primitive = instance.isPrimitive();
        boolean classOrInterface = instance.isClassOrInterface();
        ClassDesc classDesc3 = instance.componentType();
        String s = instance.packageName();
        String s1 = instance.displayName();
        String s2 = instance.descriptorString();
        ClassDesc other = null;
        instance.equals(other);

    }
}

package net.xdexamples.jse.examples.java.lang.invoke;

import net.xdexamples.support.internal.BaseExample;

import java.lang.invoke.TypeDescriptor;

public class TypeDescriptorExample extends BaseExample<TypeDescriptor> {
    @Override
    public void scaffold(TypeDescriptor instance) {
        String s = instance.descriptorString();
    }
}

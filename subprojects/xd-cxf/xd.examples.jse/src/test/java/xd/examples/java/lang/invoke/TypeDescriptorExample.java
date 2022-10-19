package xd.examples.java.lang.invoke;

import xd.BaseExample;

import java.lang.invoke.TypeDescriptor;

public class TypeDescriptorExample extends BaseExample<TypeDescriptor> {
    @Override
    public void scaffold(TypeDescriptor instance) {
        String s = instance.descriptorString();
    }
}

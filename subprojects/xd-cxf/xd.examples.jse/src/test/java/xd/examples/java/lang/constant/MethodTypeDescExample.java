package xd.examples.java.lang.constant;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.util.List;

@Scaffolded
public class MethodTypeDescExample extends BaseExample<MethodTypeDesc> {
    @Override
    public void scaffold(MethodTypeDesc instance) {

        String descriptor = null;
        MethodTypeDesc methodTypeDesc = MethodTypeDesc.ofDescriptor(descriptor);

        ClassDesc returnDesc = null;
        ClassDesc[] paramDescs = new ClassDesc[0];
        MethodTypeDesc of = MethodTypeDesc.of(returnDesc, paramDescs);

        ClassDesc classDesc = instance.returnType();

        int i = instance.parameterCount();
        int index = 0;
        ClassDesc classDesc1 = instance.parameterType(index);
        List<ClassDesc> classDescs = instance.parameterList();
        ClassDesc[] classDescs1 = instance.parameterArray();
        ClassDesc returnType = null;
        MethodTypeDesc methodTypeDesc1 = instance.changeReturnType(returnType);
        ClassDesc paramType = null;
        MethodTypeDesc methodTypeDesc2 = instance.changeParameterType(index, paramType);
        int start = 0;
        int end = 0;
        MethodTypeDesc methodTypeDesc3 = instance.dropParameterTypes(start, end);
        int pos = 0;
        ClassDesc[] paramTypes = new ClassDesc[0];
        MethodTypeDesc methodTypeDesc4 = instance.insertParameterTypes(pos, paramTypes);
        String s = instance.descriptorString();
        String s1 = instance.displayDescriptor();
        MethodTypeDesc other = null;
        boolean equals = instance.equals(other);
    }
}

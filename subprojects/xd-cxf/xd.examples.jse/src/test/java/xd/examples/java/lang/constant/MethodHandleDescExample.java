package xd.examples.java.lang.constant;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.constant.ClassDesc;
import java.lang.constant.DirectMethodHandleDesc;
import java.lang.constant.MethodHandleDesc;
import java.lang.constant.MethodTypeDesc;

@Scaffolded
public class MethodHandleDescExample extends BaseExample<MethodHandleDesc> {
    @Override
    public void scaffold(MethodHandleDesc instance) {
        DirectMethodHandleDesc.Kind kind = null;
        ClassDesc owner = null;
        String name = null;
        String lookupDescriptor = null;
        DirectMethodHandleDesc of = MethodHandleDesc.of(kind, owner, name, lookupDescriptor);

        MethodTypeDesc lookupMethodType = null;
        DirectMethodHandleDesc directMethodHandleDesc = MethodHandleDesc.ofMethod(kind, owner, name, lookupMethodType);

        String fieldName = null;
        ClassDesc fieldType = null;
        DirectMethodHandleDesc directMethodHandleDesc1 = MethodHandleDesc.ofField(kind, owner, fieldName, fieldType);


        ClassDesc[] paramTypes = new ClassDesc[0];
        DirectMethodHandleDesc directMethodHandleDesc2 = MethodHandleDesc.ofConstructor(owner, paramTypes);

        MethodTypeDesc type = null;
        MethodHandleDesc methodHandleDesc = instance.asType(type);

        MethodTypeDesc methodTypeDesc = instance.invocationType();

        MethodHandleDesc other = null;
        boolean equals = instance.equals(other);
    }
}

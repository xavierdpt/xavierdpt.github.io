package xd.examples.java.lang.invoke;

import xd.BaseExample;
import xdtest.Scaffolded;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleProxies;

@Scaffolded
public class MethodHandleProxiesExample extends BaseExample<MethodHandleProxies> {

    @Override
    public void scaffold(MethodHandleProxies instance) {

        Class<DummyInterface> interfaceClass = null;
        MethodHandle methodHandle = null;
        DummyInterface dummyInterface = MethodHandleProxies.asInterfaceInstance(interfaceClass, methodHandle);

        Object object = null;
        boolean wrapperInstance = MethodHandleProxies.isWrapperInstance(object);

        MethodHandle methodHandle1 = MethodHandleProxies.wrapperInstanceTarget(object);

        Class<?> aClass = MethodHandleProxies.wrapperInstanceType(object);
    }

    public interface DummyInterface {
    }
}

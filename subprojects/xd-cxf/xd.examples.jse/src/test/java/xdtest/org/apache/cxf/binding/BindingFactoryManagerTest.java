package xdtest.org.apache.cxf.binding;

import org.apache.cxf.BusException;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.junit.Test;

public class BindingFactoryManagerTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException, BusException {
        BindingFactoryManager instance = BindingFactoryManager.class.newInstance();
        String name = null;
        BindingFactory binding = null;
        instance.registerBindingFactory(name, binding);
        instance.unregisterBindingFactory(name);
        BindingFactory bindingFactory = instance.getBindingFactory(name);
    }
}

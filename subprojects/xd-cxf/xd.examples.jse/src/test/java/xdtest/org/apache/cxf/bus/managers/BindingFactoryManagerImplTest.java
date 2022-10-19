package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.BindingFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.bus.managers.BindingFactoryManagerImpl;
import org.junit.Assert;
import org.junit.Test;

public class BindingFactoryManagerImplTest {

    @Test
    public void test() {
        Bus bus = BusFactory.getDefaultBus();
        BindingFactoryManager bindingFactoryManager = bus.getExtension(BindingFactoryManager.class);
        Assert.assertEquals(BindingFactoryManagerImpl.class,bindingFactoryManager.getClass());
    }

    public void scaffold() throws BusException {
        BindingFactoryManagerImpl instance = new BindingFactoryManagerImpl();

        Bus b = null;
        BindingFactoryManagerImpl bindingFactoryManager = new BindingFactoryManagerImpl(b);

        instance.setBus(b);
        String name = null;
        BindingFactory factory = null;
        instance.registerBindingFactory(name,factory);
        instance.unregisterBindingFactory(name);
        String namespace = null;
        BindingFactory bindingFactory = instance.getBindingFactory(namespace);



    }
}

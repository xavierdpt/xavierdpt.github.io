package xdtest.org.apache.cxf.service.factory;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.service.factory.AnnotationsFactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListener;
import org.apache.cxf.service.factory.FactoryBeanListenerManager;
import org.apache.cxf.service.factory.OldLoggingFactoryBeanListener;
import org.junit.Assert;
import org.junit.Test;
import xdtest.TestUtils;

import java.util.Collection;
import java.util.List;

public class FactoryBeanListenerManagerTest {
    @Test
    public void test() {
        Bus bus = BusFactory.getDefaultBus();
        ExtensionManager extensionManager = bus.getExtension(ExtensionManager.class);
        ExtensionManagerImpl extensionManagerImpl = (ExtensionManagerImpl) extensionManager;

        Collection<? extends FactoryBeanListenerManager> beans = extensionManagerImpl.getBeansOfType(FactoryBeanListenerManager.class);
        Assert.assertEquals(1, beans.size());

        FactoryBeanListenerManager instance = beans.iterator().next();
        List<FactoryBeanListener> listeners = instance.getListeners();
        Assert.assertEquals(2, listeners.size());

        TestUtils.assertContainsOfClass(listeners, AnnotationsFactoryBeanListener.class);
        TestUtils.assertContainsOfClass(listeners, OldLoggingFactoryBeanListener.class);

    }

    public void scaffold() {

        FactoryBeanListenerManager instance = new FactoryBeanListenerManager();

        Bus bus = null;
        FactoryBeanListenerManager factoryBeanListenerManager = new FactoryBeanListenerManager(bus);

        instance.setBus(bus);

        List<FactoryBeanListener> listeners = instance.getListeners();

        FactoryBeanListener listener = null;
        instance.addListener(listener);
        instance.removeListener(listener);


    }
}


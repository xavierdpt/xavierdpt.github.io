package xdtest.org.apache.cxf.bus.extension;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.bus.managers.BindingFactoryManagerImpl;
import org.apache.cxf.bus.managers.CXFBusLifeCycleManager;
import org.apache.cxf.bus.managers.ConduitInitiatorManagerImpl;
import org.apache.cxf.bus.managers.DestinationFactoryManagerImpl;
import org.apache.cxf.bus.managers.ServerRegistryImpl;
import org.apache.cxf.buslifecycle.BusLifeCycleManager;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.configuration.Configurer;
import org.apache.cxf.configuration.NullConfigurer;
import org.apache.cxf.endpoint.ServerRegistry;
import org.apache.cxf.feature.Feature;
import org.apache.cxf.resource.DefaultResourceManager;
import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.apache.cxf.transport.DestinationFactoryManager;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

import static org.apache.cxf.common.util.StringUtils.notEmpty;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ExtensionManagerBusTest {

    private Bus bus;

    @Before
    public void before() {
        bus = BusFactory.getDefaultBus();
        assertEquals(ExtensionManagerBus.class, bus.getClass());
    }

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {

        String id = bus.getId();
        assertTrue(notEmpty().test(id));
        System.out.println("Bus id: "+id);

        assertEquals(Bus.BusState.RUNNING,bus.getState());

        assertEquals(3,bus.getProperties().size());
        assertEquals(bus, bus.getProperty(Bus.DEFAULT_BUS_ID));
        assertEquals(bus, bus.getProperty(ExtensionManagerBus.BUS_PROPERTY_NAME));
        assertEquals("bus", bus.getProperty("org.apache.cxf.bus.id"));

        assertEquals(0,bus.getFeatures().size());

        assertEquals(ConduitInitiatorManagerImpl.class, bus.getExtension(ConduitInitiatorManager.class).getClass());
        assertEquals(BindingFactoryManagerImpl.class, bus.getExtension(BindingFactoryManager.class).getClass());
        assertEquals(ExtensionManagerImpl.class, bus.getExtension(ConfiguredBeanLocator.class).getClass());
        assertEquals(DestinationFactoryManagerImpl.class, bus.getExtension(DestinationFactoryManager.class).getClass());
        assertEquals(CXFBusLifeCycleManager.class, bus.getExtension(BusLifeCycleManager.class).getClass());
        assertEquals(ServerRegistryImpl.class, bus.getExtension(ServerRegistry.class).getClass());
        assertEquals(DefaultResourceManager.class, bus.getExtension(ResourceManager.class).getClass());
        assertEquals(ExtensionManagerImpl.class, bus.getExtension(ExtensionManager.class).getClass());
        assertEquals(NullConfigurer.class, bus.getExtension(Configurer.class).getClass());

    }

    public void scaffold() {
        String busPropertyName = ExtensionManagerBus.BUS_PROPERTY_NAME;
        Map<Class<?>, Object> extensions = null;
        Map<String, Object> props = null;
        ClassLoader extensionClassLoader = null;
        Map<Class<?>, Object> e = null;
        Map<String, Object> properties = null;
        String i = null;
        String name = null;
        boolean wait = false;
        String s = null;
        Object o = null;
        Map<String, Object> properties1 = null;
        Collection<? extends Feature> features = null;

        ExtensionManagerBus instance = new ExtensionManagerBus(extensions, props, extensionClassLoader);
        ExtensionManagerBus extensionManagerBus = new ExtensionManagerBus(e, properties);
        ExtensionManagerBus extensionManagerBus1 = new ExtensionManagerBus(e);
        ExtensionManagerBus extensionManagerBus2 = new ExtensionManagerBus();
        instance.setId(i);

        boolean b = instance.hasExtensionByName(name);
        instance.setExtension(new Dummy(), Dummy.class);
        instance.initialize();
        instance.shutdown();
        instance.shutdown(wait);

        instance.setFeatures(features);
        instance.setProperties(properties1);
        instance.setProperty(s, o);
    }

    public static class Dummy {

    }
}

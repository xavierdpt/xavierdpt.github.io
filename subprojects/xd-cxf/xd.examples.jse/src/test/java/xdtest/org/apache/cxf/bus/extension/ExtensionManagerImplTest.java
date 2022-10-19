package xdtest.org.apache.cxf.bus.extension;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.extension.Extension;
import org.apache.cxf.bus.extension.ExtensionManager;
import org.apache.cxf.bus.extension.ExtensionManagerImpl;
import org.apache.cxf.buslifecycle.BusLifeCycleManager;
import org.apache.cxf.catalog.OASISCatalogManager;
import org.apache.cxf.common.spi.ClassLoaderService;
import org.apache.cxf.common.util.ASMHelper;
import org.apache.cxf.configuration.ConfiguredBeanLocator;
import org.apache.cxf.endpoint.ClientLifeCycleManager;
import org.apache.cxf.endpoint.EndpointResolverRegistry;
import org.apache.cxf.endpoint.ServerLifeCycleManager;
import org.apache.cxf.endpoint.ServerRegistry;
import org.apache.cxf.headers.HeaderManager;
import org.apache.cxf.phase.PhaseManager;

import org.apache.cxf.resource.ResourceManager;
import org.apache.cxf.service.factory.FactoryBeanListenerManager;
import org.apache.cxf.workqueue.WorkQueueManager;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ExtensionManagerImplTest {

    @Test
    public void test() {
        Bus bus = BusFactory.getDefaultBus();
        ExtensionManager extensionManager = bus.getExtension(ExtensionManager.class);
        Assert.assertEquals(ExtensionManagerImpl.class, extensionManager.getClass());

        ExtensionManagerImpl impl = (ExtensionManagerImpl) extensionManager;

        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.service.factory.FactoryBeanListenerManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.catalog.OASISCatalogManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.endpoint.ClientLifeCycleManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.buslifecycle.BusLifeCycleManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.phase.PhaseManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.resource.ResourceManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.headers.HeaderManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.common.util.ASMHelper"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.common.spi.ClassLoaderService"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.endpoint.EndpointResolverRegistry"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.endpoint.ServerLifeCycleManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.workqueue.WorkQueueManager"));
        Assert.assertTrue(impl.hasBeanOfName("org.apache.cxf.endpoint.ServerRegistry"));

        Assert.assertEquals(1, impl.getBeansOfType(FactoryBeanListenerManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(OASISCatalogManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(ClientLifeCycleManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(BusLifeCycleManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(PhaseManager.class).size());
        Assert.assertEquals(0, impl.getBeansOfType(ResourceManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(HeaderManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(ASMHelper.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(ClassLoaderService.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(EndpointResolverRegistry.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(ServerLifeCycleManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(WorkQueueManager.class).size());
        Assert.assertEquals(1, impl.getBeansOfType(ServerRegistry.class).size());


    }

    public void scaffold() {
        String extensionmanagerPropertyName = ExtensionManagerImpl.EXTENSIONMANAGER_PROPERTY_NAME;
        String activationNamespacesPropertyName = ExtensionManagerImpl.ACTIVATION_NAMESPACES_PROPERTY_NAME;
        String activationNamespacesSetterMethodName = ExtensionManagerImpl.ACTIVATION_NAMESPACES_SETTER_METHOD_NAME;
        String busExtensionResource = ExtensionManagerImpl.BUS_EXTENSION_RESOURCE;

        ClassLoader cl = null;
        Map<Class<?>, Object> initialExtensions = null;
        ResourceManager rm = null;
        Bus b = null;
        ExtensionManagerImpl instance = new ExtensionManagerImpl(cl, initialExtensions, rm, b);

        String resource = null;
        ExtensionManagerImpl extensionManager = new ExtensionManagerImpl(resource, cl, initialExtensions, rm, b);

        String[] resources = new String[0];
        ExtensionManagerImpl extensionManager1 = new ExtensionManagerImpl(resources, cl, initialExtensions, rm, b);

        Extension ex = null;
        instance.add(ex);

        instance.initialize();

        List<String> names = null;
        instance.removeBeansOfNames(names);

        instance.activateAll();

        Class<?> type = null;
        instance.activateAllByType(type);

        String name = null;

        Object extension = instance.getExtension(name, type);

        List<String> beanNamesOfType = instance.getBeanNamesOfType(type);

        Object beanOfType = instance.getBeanOfType(name, type);

        Collection<?> beansOfType = instance.getBeansOfType(type);

        ConfiguredBeanLocator.BeanLoaderListener<Dummy> listener = null;
        boolean b2 = instance.loadBeansOfType(Dummy.class, listener);


        String beanName = null;
        String propertyName = null;
        String value = null;
        boolean b3 = instance.hasConfiguredPropertyValue(beanName, propertyName, value);

        instance.destroyBeans();


    }

    public static class Dummy {

    }
}

package xdtest.org.apache.cxf.catalog;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.CXFBusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusFactoryTest {

    @Test
    public void testBusFactoryClass() {
        BusFactory busFactory = BusFactory.newInstance();
        assertEquals(CXFBusFactory.class,busFactory.getClass());
    }

    @Test
    public void testBusClass() {
        Bus bus = BusFactory.getDefaultBus();
        assertEquals(ExtensionManagerBus.class,bus.getClass());
    }

    public void scaffol() {
        String busFactoryPropertyName = BusFactory.BUS_FACTORY_PROPERTY_NAME;
        String defaultBusFactory = BusFactory.DEFAULT_BUS_FACTORY;
        BusFactory instance = new Dummy();
        Bus bus = instance.createBus();
        boolean createIfNeeded = false;
        Bus defaultBus1 = BusFactory.getDefaultBus(createIfNeeded);
        BusFactory.setDefaultBus(bus);
        BusFactory.setThreadDefaultBus(bus);
        Bus andSetThreadDefaultBus = BusFactory.getAndSetThreadDefaultBus(bus);
        Bus threadDefaultBus = BusFactory.getThreadDefaultBus();
        Bus threadDefaultBus1 = BusFactory.getThreadDefaultBus(createIfNeeded);
        BusFactory.clearDefaultBusForAnyThread(bus);
        BusFactory.possiblySetDefaultBus(bus);
        String className = null;
        BusFactory busFactory1 = BusFactory.newInstance(className);
    }

    public static class Dummy extends BusFactory {

        @Override
        public Bus createBus() {
            return null;
        }
    }
}

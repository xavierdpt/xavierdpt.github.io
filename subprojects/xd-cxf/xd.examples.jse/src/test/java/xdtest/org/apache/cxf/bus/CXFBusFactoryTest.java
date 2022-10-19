package xdtest.org.apache.cxf.bus;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.CXFBusFactory;
import org.apache.cxf.bus.extension.ExtensionManagerBus;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CXFBusFactoryTest {

    @Test
    public void test() {
        BusFactory busFactory = BusFactory.newInstance();
        assertEquals(CXFBusFactory.class,busFactory.getClass());
        Bus bus = busFactory.createBus();
        assertEquals(ExtensionManagerBus.class,bus.getClass());
    }


    public void scaffold() {
        CXFBusFactory instance = new CXFBusFactory();
        Bus bus = instance.createBus();
        Map<Class<?>, Object> e = null;
        Bus bus1 = instance.createBus(e);
        Map<String, Object> properties = null;
        Bus bus2 = instance.createBus(e, properties);
    }
}

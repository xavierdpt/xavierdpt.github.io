package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.managers.ConduitInitiatorManagerImpl;
import org.apache.cxf.transport.ConduitInitiator;
import org.apache.cxf.transport.ConduitInitiatorManager;
import org.junit.Assert;
import org.junit.Test;

public class ConduitInitiatorManagerImplTest {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {
        Bus bus = BusFactory.getDefaultBus();
        ConduitInitiatorManager conduitInitiatorManager = bus.getExtension(ConduitInitiatorManager.class);
        Assert.assertEquals(ConduitInitiatorManagerImpl.class, conduitInitiatorManager.getClass());
    }

    public void scaffold() throws BusException {
        ConduitInitiatorManagerImpl instance = new ConduitInitiatorManagerImpl();

        Bus b = null;
        ConduitInitiatorManagerImpl conduitInitiatorManager = new ConduitInitiatorManagerImpl(b);

        instance.setBus(b);

        String namespace = null;
        ConduitInitiator factory = null;
        instance.registerConduitInitiator(namespace, factory);
        instance.deregisterConduitInitiator(namespace);
        ConduitInitiator conduitInitiator = instance.getConduitInitiator(namespace);
        instance.shutdown();
        String uri = null;
        ConduitInitiator conduitInitiatorForUri = instance.getConduitInitiatorForUri(uri);


    }

}

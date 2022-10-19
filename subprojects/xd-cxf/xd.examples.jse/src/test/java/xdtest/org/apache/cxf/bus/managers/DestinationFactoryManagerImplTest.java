package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.BusException;
import org.apache.cxf.bus.managers.DestinationFactoryManagerImpl;
import org.apache.cxf.transport.DestinationFactory;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

public class DestinationFactoryManagerImplTest {
    @Test
    public void test() throws BusException {
        DestinationFactoryManagerImpl instance = new DestinationFactoryManagerImpl();

        Bus b = null;
        DestinationFactoryManagerImpl destinationFactoryManager = new DestinationFactoryManagerImpl(b);


        Map<String, DestinationFactory> destinationFactories = null;
        DestinationFactoryManagerImpl destinationFactoryManager1 = new DestinationFactoryManagerImpl(destinationFactories);

        DestinationFactoryManagerImpl destinationFactoryManager2 = new DestinationFactoryManagerImpl(destinationFactories, b);

        instance.setBus(b);

        String namespace = null;
        DestinationFactory factory = null;
        instance.registerDestinationFactory(namespace,factory);

        instance.deregisterDestinationFactory(namespace);

        DestinationFactory destinationFactory = instance.getDestinationFactory(namespace);

        String uri = null;
        DestinationFactory destinationFactoryForUri = instance.getDestinationFactoryForUri(uri);

        Set<String> registeredDestinationFactoryNames = instance.getRegisteredDestinationFactoryNames();




    }

}

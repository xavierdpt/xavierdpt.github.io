package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.ClientLifeCycleManagerImpl;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientLifeCycleListener;
import org.junit.Test;

public class ClientLifeCycleManagerImplTest {
    @Test
    public void test() {
        ClientLifeCycleManagerImpl instance = new ClientLifeCycleManagerImpl();

        Bus b = null;
        ClientLifeCycleManagerImpl clientLifeCycleManager = new ClientLifeCycleManagerImpl(b);

        Class<?> registrationType = instance.getRegistrationType();
        ClientLifeCycleListener listener = null;
        instance.registerListener(listener);
        Client client = null;
        instance.clientCreated(client);
        instance.clientDestroyed(client);
        instance.unRegisterListener(listener);



    }

}

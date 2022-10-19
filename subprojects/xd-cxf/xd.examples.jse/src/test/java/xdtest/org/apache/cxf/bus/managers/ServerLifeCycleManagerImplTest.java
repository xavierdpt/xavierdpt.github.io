package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.ServerLifeCycleManagerImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.endpoint.ServerLifeCycleListener;
import org.junit.Test;

public class ServerLifeCycleManagerImplTest {
    @Test
    public void test() {
        ServerLifeCycleManagerImpl instance = new ServerLifeCycleManagerImpl();

        Bus bus = null;
        ServerLifeCycleManagerImpl serverLifeCycleManager = new ServerLifeCycleManagerImpl(bus);

        Class<?> registrationType = instance.getRegistrationType();

        ServerLifeCycleListener listener = null;
        instance.registerListener(listener);

        Server server = null;
        instance.startServer(server);

        instance.stopServer(server);

        instance.unRegisterListener(listener);



    }

}

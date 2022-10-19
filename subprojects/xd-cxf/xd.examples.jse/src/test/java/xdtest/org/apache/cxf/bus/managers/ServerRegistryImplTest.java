package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.ServerRegistryImpl;
import org.apache.cxf.endpoint.Server;
import org.junit.Test;

import java.util.List;

public class ServerRegistryImplTest {
    @Test
    public void test() {

        ServerRegistryImpl instance = new ServerRegistryImpl();

        Bus bus = null;
        ServerRegistryImpl serverRegistry = new ServerRegistryImpl(bus);

        Bus bus1 = instance.getBus();
        instance.setBus(bus);

        Server server = null;
        instance.register(server);

        instance.unregister(server);

        List<Server> servers = instance.getServers();

        instance.initComplete();

        instance.preShutdown();

        instance.postShutdown();


    }

}

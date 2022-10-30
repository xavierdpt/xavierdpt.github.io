package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.ServiceContractResolverRegistryImpl;
import org.apache.cxf.endpoint.ServiceContractResolver;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.net.URI;

public class ServiceContractResolverRegistryImplTest {
    @Test
    public void test() {
        ServiceContractResolverRegistryImpl instance = new ServiceContractResolverRegistryImpl();
        Bus bus = null;
        ServiceContractResolverRegistryImpl serviceContractResolverRegistry = new ServiceContractResolverRegistryImpl(bus);

        instance.setBus(bus);

        QName qname = null;
        URI contractLocation = instance.getContractLocation(qname);

        ServiceContractResolver resolver = null;
        boolean registered = instance.isRegistered(resolver);

        instance.register(resolver);

        instance.unregister(resolver);



    }

}

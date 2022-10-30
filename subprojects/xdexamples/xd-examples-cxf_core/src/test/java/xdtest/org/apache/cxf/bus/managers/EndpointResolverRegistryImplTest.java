package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.EndpointResolverRegistryImpl;
import org.apache.cxf.endpoint.EndpointResolver;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.junit.Test;

import javax.xml.namespace.QName;

public class EndpointResolverRegistryImplTest {
    @Test
    public void test() {
        EndpointResolverRegistryImpl instance = new EndpointResolverRegistryImpl();

        Bus b = null;
        EndpointResolverRegistryImpl endpointResolverRegistry = new EndpointResolverRegistryImpl(b);

        instance.setBus(b);

        EndpointResolver resolver = null;
        instance.register(resolver);

        instance.unregister(resolver);

        EndpointReferenceType logical = null;
        EndpointReferenceType resolve = instance.resolve(logical);

        EndpointReferenceType physical = null;
        EndpointReferenceType renew = instance.renew(logical, physical);

        QName serviceName = null;
        EndpointReferenceType mint = instance.mint(serviceName);

        EndpointReferenceType mint1 = instance.mint(physical);



    }

}

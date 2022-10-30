package xdtest.org.apache.cxf.bus.resource;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.resource.ResourceManagerImpl;
import org.apache.cxf.resource.ResourceResolver;
import org.junit.Test;

import java.util.List;

public class ResourceManagerImplTest {
    @Test
    public void test() {

        ResourceManagerImpl instance = new ResourceManagerImpl();

        Bus bus = null;
        ResourceManagerImpl resourceManager = new ResourceManagerImpl(bus);

        List<? extends ResourceResolver> resolvers = null;
        instance.setResolvers(resolvers);

        instance.setBus(bus);

        Class<?> registrationType = instance.getRegistrationType();
    }
}

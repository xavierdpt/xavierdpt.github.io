package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.HeaderManagerImpl;
import org.apache.cxf.headers.HeaderProcessor;
import org.junit.Test;

public class HeaderManagerImplTest {
    @Test
    public void test() {
        HeaderManagerImpl instance = new HeaderManagerImpl();
        Bus b = null;
        HeaderManagerImpl headerManager = new HeaderManagerImpl(b);

        Bus bus = instance.getBus();
        instance.setBus(bus);

        String namespace = null;
        HeaderProcessor headerProcessor = instance.getHeaderProcessor(namespace);

        instance.registerHeaderProcessor(headerProcessor);

    }

}

package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.CXFBusLifeCycleManager;
import org.apache.cxf.buslifecycle.BusLifeCycleListener;
import org.junit.Test;

public class CXFBusLifeCycleManagerTest {
    @Test
    public void test() {
        CXFBusLifeCycleManager instance = new CXFBusLifeCycleManager();

        Bus b = null;
        CXFBusLifeCycleManager cxfBusLifeCycleManager = new CXFBusLifeCycleManager(b);

        instance.setBus(b);

        BusLifeCycleListener listener = null;
        instance.registerLifeCycleListener(listener);

        instance.unregisterLifeCycleListener(listener);

        instance.initComplete();
        instance.preShutdown();
        instance.postShutdown();


    }

}

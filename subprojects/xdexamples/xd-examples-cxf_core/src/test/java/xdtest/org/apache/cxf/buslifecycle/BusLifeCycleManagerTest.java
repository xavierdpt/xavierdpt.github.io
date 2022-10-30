package xdtest.org.apache.cxf.buslifecycle;

import org.apache.cxf.buslifecycle.BusLifeCycleListener;
import org.apache.cxf.buslifecycle.BusLifeCycleManager;
import org.junit.Test;

public class BusLifeCycleManagerTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        BusLifeCycleManager instance = BusLifeCycleManager.class.newInstance();
        BusLifeCycleListener listener = null;
        instance.registerLifeCycleListener(listener);
        instance.unregisterLifeCycleListener(listener);
    }
}

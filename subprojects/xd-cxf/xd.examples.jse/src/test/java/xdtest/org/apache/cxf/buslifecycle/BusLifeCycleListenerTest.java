package xdtest.org.apache.cxf.buslifecycle;

import org.apache.cxf.buslifecycle.BusLifeCycleListener;
import org.junit.Test;

public class BusLifeCycleListenerTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {

        BusLifeCycleListener instance = BusLifeCycleListener.class.newInstance();
        instance.initComplete();
        instance.preShutdown();
        instance.postShutdown();

    }

}

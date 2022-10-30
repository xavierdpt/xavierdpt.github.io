package xdtest.org.apache.cxf.buslifecycle;

import org.apache.cxf.Bus;
import org.apache.cxf.buslifecycle.BusCreationListener;
import org.junit.Test;

public class BusCreationListenerTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        BusCreationListener instance = BusCreationListener.class.newInstance();
        Bus bus = null;
        instance.busCreated(bus);

    }

}

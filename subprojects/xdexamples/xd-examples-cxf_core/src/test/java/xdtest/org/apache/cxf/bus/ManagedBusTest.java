package xdtest.org.apache.cxf.bus;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.ManagedBus;
import org.junit.Test;

import javax.management.JMException;
import javax.management.ObjectName;

public class ManagedBusTest {

    @Test
    public void test() throws JMException {
        Bus b = null;
        ManagedBus instance = new ManagedBus(b);
        boolean wait = false;
        instance.shutdown(wait);
        ObjectName objectName = instance.getObjectName();


    }
}

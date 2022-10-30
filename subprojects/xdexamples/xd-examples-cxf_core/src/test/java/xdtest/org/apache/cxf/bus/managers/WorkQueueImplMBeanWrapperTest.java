package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.bus.managers.WorkQueueImplMBeanWrapper;
import org.apache.cxf.workqueue.AutomaticWorkQueueImpl;
import org.apache.cxf.workqueue.WorkQueueManager;
import org.junit.Test;

import javax.management.JMException;
import javax.management.ObjectName;

public class WorkQueueImplMBeanWrapperTest {
    @Test
    public void test() throws JMException {
        AutomaticWorkQueueImpl wq = null;
        WorkQueueManager mgr = null;
        WorkQueueImplMBeanWrapper instance = new WorkQueueImplMBeanWrapper(wq, mgr);
        long workQueueMaxSize = instance.getWorkQueueMaxSize();
        long workQueueSize = instance.getWorkQueueSize();
        int largestPoolSize = instance.getLargestPoolSize();
        int poolSize = instance.getPoolSize();
        int activeCount = instance.getActiveCount();
        boolean empty = instance.isEmpty();
        boolean full = instance.isFull();
        int highWaterMark = instance.getHighWaterMark();
        instance.setHighWaterMark(highWaterMark);
        int lowWaterMark = instance.getLowWaterMark();
        instance.setLowWaterMark(lowWaterMark);
        ObjectName objectName = instance.getObjectName();


    }

}

package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.managers.WorkQueueManagerImpl;
import org.apache.cxf.workqueue.AutomaticWorkQueue;
import org.junit.Test;

public class WorkQueueManagerImplTest {
    @Test
    public void test() {

        String defaultQueueName = WorkQueueManagerImpl.DEFAULT_QUEUE_NAME;
        String defaultWorkqueueBeanName = WorkQueueManagerImpl.DEFAULT_WORKQUEUE_BEAN_NAME;

        WorkQueueManagerImpl instance = new WorkQueueManagerImpl();

        Bus bus = null;
        WorkQueueManagerImpl workQueueManager = new WorkQueueManagerImpl(bus);

        Bus bus1 = instance.getBus();
        instance.setBus(bus);

        AutomaticWorkQueue automaticWorkQueue = instance.getAutomaticWorkQueue();

        boolean processRemainingTasks = false;
        instance.shutdown(processRemainingTasks);

        instance.run();

        String name = null;
        AutomaticWorkQueue namedWorkQueue = instance.getNamedWorkQueue(name);

        AutomaticWorkQueue q = null;
        instance.addNamedWorkQueue(name,q);



    }

}

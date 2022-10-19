package xdtest.org.apache.cxf.bus.managers;

import org.apache.cxf.bus.managers.WorkQueueManagerImpl;
import org.apache.cxf.bus.managers.WorkQueueManagerImplMBeanWrapper;
import org.junit.Test;
import xd.ExampleUtils;

import javax.management.JMException;
import javax.management.ObjectName;

public class WorkQueueManagerImplMBeanWrapperTest {
    @Test
    public void test() throws JMException {
        if (ExampleUtils.skip()) {
            WorkQueueManagerImpl wq = null;
            WorkQueueManagerImplMBeanWrapper instance = new WorkQueueManagerImplMBeanWrapper(wq);

            boolean processRemainingWorkItems = false;
            instance.shutdown(processRemainingWorkItems);

            ObjectName objectName = instance.getObjectName();
        }
    }
}

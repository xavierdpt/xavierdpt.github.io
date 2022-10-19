package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.junit.Test;

import javax.xml.namespace.QName;

import static org.junit.Assert.assertEquals;

public class FaultInfoTest {

    public static final QName FAULT_NAME = new QName("faultName");
    public static final QName NAME = new QName("name");
    public static final QName ANOTHER_FAULT_NAME = new QName("anotherFaultName");
    public static final OperationInfo OPERATION_INFO = new OperationInfo();

    @Test
    public void test() {

        // A fault info has a fault name, a name and an associated operation
        FaultInfo instance = new FaultInfo(FAULT_NAME, NAME, OPERATION_INFO);

        // The fault name is specific to the fault info
        assertEquals(FAULT_NAME, instance.getFaultName());

        // And it can be changed
        instance.setFaultName(ANOTHER_FAULT_NAME);
        assertEquals(ANOTHER_FAULT_NAME, instance.getFaultName());

        // The other members are available from AbstractMessageContainer
        assertEquals(OPERATION_INFO, instance.getOperation());
        assertEquals(NAME, instance.getName());

    }


}

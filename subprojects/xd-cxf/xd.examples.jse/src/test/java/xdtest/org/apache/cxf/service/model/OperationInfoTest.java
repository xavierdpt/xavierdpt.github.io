package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.junit.Test;
import xdtest.TestUtils;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.List;

public class OperationInfoTest {

    @Test
    public void test() {
        TestUtils.isDone(FaultInfoTest.class);
        TestUtils.isDone(InterfaceInfoTest.class);
        TestUtils.isDone(MessageInfoTest.class);
    }

    public void scaffold() {
        OperationInfo instance = new OperationInfo();
        QName name = instance.getName();
        instance.setName(name);
        InterfaceInfo interfaceInfo = instance.getInterface();
        MessageInfo.Type type = null;
        MessageInfo message = instance.createMessage(name, type);
        MessageInfo output = instance.getOutput();
        String outputName = instance.getOutputName();
        instance.setOutput(outputName, output);
        boolean b = instance.hasOutput();
        MessageInfo input = instance.getInput();
        String inputName = instance.getInputName();
        instance.setInput(inputName, input);
        instance.hasInput();
        boolean oneWay = instance.isOneWay();
        boolean unwrappedCapable = instance.isUnwrappedCapable();
        OperationInfo unwrappedOperation = instance.getUnwrappedOperation();
        instance.setUnwrappedOperation(unwrappedOperation);
        boolean unwrapped = instance.isUnwrapped();
        QName messagef = null;
        FaultInfo faultInfo = instance.addFault(name, messagef);
        FaultInfo fault = null;
        instance.addFault(fault);
        instance.removeFault(name);
        FaultInfo fault1 = instance.getFault(name);
        boolean b1 = instance.hasFaults();
        Collection<FaultInfo> faults = instance.getFaults();
        List<String> o = null;
        instance.setParameterOrdering(o);
        List<String> parameterOrdering = instance.getParameterOrdering();
        String s = instance.toString();
        int i = instance.hashCode();
        OperationInfo other = null;
        boolean equals = instance.equals(other);


    }
}

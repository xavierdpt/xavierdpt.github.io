package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.junit.Test;
import xdtest.TestUtils;

import javax.xml.namespace.QName;

public class MessageInfoTest {

    @Test
    public void test() {
        TestUtils.isDone(OperationInfoTest.class);
    }

    public void scaffold() {
        OperationInfo op = null;
        MessageInfo.Type type = null;
        QName name = null;
        new MessageInfo(op, type, name);
    }
}

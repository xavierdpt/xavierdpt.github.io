package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;

import javax.xml.namespace.QName;

public class MessageInfoTest {



    public void scaffold() {
        OperationInfo op = null;
        MessageInfo.Type type = null;
        QName name = null;
        new MessageInfo(op, type, name);
    }
}

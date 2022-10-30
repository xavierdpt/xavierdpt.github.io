package xdtest.org.apache.cxf.service.model;

import org.apache.cxf.service.model.AbstractMessageContainer;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.junit.Test;

import javax.xml.namespace.QName;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AbstractMessageContainerTest {

    public static final String DOCUMENTATION = "documentation";
    public static final QName NAME = new QName("name");
    public static final OperationInfo OPERATION_INFO = new OperationInfo();
    private AbstractMessageContainer instance;

    @Test
    public void test() {
        QName faultName = new QName("faultName");
        instance = new FaultInfo(faultName, NAME, OPERATION_INFO);

        instance.setMessageDocumentation(DOCUMENTATION);
        assertEquals(instance.getMessageDocumentation(), DOCUMENTATION);

        assertEquals(instance.getName(), NAME);
        assertEquals(instance.getOperation(), OPERATION_INFO);

    }

    public void scaffold() {



        QName messagePartQName = new QName("messagePartQName");
        MessagePartInfo messagePartInfo = instance.addMessagePart(messagePartQName);

        MessagePartInfo messagePart = instance.getMessagePart(messagePartQName);

        MessagePartInfo messagePartName = instance.addMessagePart("messagePartName");

        instance.addMessagePart(messagePartInfo);

        instance.getMessagePartIndex(messagePartInfo);

        MessagePartInfo messagePartByIndex = instance.getMessagePartByIndex(0);

        instance.removeMessagePart(messagePartQName);

        MessagePartInfo messagePart1 = instance.getMessagePart(messagePartQName);

        MessagePartInfo messagePart2 = instance.getMessagePart(0);

        MessagePartInfo messagePartInfo1 = instance.addOutOfBandMessagePart(new QName(""));

        List<MessagePartInfo> messageParts = instance.getMessageParts();

        int messagePartsNumber = instance.getMessagePartsNumber();

        MessagePartInfo firstMessagePart = instance.getFirstMessagePart();

        List<MessagePartInfo> outOfBandParts = instance.getOutOfBandParts();

        int size = instance.size();


    }


}

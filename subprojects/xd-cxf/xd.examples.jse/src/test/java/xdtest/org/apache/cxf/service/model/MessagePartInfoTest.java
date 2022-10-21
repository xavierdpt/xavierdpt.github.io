package xdtest.org.apache.cxf.service.model;

import net.xdexamples.Done;
import org.apache.cxf.service.model.AbstractMessageContainer;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAnnotated;
import org.junit.Test;

import javax.xml.namespace.QName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Done
public class MessagePartInfoTest {

    public static final QName NAME = new QName("name");
    public static final QName FAULT_NAME = new QName("faultName");
    public static final QName CONTAINER_NAME = new QName("containerName");
    public static final OperationInfo OPERATION_INFO = new OperationInfo();
    public static final AbstractMessageContainer CONTAINER = new FaultInfo(FAULT_NAME, CONTAINER_NAME, OPERATION_INFO);
    public static final QName NEW_NAME = new QName("newName");
    public static final QName CONCRETE_NAME = new QName("concreteName");
    public static final QName ELEMENT_Q_NAME = new QName("elementQName");
    public static final OperationInfo OPERATION_INFO_2 = new OperationInfo();
    public static final QName FAULT_NAME_2 = new QName("faultName2");
    public static final QName NAME_2 = new QName("name2");
    public static final AbstractMessageContainer NEW_CONTAINER = new FaultInfo(FAULT_NAME_2, NAME_2, OPERATION_INFO_2);
    public static final QName TYPE_QNAME = new QName("typeQName");
    public static final int INDEX = 1;
    public static final Class<Dummy> TYPE_CLASS = Dummy.class;
    public static final XmlSchemaAnnotated XML_SCHEMA = new XmlSchema();
    private MessagePartInfo instance;

    @Test
    public void test() {
        instance = new MessagePartInfo(NAME, CONTAINER);

        assertEquals(NAME, instance.getName());
        assertEquals(CONTAINER, instance.getMessageInfo());

        instance.setName(NEW_NAME);
        assertEquals(NEW_NAME, instance.getName());

        instance.setMessageContainer(NEW_CONTAINER);
        assertEquals(NEW_CONTAINER, instance.getMessageInfo());

        instance.setConcreteName(CONCRETE_NAME);
        assertEquals(CONCRETE_NAME, instance.getConcreteName());

        instance.setElement(false);
        assertFalse(instance.isElement());

        instance.setElement(true);
        assertTrue(instance.isElement());

        instance.setElementQName(ELEMENT_Q_NAME);
        assertTrue(instance.isElement());
        assertEquals(ELEMENT_Q_NAME, instance.getElementQName());
        assertEquals(ELEMENT_Q_NAME, instance.getConcreteName());

        instance.setConcreteName(null);
        instance.setTypeQName(TYPE_QNAME);
        assertFalse(instance.isElement());
        assertEquals(TYPE_QNAME, instance.getTypeQName());
        assertEquals(NEW_NAME, instance.getConcreteName());

        instance.setIndex(INDEX);
        assertEquals(INDEX, instance.getIndex());

        instance.setTypeClass(TYPE_CLASS);
        assertEquals(TYPE_CLASS, instance.getTypeClass());

        instance.setXmlSchema(XML_SCHEMA);
        assertEquals(XML_SCHEMA, instance.getXmlSchema());

        assertEquals("[MessagePartInfo name=newName, ConcreteName=newName", instance.toString());

    }

    public static class Dummy {

    }
}

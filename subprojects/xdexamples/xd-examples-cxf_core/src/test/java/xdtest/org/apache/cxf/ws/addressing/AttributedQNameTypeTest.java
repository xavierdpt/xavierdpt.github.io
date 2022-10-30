package xdtest.org.apache.cxf.ws.addressing;

import org.apache.cxf.ws.addressing.AttributedQNameType;
import org.junit.Test;

import javax.xml.namespace.QName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class AttributedQNameTypeTest {

    public static final QName VALUE = new QName("value");
    public static final QName ATTRIBUTE_NAME = new QName("attributeName");
    public static final String ATTRIBUTE_VALUE = "attributeValue";

    @Test
    public void test() {

        // This has a qualified name and holds string attributes that are idenfied by qualified names
        // And that's all

        AttributedQNameType instance = new AttributedQNameType();

        assertNull(instance.getValue());
        assertTrue(instance.getOtherAttributes().isEmpty());

        instance.setValue(VALUE);
        assertEquals(VALUE, instance.getValue());

        instance.getOtherAttributes().put(ATTRIBUTE_NAME, ATTRIBUTE_VALUE);
        assertEquals(ATTRIBUTE_VALUE, instance.getOtherAttributes().get(ATTRIBUTE_NAME));
    }
}

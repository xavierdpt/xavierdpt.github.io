package xdtest.org.apache.cxf.ws.addressing;

import org.apache.cxf.ws.addressing.RelatesToType;
import org.junit.Test;
import net.xdexamples.Done;

import javax.xml.namespace.QName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@Done
public class RelatesToTypeTest {

    public static final String DEFAULT_RELATIONSHIP_TYPE = "http://www.w3.org/2005/08/addressing/reply";
    public static final String VALUE = "value";
    public static final QName ATTRIBUTE_KEY = new QName("attributeKey");
    public static final String ATTRIBUTE_VALUE = "attributeValue";
    public static final String ANOTHER_RELATIONSHIP_TYPE = "anotherRelationshipType";

    @Test
    public void test() {

        RelatesToType instance = new RelatesToType();

        // No name, no attributes, default relationship type
        assertNull(instance.getValue());
        assertTrue(instance.getOtherAttributes().isEmpty());
        assertEquals(DEFAULT_RELATIONSHIP_TYPE, instance.getRelationshipType());

        // Value can be set
        instance.setValue(VALUE);
        assertEquals(VALUE, instance.getValue());

        // Attributes can be added and removed
        instance.getOtherAttributes().put(ATTRIBUTE_KEY, ATTRIBUTE_VALUE);
        assertEquals(ATTRIBUTE_VALUE, instance.getOtherAttributes().get(ATTRIBUTE_KEY));

        // Relationship type can be modified
        instance.setRelationshipType(ANOTHER_RELATIONSHIP_TYPE);
        assertEquals(ANOTHER_RELATIONSHIP_TYPE,instance.getRelationshipType());

        // That simply sets the relationship type to null
        // The default value is handled in the getter
        instance.unsetRelationshipType();
        assertEquals(DEFAULT_RELATIONSHIP_TYPE, instance.getRelationshipType());

    }
}

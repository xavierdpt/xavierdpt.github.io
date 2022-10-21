package xdtest.org.apache.cxf.resource;

import org.apache.cxf.resource.PropertiesResolver;
import org.junit.Test;
import net.xdexamples.Done;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

@Done
public class PropertiesResolverTest {

    public static final String ANY = "any";
    public static final Dummy1 DUMMY1 = new Dummy1();
    public static final String RESOURCE_NAME = "resourceName";
    public static final Class<Object> ANY_CLASS = Object.class;
    public static final Class<Dummy1> DUMMY1_CLASS = Dummy1.class;
    public static final Class<Dummy2> DUMMY2_CLASS = Dummy2.class;

    @Test
    public void test() {

        Map<String, Object> properties = new HashMap<>();
        properties.put(RESOURCE_NAME, DUMMY1);

        // The resolver is initialized with some String->Object properties
        PropertiesResolver instance = new PropertiesResolver(properties);

        // No streams
        assertNull(instance.getAsStream(ANY));

        {
            // Null name => null value
            Object value = instance.resolve(null, ANY_CLASS);
            assertNull(value);
        }
        {
            // Correct class name => corresponding value
            Dummy1 value = instance.resolve(RESOURCE_NAME, DUMMY1_CLASS);
            assertEquals(DUMMY1, value);
        }
        {
            // Name that not exist => null value of the requested type
            Dummy1 value = instance.resolve("missing", DUMMY1_CLASS);
            assertNull(value);
        }
        {
            // Incompatible requeted type => class cast exception
            assertThrows(ClassCastException.class, () ->
                    instance.resolve(RESOURCE_NAME, DUMMY2_CLASS));
        }


    }

    public static class Dummy1 {

    }

    public static class Dummy2 {

    }
}

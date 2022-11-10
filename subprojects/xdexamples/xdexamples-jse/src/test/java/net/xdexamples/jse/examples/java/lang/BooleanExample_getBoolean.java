package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.support.ExampleSupport;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BooleanExample_getBoolean {

    @Test
    public void example() throws Throwable {

        // This method parses a string property as a boolean

        {
            // null property name is false
            String propertyName = null;
            boolean value = Boolean.getBoolean(propertyName);
            assertFalse(value);
        }

        {
            // default value is false
            String propertyName = "example";
            assertNull(System.getProperty(propertyName));
            boolean value = Boolean.getBoolean(propertyName);
            assertFalse(value);
        }

        {
            // when the proerty is set to "true" (in lowercase, uppercase or mixed case)
            // the returned value is true
            ExampleSupport.withSystemProperty("example", "true", () -> {
                String propertyName = "example";
                boolean value = Boolean.getBoolean(propertyName);
                assertTrue(value);
            });
        }
    }

}

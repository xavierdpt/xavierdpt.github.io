package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.BaseExample;
import net.xdexamples.Done;
import net.xdexamples.ExampleUtils;
import net.xdexamples.jse.examples.java.lang.constant.ConstableExample;
import org.junit.Test;

import java.lang.constant.DynamicConstantDesc;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

@Done
public class BooleanExample extends BaseExample<Boolean> {


    @Override
    @SuppressWarnings("unused")
    protected void scaffold(Boolean instance) {

        {
            String string = any();
            boolean result = Boolean.parseBoolean(string);
            seeExamples(this::parseBooleanExample);
        }

        {
            boolean value = instance.booleanValue();
            seeExamples(this::booleanValueExample);
        }

        {
            boolean value = false;
            Boolean b = Boolean.valueOf(value);
            seeExamples(this::valueOfBooleanExample);
        }

        {
            String string = any();
            Boolean result = Boolean.valueOf(string);
            seeExamples(this::valueOfStringExample);
        }

        {
            String string = instance.toString();
            seeExamples(this::toStringExample);
        }

        {
            boolean value = false;
            String string = Boolean.toString(value);
            seeExamples(this::toStringStaticExample);
        }

        {
            int result = instance.hashCode();
            seeExamples(this::hashCodeExample);
        }

        {
            boolean value = false;
            int result = Boolean.hashCode(value);
            seeExamples(this::hashCodeStaticExample);
        }

        {
            Boolean other = any();
            boolean result = instance.equals(other);
            seeExamples(this::equalsExample);
        }

        {
            String string = any();
            boolean result = Boolean.getBoolean(string);
            seeExamples(this::getBooleanExample);
        }

        {
            Boolean other = any();
            int result = instance.compareTo(other);
            seeOthers(ComparableExample.class);
        }

        {
            boolean value1 = false;
            boolean value2 = false;
            int result = Boolean.compare(value1, value2);
            seeExamples(this::compareExample);
        }

        {
            boolean value1 = false;
            boolean value2 = false;
            boolean result = Boolean.logicalAnd(value1, value2);
            seeExamples(this::logicAndExample);
        }


        {
            boolean value1 = false;
            boolean value2 = false;
            boolean result = Boolean.logicalOr(value1, value2);
            seeExamples(this::logicOrExample);
        }

        {
            boolean value1 = false;
            boolean value2 = false;
            boolean result = Boolean.logicalXor(value1, value2);
            seeExamples(this::logicXorExample);
        }

        {
            Optional<DynamicConstantDesc<Boolean>> result = instance.describeConstable();
            seeOthers(ConstableExample.class);

        }

        {
            Boolean b = Boolean.TRUE;
            seeExamples(this::booleanValueExample);
        }

        {
            Boolean b = Boolean.FALSE;
            seeExamples(this::booleanValueExample);
        }

        {
            Class<Boolean> clazz = Boolean.TYPE;
            seeExamples(this::typeExample);
        }

    }

    @Test
    public void parseBooleanExample() {
        {
            String input = "true";
            boolean value = Boolean.parseBoolean(input);
            assertTrue(value);
        }

        {
            String input = "false";
            boolean value = Boolean.parseBoolean(input);
            assertFalse(value);
        }

        {
            String input = "TRue";
            boolean value = Boolean.parseBoolean(input);
            assertTrue(value);
        }

        {
            String input = "FAlse";
            boolean value = Boolean.parseBoolean(input);
            assertFalse(value);
        }

        {
            String input = "anything else";
            boolean value = Boolean.parseBoolean(input);
            assertFalse(value);
        }
    }

    @Test
    public void booleanValueExample() {
        {
            Boolean b = Boolean.TRUE;
            boolean value = b.booleanValue();
            assertTrue(value);
        }

        {
            Boolean b = Boolean.FALSE;
            boolean value = b.booleanValue();
            assertFalse(value);
        }
    }

    @Test
    public void valueOfBooleanExample() {
        {
            boolean value = true;
            Boolean b = Boolean.valueOf(value);
            assertSame(Boolean.TRUE, b);
        }
        {
            boolean value = false;
            Boolean b = Boolean.valueOf(value);
            assertSame(Boolean.FALSE, b);
        }
    }

    @Test
    public void valueOfStringExample() {
        {
            String value = "true";
            Boolean b = Boolean.valueOf(value);
            assertSame(Boolean.TRUE, b);
        }
        // Relies on parseBoolean
        seeExamples(this::parseBooleanExample);
    }

    @Test
    public void toStringExample() {
        {
            Boolean b = Boolean.TRUE;
            String string = b.toString();
            assertEquals("true", string);
        }
        {
            Boolean b = Boolean.FALSE;
            String string = b.toString();
            assertEquals("false", string);
        }
    }

    @Test
    public void toStringStaticExample() {
        {
            boolean value = true;
            String string = Boolean.toString(value);
            assertEquals("true", string);
        }
        {
            boolean value = false;
            String string = Boolean.toString(value);
            assertEquals("false", string);
        }
    }

    @Test
    public void hashCodeExample() {
        Boolean b1 = Boolean.TRUE;
        Boolean b2 = Boolean.FALSE;
        int hashCode1 = b1.hashCode();
        int hashCode2 = b2.hashCode();
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    public void hashCodeStaticExample() {
        boolean value1 = true;
        boolean value2 = false;
        int hashCode1 = Boolean.hashCode(value1);
        int hashCode2 = Boolean.hashCode(value2);
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    public void equalsExample() {
        Boolean b1 = Boolean.TRUE;
        Boolean b2 = Boolean.FALSE;
        assertTrue(b1.equals(b1));
        assertFalse(b1.equals(b2));
        assertFalse(b2.equals(b1));
        assertTrue(b2.equals(b2));
    }

    @Test
    public void getBooleanExample() throws Throwable {

        {
            String propertyName = null;
            boolean value = Boolean.getBoolean(propertyName);
            assertFalse(value);
        }

        {
            String propertyName = "example";
            boolean value = Boolean.getBoolean(propertyName);
            assertFalse(value);
        }

        {
            ExampleUtils.withSystemProperty("example", "true", () -> {
                String propertyName = "example";
                boolean value = Boolean.getBoolean(propertyName);
                assertTrue(value);
            });
        }

        // Relies on parseBoolean
        seeExamples(this::parseBooleanExample);

    }

    @Test
    public void compareExample() {
        {
            boolean value1 = false;
            boolean value2 = false;
            int result = Boolean.compare(value1, value2);
            assertEquals(0, result);
        }
        {
            boolean value1 = false;
            boolean value2 = true;
            int result = Boolean.compare(value1, value2);
            assertEquals(-1, result);
        }
        {
            boolean value1 = true;
            boolean value2 = false;
            int result = Boolean.compare(value1, value2);
            assertEquals(1, result);
        }
        {
            boolean value1 = true;
            boolean value2 = true;
            int result = Boolean.compare(value1, value2);
            assertEquals(0, result);
        }
    }

    @Test
    public void logicAndExample() {
        {
            boolean value1 = false;
            boolean value2 = false;
            boolean result = Boolean.logicalAnd(value1, value2);
            assertFalse(result);
        }
        {
            boolean value1 = false;
            boolean value2 = true;
            boolean result = Boolean.logicalAnd(value1, value2);
            assertFalse(result);
        }
        {
            boolean value1 = true;
            boolean value2 = false;
            boolean result = Boolean.logicalAnd(value1, value2);
            assertFalse(result);
        }
        {
            boolean value1 = true;
            boolean value2 = true;
            boolean result = Boolean.logicalAnd(value1, value2);
            assertTrue(result);
        }
    }

    @Test
    public void logicOrExample() {
        {
            boolean value1 = false;
            boolean value2 = false;
            boolean result = Boolean.logicalOr(value1, value2);
            assertFalse(result);
        }
        {
            boolean value1 = false;
            boolean value2 = true;
            boolean result = Boolean.logicalOr(value1, value2);
            assertTrue(result);
        }
        {
            boolean value1 = true;
            boolean value2 = false;
            boolean result = Boolean.logicalOr(value1, value2);
            assertTrue(result);
        }
        {
            boolean value1 = true;
            boolean value2 = true;
            boolean result = Boolean.logicalOr(value1, value2);
            assertTrue(result);
        }
    }

    @Test
    public void logicXorExample() {
        {
            boolean value1 = false;
            boolean value2 = false;
            boolean result = Boolean.logicalXor(value1, value2);
            assertFalse(result);
        }
        {
            boolean value1 = false;
            boolean value2 = true;
            boolean result = Boolean.logicalXor(value1, value2);
            assertTrue(result);
        }
        {
            boolean value1 = true;
            boolean value2 = false;
            boolean result = Boolean.logicalXor(value1, value2);
            assertTrue(result);
        }
        {
            boolean value1 = true;
            boolean value2 = true;
            boolean result = Boolean.logicalXor(value1, value2);
            assertFalse(result);
        }
    }

    @Test
    public void typeExample() {
        assertSame(boolean.class, Boolean.TYPE);
    }
}



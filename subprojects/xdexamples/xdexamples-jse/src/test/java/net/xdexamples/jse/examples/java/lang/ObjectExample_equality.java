package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class ObjectExample_equality {

    @SuppressWarnings({
            "ConstantConditions",
            "EqualsWithItself",
            "NewObjectEquality",
            "NumberEquality",
            "UnnecessaryBoxing"
    })
    @Test
    public void example() {
        {
            // We create an object and check if it is equal to itself
            Object object = new Object();
            boolean result = object.equals(object);
            // And it's true
            assertTrue(result);
        }
        {
            // We create two objects and check if the first is equal to the second
            Object object1 = new Object();
            Object object2 = new Object();
            boolean result = object1.equals(object2);
            // And it is false
            assertFalse(result);
        }

        // Object::equals is equivalent to == and != for objects and any class that does not override equals()
        // So this is equivalent to the above

        {
            // We create an object and check if it is equal to itself using the equality operator
            Object object = new Object();
            boolean result = object == object;
            // It is again true
            assertTrue(result);
        }
        {
            // We create two objects and check if the first is equal to the second
            Object object1 = new Object();
            Object object2 = new Object();
            boolean result = object1 == object2;
            // And it is false
            assertFalse(result);
        }

        // Now an example of two object where equality works differently
        {
            Long object1 = Long.valueOf(1_000_000L);
            Long object2 = Long.valueOf(1_000_000L);

            boolean result1 = object1 == object2;
            boolean result2 = object1.equals(object2);

            assertFalse(result1);
            assertTrue(result2);
        }

        // By the way, this difference is embodied by isEquals and isSame in jUnit
        {
            Long object1 = Long.valueOf(1_000_000L);
            Long object2 = Long.valueOf(1_000_000L);

            assertEquals(object1, object2);
            assertNotSame(object1, object2);
        }
    }


}

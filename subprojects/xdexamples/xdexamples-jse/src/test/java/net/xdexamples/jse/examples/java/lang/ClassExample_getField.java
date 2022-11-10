package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class ClassExample_getField {

    @Test
    @SuppressWarnings({"ResultOfMethodCallIgnored"})
    public void example() throws NoSuchFieldException {
        {
            // Can access public fields
            Class<?> clazz = B.class;
            Field field = clazz.getField("bPublic");
            assertNotNull(field);
        }
        {
            // Can access public inherited fields
            Class<?> clazz = B.class;
            Field field = clazz.getField("aPublic");
            assertNotNull(field);
        }
        {
            // Cannot access protected, private and package fields
            Class<?> clazz = B.class;
            for (String fieldName : Arrays.asList("bProtected", "bPrivate", "bPackage")) {
                assertThrows(NoSuchFieldException.class, () -> {
                    clazz.getField(fieldName);
                });
            }
        }
    }

    @SuppressWarnings("unused")
    public static class A {
        private String aPrivate;
        protected String aProtected;
        public String aPublic;
        String aPackage;
    }

    @SuppressWarnings("unused")
    public static class B extends A {
        private String bPrivate;
        protected String bProtected;
        public String bPublic;
        String bPackage;
    }
}

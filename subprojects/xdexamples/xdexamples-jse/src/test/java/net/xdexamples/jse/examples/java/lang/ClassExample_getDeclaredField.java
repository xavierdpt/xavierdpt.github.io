package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class ClassExample_getDeclaredField {

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void example() throws NoSuchFieldException {
        {
            // Can access all fields of class B from class B
            Class<?> clazz = B.class;
            for (String fieldName : "bPublic,bProtected,bPrivate,bPackage".split(",")) {
                Field field = clazz.getDeclaredField(fieldName);
                assertNotNull(field);
            }
        }
        {
            // Can't access fields of class A from class B
            Class<?> clazz = B.class;
            for (String fieldName : "aPublic,aProtected,aPrivate,aPackage".split(",")) {
                Assert.assertThrows(NoSuchFieldException.class, () -> {
                    clazz.getDeclaredField(fieldName);
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

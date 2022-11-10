package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class ClassExample_getDeclaredFields {

    @Test
    public void example() {
        // getDeclaredFields collect all top level fields, but not inherited fields
        {
            Class<?> clazz = A.class;
            Field[] fields = clazz.getDeclaredFields();
            String[] fieldNames = Arrays.stream(fields).map(Field::getName).sorted().toArray(String[]::new);
            assertArrayEquals(new String[]{"aPackage","aPrivate","aProtected","aPublic"}, fieldNames);
        }
        {
            Class<?> clazz = B.class;
            Field[] fields = clazz.getDeclaredFields();
            String[] fieldNames = Arrays.stream(fields).map(Field::getName).sorted().toArray(String[]::new);
            assertArrayEquals(new String[]{"bPackage","bPrivate","bProtected","bPublic"}, fieldNames);
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

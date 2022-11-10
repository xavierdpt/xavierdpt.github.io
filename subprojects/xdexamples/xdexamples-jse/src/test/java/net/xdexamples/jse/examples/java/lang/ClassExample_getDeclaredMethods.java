package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ClassExample_getDeclaredMethods {

    @Test
    public void example() {
        // getDeclaredMethods collects all methods declared on the class, but not inherited methods
        {
            Class<?> clazz = A.class;
            Method[] methods = clazz.getDeclaredMethods();
            String methodNames = Arrays.stream(methods).map(Method::getName).sorted().collect(Collectors.joining(","));
            assertEquals("aPackage,aPrivate,aProtected,aPublic", methodNames);
        }
        {
            Class<?> clazz = B.class;
            Method[] methods = clazz.getDeclaredMethods();
            String methodNames = Arrays.stream(methods).map(Method::getName).sorted().collect(Collectors.joining(","));
            assertEquals("bPackage,bPrivate,bProtected,bPublic", methodNames);
        }
    }

    @SuppressWarnings("unused")
    public static class A {
        private void aPrivate() {
        }

        protected void aProtected() {
        }

        public void aPublic() {
        }

        void aPackage() {
        }

    }

    @SuppressWarnings("unused")
    public static class B extends A {
        private void bPrivate() {
        }

        protected void bProtected() {
        }

        public void bPublic() {
        }

        void bPackage() {
        }

    }

}

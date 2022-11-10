package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class ClassExample_getDeclaredMethod {

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void example() throws NoSuchMethodException {
        // getDeclaredMethod() finds all methods but not inherited ones
        {

            Class<?> clazz = B.class;
            for (String methodName : "bPublic,bProtected,bPrivate,bPackage".split(",")) {
                Method method = clazz.getDeclaredMethod(methodName);
                assertNotNull(method);
            }
        }
        {
            Class<?> clazz = B.class;
            for (String methodName : "aPublic,aProtected,aPrivate,aPackage".split(",")) {
                assertThrows(NoSuchMethodException.class, () -> clazz.getDeclaredMethod(methodName));
            }
        }
        {
            // Here's how to get a method that has arguments
            Class<?> clazz = Object.class;
            Method method = clazz.getDeclaredMethod("equals", Object.class);
            assertNotNull(method);
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

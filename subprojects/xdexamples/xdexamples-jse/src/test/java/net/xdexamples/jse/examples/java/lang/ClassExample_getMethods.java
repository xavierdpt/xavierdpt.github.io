package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ClassExample_getMethods {

    @Test
    public void example() {
        // getMethods collects all public methods, including inherited ones
        {
            Class<?> clazz = A.class;
            Method[] methods = clazz.getMethods();
            String methodNames = Arrays.stream(methods).map(Method::getName).sorted().collect(Collectors.joining(","));
            assertEquals("aPublic,equals,getClass,hashCode,notify,notifyAll,toString,wait,wait,wait", methodNames);
        }
        {
            Class<?> clazz = B.class;
            Method[] methods = clazz.getMethods();
            String methodNames = Arrays.stream(methods).map(Method::getName).sorted().collect(Collectors.joining(","));
            assertEquals("aPublic,bPublic,equals,getClass,hashCode,notify,notifyAll,toString,wait,wait,wait", methodNames);
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

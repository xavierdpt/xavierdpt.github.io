package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;

public class ClassExample_getDeclaredConstructor {

    @Test
    @SuppressWarnings({"JavaReflectionMemberAccess", "ResultOfMethodCallIgnored"})
    public void example() throws NoSuchMethodException {
        // getDeclaredConstructor() sees all constructors, but no inherited ones
        {
            // B's constructors
            for (Class<?> type : Arrays.asList(Byte.class, Short.class, Integer.class, Long.class)) {
                Constructor<B> declaredConstructor = B.class.getDeclaredConstructor(type, type);
                assertNotNull(declaredConstructor);
            }
        }
        {
            // A's constructors
            for (Class<?> type : Arrays.asList(Byte.class, Short.class, Integer.class, Long.class)) {
                Assert.assertThrows(NoSuchMethodException.class, () -> {
                    B.class.getDeclaredConstructor(type);
                });
            }
        }
        {
            // If a class is not static, then the constructor must be supplied with an instance of C
            Class<?> clazz = C.class;
            Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(this.getClass());
            assertNotNull(declaredConstructor);
        }
    }

    @SuppressWarnings("unused")
    public static class A {

        public A(Byte x) {
        }

        protected A(Short x) {
        }

        private A(Integer x) {

        }

        A(Long x) {

        }
    }

    @SuppressWarnings("unused")
    public static class B extends A {

        public B(Byte x, Byte y) {
            super(x);
        }

        protected B(Short x, Short y) {
            super(x);
        }

        private B(Integer x, Integer y) {
            super(x);
        }

        B(Long x, Long y) {
            super(x);
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    class C {
        public C() {
        }
    }

}

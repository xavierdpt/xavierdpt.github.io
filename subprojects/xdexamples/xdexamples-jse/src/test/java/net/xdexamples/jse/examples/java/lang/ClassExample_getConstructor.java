package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class ClassExample_getConstructor {

    @Test
    @SuppressWarnings({"JavaReflectionMemberAccess", "unused"})
    public void example() throws NoSuchMethodException {
        // getConstructor() sees only public constructors, and NOT inherited ones
        {
            // B's public constructor
            Class<?> clazz = B.class;
            Constructor<?> constructor = clazz.getConstructor(Byte.class, Byte.class);
            assertNotNull(constructor);
        }
        {
            // A's public constructor
            Class<?> clazz = B.class;
            assertThrows(NoSuchMethodException.class, () -> {
                Constructor<?> constructor = clazz.getConstructor(Byte.class);
            });
        }
        {
            // Other constructors
            Class<?> clazz = B.class;
            for (Class<?> type : Arrays.asList(Short.class, Integer.class, Long.class)) {
                // B's constructors
                assertThrows(NoSuchMethodException.class, () -> {
                    Constructor<?> constructor = clazz.getConstructor(type, type);
                });
                // A's constructors
                assertThrows(NoSuchMethodException.class, () -> {
                    Constructor<?> constructor = clazz.getConstructor(type);
                });
            }
        }
        // For non-static class, it is necessary to supply an instance of the containing class
        {
            // D's public constructor
            Class<?> clazz = D.class;
            Constructor<?> constructor = clazz.getConstructor(this.getClass(), String.class);
            assertNotNull(constructor);
        }
        {
            // C's public constructor
            Class<?> clazz = D.class;
            assertThrows(NoSuchMethodException.class, () -> {
                Constructor<?> constructor = clazz.getConstructor(this.getClass(), Character.class);
            });
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
        @SuppressWarnings("unused")
        public C(Character ch) {
        }
    }

    @SuppressWarnings("unused")
    class D extends C {

        @SuppressWarnings("unused")
        public D(String s) {
            super(null);
        }
    }


}

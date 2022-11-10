package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ClassExample_getDeclaredClasses {

    @Test
    public void example() {

        // Helper function that map classes to class names
        Function<Class<?>[], String> toString =
                classes -> Arrays.stream(classes)
                        .map(Class::getSimpleName)
                        .sorted()
                        .collect(Collectors.joining(","));

        // getDeclaredClasses() retrieves all classes, but not inherited ones
        Class<?> clazz = B.class;
        Class<?>[] classes = clazz.getDeclaredClasses();

        // Checkthe class names
        assertEquals("BPackage,BPrivate,BProtected,BPublic", toString.apply(classes));
    }

    public static class A {

        @SuppressWarnings("unused")
        public static class APublic {

        }

        @SuppressWarnings("unused")
        protected static class AProtected {

        }

        @SuppressWarnings("unused")
        private static class APrivate {

        }

        @SuppressWarnings("unused")
        static class APackage {

        }
    }

    public static class B extends A {

        @SuppressWarnings("unused")
        public static class BPublic {

        }

        @SuppressWarnings("unused")
        protected static class BProtected {

        }

        @SuppressWarnings("unused")
        private static class BPrivate {

        }

        @SuppressWarnings("unused")
        static class BPackage {

        }
    }


}

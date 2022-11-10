package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class ClassExample_getPermittedSubclasses {

    @Test
    public void example() {

        // Helper function to sort class by simple name
        Function<Class<?>[], Class<?>[]> sortBySimpleName =
                classes -> Arrays.stream(classes)
                        .sorted(Comparator.comparing(Class::getSimpleName))
                        .toArray(Class<?>[]::new);

        {
            // Sealed interface with permitted subclasses
            Class<?> clazz = I.class;
            Class<?>[] permittedSubclasses = clazz.getPermittedSubclasses();
            assertArrayEquals(
                    new Class<?>[]{A.class, B.class},
                    sortBySimpleName.apply(permittedSubclasses));
        }
        {
            // Not-sealed interface, permitted subclasses is null
            Class<?> clazz = Runnable.class;
            Class<?>[] permittedSubclasses = clazz.getPermittedSubclasses();
            assertNull(permittedSubclasses);
        }
    }

    public sealed interface I permits A, B {

    }

    public static final class A implements I {

    }

    public static final class B implements I {

    }

}

package xdtest;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertTrue;

/**
 * @deprecated Remove and converge to new way
 */
@Deprecated
public class TestUtils {
    public static <T, U extends T> void assertContainsOfClass(List<T> list, Class<U> clazz) {
        if (list == null) {
            return;
        }
        assertTrue(list.stream().map(T::getClass).anyMatch(clazz::equals));
    }

    public static <T, U extends T> U getObjectOfType(List<T> list, Class<U> clazz) {
        if (list == null) {
            return null;
        }
        return list.stream()
                .filter(item -> clazz.equals(item.getClass()))
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }

    public static <T> T makeInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ignore(Object... objects) {
        if (objects == null && f()) {
            throw new RuntimeException("That's not supposed to happen");
        }
    }

    public static boolean f() {
        return Math.abs(System.currentTimeMillis()) < 0;
    }

    public static boolean principle() {
        return f();
    }

    public static void indexEntry() {

    }

    public static <T> void assertContains(T[] array, T value) {
        assertTrue(Arrays.asList(array).contains(value));
    }

    public static <T> void assertContainsMatch(T[] array, Predicate<T> value) {
        assertTrue(Arrays.stream(array).anyMatch(value));
    }

}

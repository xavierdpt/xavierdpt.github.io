package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ClassExample_getDeclaredConstructors {

    @Test
    public void example() {
        {
            // Helper function to map constructors to their signature, it's easier than identifying them by name
            String thisClassName = this.getClass().getSimpleName();
            Function<Constructor<?>[], String> toString = constructors ->
                    Arrays.stream(constructors)
                            .map(constructor -> Arrays.stream(constructor.getParameters())
                                    .map(Parameter::getType)
                                    .map(Class::getSimpleName)
                                    .filter(((Predicate<String>) thisClassName::equals).negate())
                                    .sorted()
                                    .collect(Collectors.joining(",", "[", "]")))
                            .sorted()
                            .collect(Collectors.joining(","));

            {
                // getDeclaredConstructors() gives all declared constructors, and no inherited constructors
                Class<?> clazz = A.class;
                Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
                // These are the signatures of all constructors of class A
                assertEquals("[Byte],[Integer],[Long],[Short]",
                        toString.apply(declaredConstructors));
            }
            {
                Class<?> clazz = B.class;
                Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
                // These are the signatures of all constructors of class B
                assertEquals("[Byte,Byte],[Integer,Integer],[Long,Long],[Short,Short]",
                        toString.apply(declaredConstructors));
            }

        }
    }

    @SuppressWarnings("unused")
    static class A {

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
    class B extends A {

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
}

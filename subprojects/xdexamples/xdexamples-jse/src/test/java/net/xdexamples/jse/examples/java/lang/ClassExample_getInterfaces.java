package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class ClassExample_getInterfaces {

    @Test
    public void example() {
        {
            // The class
            Class<?> clazz = B.class;

            // Get the interfaces
            Class<?>[] interfaces = clazz.getInterfaces();

            // Find and check the names
            String interfaceNames = Arrays.stream(interfaces)
                    .map(Class::getSimpleName)
                    .sorted()
                    .collect(Collectors.joining(","));
            assertEquals("IB1,IB2", interfaceNames);
        }

        {
            // The class
            Class<?> clazz = A.class;

            // Get the interfaces
            Class<?>[] interfaces = clazz.getInterfaces();

            // Find and check the names
            String interfaceNames = Arrays.stream(interfaces)
                    .map(Class::getSimpleName)
                    .sorted()
                    .collect(Collectors.joining(","));
            assertEquals("IA", interfaceNames);
        }
    }


    interface IA {

    }

    public static class A implements IA {

    }

    interface IBB {

    }

    interface IB1 extends IBB {

    }

    interface IB2 {

    }

    public static class B extends A implements IB1, IB2 {

    }

}

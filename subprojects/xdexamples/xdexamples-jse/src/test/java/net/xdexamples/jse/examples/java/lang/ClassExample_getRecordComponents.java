package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ClassExample_getRecordComponents {

    @Test
    public void example() {

        // Helper function to convert record components to string
        Function<RecordComponent[], String> toString =
                recordComponents -> Arrays.stream(recordComponents)
                        .map(RecordComponent::getName)
                        .sorted()
                        .collect(Collectors.joining(","));

        {
            // This class has no record components
            Class<?> clazz = this.getClass();
            RecordComponent[] recordComponents = clazz.getRecordComponents();
            Assert.assertNull(recordComponents);
        }
        {
            // Class A has one record component
            Class<?> clazz = A.class;
            RecordComponent[] recordComponents = clazz.getRecordComponents();
            Assert.assertEquals("name", toString.apply(recordComponents));

        }
    }

    public record A(String name) {
    }

}

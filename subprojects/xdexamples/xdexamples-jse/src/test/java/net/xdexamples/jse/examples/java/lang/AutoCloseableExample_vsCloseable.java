package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;

import java.io.Closeable;
import java.util.stream.IntStream;

public class AutoCloseableExample_vsCloseable {

    @Test
    @SuppressWarnings("ConstantConditions")
    public void example() {
        // AutoCloseable makes it possible to use the try-with-resources
        // Closeable extends AutoCloseable, but some classes only implement AutoClosable
        // IntStream is an example of a class that implements AutoCloseable but not Closeable
        try (IntStream stream = IntStream.of(1, 2, 3)) {
            Assert.assertTrue(stream instanceof AutoCloseable);
            Assert.assertFalse(stream instanceof Closeable);
        }
    }
}

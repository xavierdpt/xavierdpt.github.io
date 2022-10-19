package xd.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;
import xd.BaseExample;
import xdtest.Done;
import xdtest.ExternalLinks;

import java.io.Closeable;
import java.util.stream.IntStream;

@Done
@ExternalLinks({
        "https://stackoverflow.com/questions/13141302/implements-closeable-or-implements-autocloseable"
})
public class AutoCloseableExample extends BaseExample<AutoCloseable> {

    @Override
    public void scaffold(AutoCloseable instance) throws Throwable {
        instance.close();
    }

    @Test
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

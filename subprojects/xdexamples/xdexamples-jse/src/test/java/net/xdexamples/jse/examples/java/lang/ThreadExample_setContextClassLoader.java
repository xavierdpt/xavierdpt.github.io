package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import javax.xml.parsers.DocumentBuilderFactory;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ThreadExample_setContextClassLoader {

    @Test
    @SuppressWarnings("InstantiatingAThreadWithDefaultRunMethod")
    public void example() throws InterruptedException {
        {
            // By default, the thread's context class loader is the current class loader
            Thread thread = new Thread();
            ClassLoader contextClassLoader = thread.getContextClassLoader();
            assertSame(this.getClass().getClassLoader(), contextClassLoader);
        }
        {
            // Thread with a custom context class loader that records which classes it has seen

            // Store class names here
            CopyOnWriteArraySet<String> seen = new CopyOnWriteArraySet<>();

            // Create thread
            Thread thread = new Thread(DocumentBuilderFactory::newInstance);

            // Set context class loader
            thread.setContextClassLoader(new ClassLoader() {
                @Override
                public String getName() {
                    return "myCustomClassLoader";
                }

                @Override
                public Class<?> loadClass(String name) throws ClassNotFoundException {
                    seen.add(name);
                    return super.loadClass(name);
                }
            });

            // Start thread
            thread.start();

            // Wait for thread to terminate
            thread.join();

            // Check what has been seen
            assertEquals(
                    Set.of("com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl"),
                    seen);
        }

    }

}

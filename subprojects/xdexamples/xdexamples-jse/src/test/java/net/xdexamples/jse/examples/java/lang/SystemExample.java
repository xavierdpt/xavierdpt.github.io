package net.xdexamples.jse.examples.java.lang;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.BaseExample;
import xd.helpers.dummies.Dummy;
import xd.helpers.dummies.DummyKey;
import xdtest.OperatingSystem;
import net.xdexamples.Scaffolded;
import xdtest.TestUtils;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.channels.Channel;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.WeakHashMap;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


@Scaffolded
public class SystemExample extends BaseExample<System> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(System instance) throws IOException {
        {
            // TODO: setIn
            InputStream inputStream = any();
            System.setIn(inputStream);
        }
        {
            PrintStream outputStream = any();
            System.setOut(outputStream);
            seeExamples(this::setOutExample);
        }
        {
            PrintStream printStream = any();
            System.setErr(printStream);
            seeExamples(this::getLoggerExample);
        }
        {
            Console console = System.console();
            seeExamples(this::consoleExample);
        }
        {
            // TODO: inheritedChannel
            Channel channel = System.inheritedChannel();
            seeExamples(this::inheritedChannelExample);
        }
        {
            long result = System.currentTimeMillis();
            seeExamples(this::currentTimeMillisExample);
        }
        {
            long result = System.nanoTime();
            seeExamples(this::nanoTimeExample);
        }
        {
            // TODO: arraycopy
            Object src = any();
            int srcPos = 0;
            Object dest = any();
            int destPos = 0;
            int length = 0;
            System.arraycopy(src, srcPos, dest, destPos, length);
        }
        {
            Object object = any();
            int result = System.identityHashCode(object);
            seeExamples(this::identityHashCodeExample);
        }
        {
            Properties properties = System.getProperties();
            seeExamples(this::getAndSetPropertiesExample);
        }
        {
            String result = System.lineSeparator();
            seeExamples(this::lineSeparatorExample);
        }
        {
            Properties properties = any();
            System.setProperties(properties);
            seeExamples(this::getAndSetPropertiesExample);
        }
        {
            String key = any();
            String value = System.getProperty(key);
            seeExamples(this::setAndGetPropertyExample);
        }
        {
            String key = any();
            String def = any();
            String value = System.getProperty(key, def);
            seeExamples(this::getPropertyWithDefaultExample);
        }
        {
            String key = any();
            String value = any();
            System.setProperty(key, value);
            seeExamples(this::setAndGetPropertyExample);
        }
        {
            String key = any();
            System.clearProperty(key);
            seeExamples(this::clearPropertyExample);
        }
        {
            Map<String, String> env = System.getenv();
            seeExamples(this::getEnvExample);
        }
        {
            String name = any();
            String env = System.getenv(name);
            seeExamples(this::getEnvExample);
        }
        {
            String name = any();
            System.Logger logger = System.getLogger(name);
            seeExamples(this::getLoggerExample);
        }
        {
            // TODO: getLogger
            String name = any();
            ResourceBundle bundle = any();
            System.Logger logger = System.getLogger(name, bundle);
        }
        {
            int status = 0;
            System.exit(status);
            seeExamples(this::exitExample);
        }
        {
            System.gc();
            seeExamples(this::gcExample);
        }
        {
            // TODO: load
            String filename = any();
            System.load(filename);
        }
        {
            // TODO: loadLibrary
            String libname = any();
            System.loadLibrary(libname);
        }
        {
            // TODO: mapLibraryName
            String libname = any();
            String s1 = System.mapLibraryName(libname);
        }
        {
            // TODO: in
            InputStream in = System.in;
        }
        {
            PrintStream out = System.out;
            seeExamples(this::setOutExample);
        }
        {
            PrintStream err = System.err;
            seeExamples(this::getLoggerExample);
        }
    }

    @Test
    public void currentTimeMillisExample() throws InterruptedException {
        long first = System.currentTimeMillis();
        assertTrue(first > 0L);
        Thread.sleep(1000L);
        long second = System.currentTimeMillis();
        assertTrue(second - first >= 1000L);
    }

    @Test
    public void nanoTimeExample() throws InterruptedException {
        long firstNanos = System.nanoTime();
        Thread.sleep(1000L);
        long secondNanos = System.nanoTime();
        assertTrue(secondNanos - firstNanos >= 1_000_000_000L);
    }

    @Test
    public void identityHashCodeExample() {
        {
            Object object = new Object();
            int result = System.identityHashCode(object);
            assertEquals(object.hashCode(), result);
        }
        {
            String object = "hello";
            int result = System.identityHashCode(object);
            assertNotEquals(object.hashCode(), result);
        }
    }

    @Test
    public void lineSeparatorExample() {
        OperatingSystem os = TestUtils.findOS();
        String separator = System.lineSeparator();
        switch (os) {
            case WINDOWS:
                assertEquals("\r\n", separator);
                break;
            case LINUX:
            case UNKNOWN:
            default:
                Assert.fail("TODO: Other OS");
        }
    }

    @Test
    public void setAndGetPropertyExample() {
        // Find a property name that is not set
        String name = "a";
        while (System.getProperty(name) != null) {
            name += "a";
        }
        // Set the property
        System.setProperty(name, "hello");
        // Check the property value
        try {
            String value = System.getProperty(name);
            assertEquals("hello", value);
        } finally {
            // Clear the property in any case
            System.clearProperty(name);
        }
    }

    @Test
    public void clearPropertyExample() {
        // Find a property that is set
        String name = (String) System.getProperties().propertyNames().nextElement();
        String value = System.getProperty(name);
        try {
            assertNotNull(value);
            System.clearProperty(name);
            String newValue = System.getProperty(name);
            assertNull(newValue);
        } finally {
            // restore property value
            System.setProperty(name, value);
        }

    }

    @Test
    public void getPropertyWithDefaultExample() {
        // Find a property that is set
        String key = (String) System.getProperties().propertyNames().nextElement();
        String existingValue = System.getProperty(key);
        assertNotNull(existingValue);
        // Generate a different "default" value
        String defValue = "_" + existingValue;
        try {
            {
                // Current value
                String value = System.getProperty(key, defValue);
                assertEquals(existingValue, value);
            }
            // Clear the property
            System.clearProperty(key);
            {
                // Default value
                String value = System.getProperty(key, defValue);
                assertEquals(defValue, value);
            }
        } finally {
            // Restore the property value
            System.setProperty(key, existingValue);
        }
    }

    @Test
    public void getAndSetPropertiesExample() {
        // Find a property key that is not set
        String name = "a";
        while (System.getProperty(name) != null) {
            name += "a";
        }
        // Remember current properties
        Properties previous = System.getProperties();
        try {
            {
                // Test against current properties
                String value = System.getProperty(name);
                assertNull(value);
            }
            // Modify system properties
            Properties properties = new Properties();
            properties.setProperty(name, "testValue");
            System.setProperties(properties);
            {
                // Test against new properties
                String value = System.getProperty(name);
                assertEquals("testValue", value);
            }
        } finally {
            // Restore original system properties
            System.setProperties(previous);
        }
    }

    @Test
    public void gcExample() {

        // Create a strong map
        Map<DummyKey, Dummy> strongMap = new HashMap<>();
        strongMap.put(new DummyKey("test"), new Dummy());

        // Create a weak map
        Map<DummyKey, Dummy> weakMap = new WeakHashMap<>();
        weakMap.put(new DummyKey("test"), new Dummy());

        // Check that both map contains the dummy key
        assertTrue(strongMap.containsKey(new DummyKey("test")));
        assertTrue(weakMap.containsKey(new DummyKey("test")));

        // Run the GC
        System.gc();

        // Check that the strong map still has a key, but the weak map was cleaned up
        assertTrue(strongMap.containsKey(new DummyKey("test")));
        assertFalse(weakMap.containsKey(new DummyKey("test")));
    }

    @Test
    public void setOutExample() {
        // Remeber current System.out
        PrintStream previous = System.out;
        try {
            // Set a new System.out
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
            // Use it
            System.out.println("Hello world");
            // Check it
            assertArrayEquals("Hello world\r\n".getBytes(), baos.toByteArray());
        } finally {
            // Restore System.out
            System.setOut(previous);
        }
    }

    @Test
    public void getEnvExample() {
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            assertEquals(env.get(key), System.getenv(key));
        }
    }

    @Test
    public void exitExample() throws IOException, InterruptedException {

        for (Map.Entry<String, String> xxx : System.getenv().entrySet()) {
            System.out.println(xxx.getKey()+": "+xxx.getValue());
        }

        Random random = new Random(System.currentTimeMillis());
        int expectedExitCode = random.nextInt(2, 128);
        ProcessBuilder pb = new ProcessBuilder("java", ExitExample.class.getName(), String.valueOf(expectedExitCode));
        pb.directory(new File("target/test-classes"));
        pb.inheritIO();
        Process process = pb.start();
        process.waitFor();
        int exitCode = process.exitValue();

        assertEquals(expectedExitCode, exitCode);
    }

    @Test
    public void getLoggerExample() {
        System.Logger logger = System.getLogger("testLogger");
        assertNotNull(logger);
        PrintStream previous = System.err;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            System.setErr(new PrintStream(baos));
            logger.log(System.Logger.Level.INFO, "exampleMessage");
            String[] lines = baos.toString().lines().toArray(String[]::new);
            assertEquals(2, lines.length);
            assertTrue(lines[0].endsWith(" net.xdexamples.jse.examples.java.lang.SystemExample getLoggerExample"));
            assertEquals("INFO: exampleMessage", lines[1]);
        } finally {
            System.setErr(previous);
        }

    }

    @Test
    public void inheritedChannelExample() throws IOException {
        Channel channel = System.inheritedChannel();
        assertNull(channel);
        // TODO: find how to have a non-null channel on Unix
        // TODO: find how to have a non-null channel on Windows
    }

    @Test
    public void consoleExample() {
        Console console = System.console();
        assertNull(console);
        // TODO: find how to have a non-null console, using ConsoleExample class below
        seeOthers(net.xdexamples.jse.examples.java.io.ConsoleExample.class);

    }

    public static class ExitExample {
        public static void main(String[] args) {
            int exitCode = Integer.parseInt(args[0]);
            System.exit(exitCode);
        }
    }

    public static class ConsoleExample {
        public static void main(String[] args) {
            int exitCode;
            if (System.console() == null) {
                exitCode = 5;
            } else {
                exitCode = 6;
            }
            System.exit(exitCode);
        }
    }

}

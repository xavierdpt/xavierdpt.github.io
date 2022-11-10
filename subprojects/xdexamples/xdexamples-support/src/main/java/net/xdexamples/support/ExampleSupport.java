package net.xdexamples.support;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExampleSupport {

    public static String bytesToHex(byte[] bytes) {
        if (bytes == null) {
            bytes = new byte[0];
        }
        StringBuilder sb = new StringBuilder();
        boolean sep = false;
        for (byte b : bytes) {
            if (sep) {
                sb.append(" ");
            }
            sb.append(byteToHex(b));
            sep = true;
        }
        return sb.toString();
    }

    private static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF).toUpperCase();
        return (hex.length() == 1 ? "0" : "") + hex;
    }

    public static void withSystemProperty(String name, String value, ThrowingRunnable runnable) throws Throwable {
        String previousValue = System.getProperty(name);
        try {
            System.setProperty(name, value);
            runnable.run();
        } finally {
            if (previousValue == null) {
                System.clearProperty(name);
            } else {
                System.setProperty(name, previousValue);
            }
        }
    }

    public static String fromCodePointNames(String... codePointNames) {
        return Arrays.stream(codePointNames)
                .map(Character::codePointOf)
                .map(Character::toChars)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private static volatile Throwable thrown = null;

    public static void assertInThread(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable t) {
            thrown = t;
        }
    }

    public static void clearThreadExceptions() {
        thrown = null;
    }

    public static void checkThreadExceptions() throws Throwable {
        if (thrown!=null) {
            throw thrown;
        }
    }
}

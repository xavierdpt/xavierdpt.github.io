package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ThreadExample_setDaemon {

    @Test
    public void example() throws IOException, InterruptedException {
        {
            // Daemon
            ProcessBuilder pb = new ProcessBuilder("java", this.getClass().getName(), String.valueOf(true));
            pb.directory(new File("target/test-classes"));
            Process process = pb.start();
            try {
                boolean exited = process.waitFor(10L, TimeUnit.SECONDS);
                assertTrue(exited);
            } finally {
                process.destroyForcibly();
            }

        }
        {
            // Not daemon
            ProcessBuilder pb = new ProcessBuilder("java", this.getClass().getName(), String.valueOf(false));
            pb.directory(new File("target/test-classes"));
            Process process = pb.start();
            try {
                boolean exited = process.waitFor(10L, TimeUnit.SECONDS);
                assertFalse(exited);
                process = process.destroyForcibly();
                Thread.sleep(1000L);
                assertFalse(process.isAlive());
            } finally {
                process.destroyForcibly();
            }
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                Thread.onSpinWait();
            }
        });
        thread.setDaemon(Boolean.parseBoolean(args[0]));
        thread.start();
    }

}

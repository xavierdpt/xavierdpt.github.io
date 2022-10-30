package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Scaffolded
public class ProcessExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            Process instance = ExampleUtils.makeInstance(Process.class);

            OutputStream outputStream = instance.getOutputStream();
            InputStream inputStream = instance.getInputStream();
            InputStream errorStream = instance.getErrorStream();
            BufferedReader bufferedReader = instance.inputReader();
            Charset charset = null;
            BufferedReader bufferedReader1 = instance.inputReader(charset);
            BufferedReader bufferedReader2 = instance.errorReader();
            BufferedReader bufferedReader3 = instance.errorReader(charset);
            BufferedWriter bufferedWriter = instance.outputWriter();
            BufferedWriter bufferedWriter1 = instance.outputWriter(charset);
            int i = instance.waitFor();
            long timeout = 0;
            TimeUnit unit = null;
            instance.waitFor(timeout, unit);
            int i1 = instance.exitValue();
            instance.destroy();
            Process process = instance.destroyForcibly();
            boolean b = instance.supportsNormalTermination();
            boolean alive = instance.isAlive();
            long pid = instance.pid();
            CompletableFuture<Process> processCompletableFuture = instance.onExit();
            ProcessHandle processHandle = instance.toHandle();
            ProcessHandle.Info info = instance.info();
            Stream<ProcessHandle> children = instance.children();
            Stream<ProcessHandle> descendants = instance.descendants();
        }
    }

}

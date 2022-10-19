package xd.examples.java.lang;

import org.junit.Test;
import xd.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Stream;

@ToBeContinued
public class ProcessHandleExample {

    public void scaffold() throws ClassNotFoundException, IOException, InterruptedException {
        if (ExampleUtils.skip()) {
            ProcessHandle instance = ExampleUtils.makeInstance(ProcessHandle.class);
            long pid = instance.pid();
            Optional<ProcessHandle> of = ProcessHandle.of(pid);
            ProcessHandle current = ProcessHandle.current();
            Optional<ProcessHandle> parent = instance.parent();
            Stream<ProcessHandle> children = instance.children();
            Stream<ProcessHandle> descendants = instance.descendants();
            Stream<ProcessHandle> processHandleStream = ProcessHandle.allProcesses();
            ProcessHandle.Info info = instance.info();
            CompletableFuture<ProcessHandle> processHandleCompletableFuture = instance.onExit();
            boolean b = instance.supportsNormalTermination();
            boolean destroy = instance.destroy();
            boolean b1 = instance.destroyForcibly();
            boolean alive = instance.isAlive();
            int i = instance.hashCode();
            ProcessHandle other = null;
            int i1 = instance.compareTo(other);
            boolean equals = instance.equals(other);
        }
    }

    @Test
    public void example() {
        ProcessHandle.allProcesses().forEach(
                ph -> System.out.println(ph.pid()));
    }

}

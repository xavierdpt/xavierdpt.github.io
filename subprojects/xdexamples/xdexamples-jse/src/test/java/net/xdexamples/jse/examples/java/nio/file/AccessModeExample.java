package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.nio.file.AccessMode;

@Scaffolded
public class AccessModeExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            AccessMode instance = ExampleUtils.makeInstance(AccessMode.class);
            AccessMode read = AccessMode.READ;
            AccessMode write = AccessMode.WRITE;
            AccessMode execute = AccessMode.EXECUTE;
        }
    }
}

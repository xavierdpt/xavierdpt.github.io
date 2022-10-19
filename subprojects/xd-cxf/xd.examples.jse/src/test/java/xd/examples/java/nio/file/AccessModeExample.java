package xd.examples.java.nio.file;

import xd.ExampleUtils;
import xdtest.Scaffolded;

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

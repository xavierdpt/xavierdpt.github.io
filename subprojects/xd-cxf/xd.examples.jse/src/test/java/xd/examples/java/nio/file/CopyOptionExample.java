package xd.examples.java.nio.file;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.nio.file.CopyOption;

@Scaffolded
@Interface
public class CopyOptionExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            CopyOption instance = ExampleUtils.makeInstance(CopyOption.class);
            // empty interface
        }
    }
}

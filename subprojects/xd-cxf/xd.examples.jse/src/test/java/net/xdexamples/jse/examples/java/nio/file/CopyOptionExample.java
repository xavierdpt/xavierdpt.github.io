package net.xdexamples.jse.examples.java.nio.file;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import net.xdexamples.Scaffolded;

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

package net.xdexamples.jse.examples.java.rmi;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.rmi.Remote;

@Scaffolded
public class RemoteExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            Remote instance = ExampleUtils.makeInstance(Remote.class);
        }
    }

}

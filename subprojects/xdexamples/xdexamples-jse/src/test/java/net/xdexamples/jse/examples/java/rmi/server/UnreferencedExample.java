package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;

import java.rmi.server.Unreferenced;

public class UnreferencedExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            Unreferenced instance = ExampleUtils.makeInstance(Unreferenced.class);
            instance.unreferenced();
        }
    }
}

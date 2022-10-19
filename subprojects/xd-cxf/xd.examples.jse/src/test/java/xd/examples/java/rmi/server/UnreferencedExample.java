package xd.examples.java.rmi.server;

import xd.ExampleUtils;

import java.rmi.server.Unreferenced;

public class UnreferencedExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            Unreferenced instance = ExampleUtils.makeInstance(Unreferenced.class);
            instance.unreferenced();
        }
    }
}

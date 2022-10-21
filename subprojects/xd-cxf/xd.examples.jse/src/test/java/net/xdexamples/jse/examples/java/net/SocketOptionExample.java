package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Done;
import xdtest.Interface;

import java.net.SocketOption;

@Interface
@Done
public class SocketOptionExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            SocketOption<Dummy> instance = ExampleUtils.makeInstance(SocketOption.class);
            String name = instance.name();
            Class<Dummy> type = instance.type();
        }
    }

    public static class Dummy {
    }
}

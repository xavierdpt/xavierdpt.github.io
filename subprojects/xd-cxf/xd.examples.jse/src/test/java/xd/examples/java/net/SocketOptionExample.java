package xd.examples.java.net;

import xd.ExampleUtils;
import xdtest.Done;
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

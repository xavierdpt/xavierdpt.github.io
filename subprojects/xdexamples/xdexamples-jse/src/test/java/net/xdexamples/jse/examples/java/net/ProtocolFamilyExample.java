package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import net.xdexamples.AllMethodsCovered;

import java.net.ProtocolFamily;
import java.net.SocketException;

@AllMethodsCovered
public class ProtocolFamilyExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            // That's quite useless, it is implemented by StandardProtocolFamily as a simple enum,
            // and somewhere else as a lambda that returns "UNSPEC"
            ProtocolFamily instance = ExampleUtils.makeInstance(ProtocolFamily.class);
            String name = instance.name();
        }
    }

}

package xd.examples.java.net;

import xd.ExampleUtils;
import xdtest.Done;

import java.net.ProtocolFamily;
import java.net.SocketException;

@Done
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

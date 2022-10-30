package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.support.internal.Scaffolded;

import java.io.IOException;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;

@Scaffolded
public class RMIClientSocketFactoryExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            RMIClientSocketFactory instance = ExampleUtils.makeInstance(RMIClientSocketFactory.class);
            String host = null;
            int port = 0;
            Socket socket = instance.createSocket(host, port);
        }
    }

}

package xd.examples.java.rmi.server;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;

@Scaffolded
public class RMIServerSocketFactoryExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            RMIServerSocketFactory instance = ExampleUtils.makeInstance(RMIServerSocketFactory.class);
            int port = 0;
            ServerSocket serverSocket = instance.createServerSocket(port);
        }
    }

}

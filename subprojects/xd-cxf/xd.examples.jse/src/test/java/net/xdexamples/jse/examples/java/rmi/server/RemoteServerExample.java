package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.OutputStream;
import java.io.PrintStream;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

@Scaffolded
public class RemoteServerExample {

    public void scaffold() throws ServerNotActiveException {
        if (ExampleUtils.skip()) {
            RemoteServer instance = ExampleUtils.makeInstance(RemoteServer.class);
            String clientHost = RemoteServer.getClientHost();
            OutputStream output = null;
            RemoteServer.setLog(output);
            PrintStream log = RemoteServer.getLog();
        }
    }
}

package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.ObjectInputFilter;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

@Scaffolded
public class UnicastRemoteObjectExample {
    public void scaffold() throws CloneNotSupportedException, RemoteException {
        if (ExampleUtils.skip()) {
            UnicastRemoteObject instance = ExampleUtils.makeInstance(UnicastRemoteObject.class);

            Object clone = instance.clone();

            Remote remote = null;
            int port = 0;
            RMIClientSocketFactory clientSocketFactory = null;
            RMIServerSocketFactory serverSocketFactory = null;
            ObjectInputFilter filter = null;

            Remote remote1 = UnicastRemoteObject.exportObject(remote, port);
            Remote remote2 = UnicastRemoteObject.exportObject(remote, port, clientSocketFactory, serverSocketFactory);
            Remote remote3 = UnicastRemoteObject.exportObject(remote, port, filter);
            Remote remote4 = UnicastRemoteObject.exportObject(remote, port, clientSocketFactory, serverSocketFactory, filter);

            boolean force = false;
            boolean b = UnicastRemoteObject.unexportObject(remote, force);
        }
    }
}

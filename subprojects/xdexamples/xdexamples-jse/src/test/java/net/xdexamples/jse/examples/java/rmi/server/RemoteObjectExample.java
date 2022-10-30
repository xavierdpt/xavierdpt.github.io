package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;

@Scaffolded
public class RemoteObjectExample {

    public void scaffold() throws NoSuchObjectException {
        if (ExampleUtils.skip()) {
            RemoteObject instance = ExampleUtils.makeInstance(RemoteObject.class);

            RemoteRef ref = instance.getRef();

            Remote remote = null;
            Remote remote1 = RemoteObject.toStub(remote);

            int i = instance.hashCode();
            RemoteObject other = null;
            boolean equals = instance.equals(other);
            String s = instance.toString();

        }
    }
}

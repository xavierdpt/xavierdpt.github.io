package xd.examples.java.rmi;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

@Scaffolded
public class NamingExample {

    public void scaffold() throws MalformedURLException, NotBoundException, RemoteException, AlreadyBoundException {
        if (ExampleUtils.skip()) {
            Naming instance = ExampleUtils.makeInstance(Naming.class);
            String name = null;
            Naming.lookup(name);
            Remote object = null;
            Naming.bind(name, object);
            Naming.unbind(name);
            Naming.rebind(name, object);
            Naming.list(name);
        }
    }

}

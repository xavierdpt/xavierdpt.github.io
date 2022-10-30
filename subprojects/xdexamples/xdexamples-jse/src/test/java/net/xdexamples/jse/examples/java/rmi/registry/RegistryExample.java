package net.xdexamples.jse.examples.java.rmi.registry;

import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import static org.junit.Assert.assertEquals;

@ToBeContinued
public class RegistryExample {

    public void scaffold() throws NotBoundException, RemoteException, AlreadyBoundException {
        if (ExampleUtils.skip()) {
            Registry instance = ExampleUtils.makeInstance(Registry.class);

            String name = null;
            Remote remote = null;

            instance.bind(name, remote);
            instance.unbind(name);
            instance.rebind(name, remote);
            instance.lookup(name);
            instance.list();

            int registryPort = Registry.REGISTRY_PORT;

        }
    }

    @Test
    public void example() {
        assertEquals(1099, Registry.REGISTRY_PORT);
    }

}

package xd.examples.java.rmi.registry;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;

@Scaffolded
public class LocateRegistryExample {

    public void scaffold() throws RemoteException {
        if (ExampleUtils.skip()) {
            LocateRegistry instance = ExampleUtils.makeInstance(LocateRegistry.class);

            int port = 0;
            String host = null;
            RMIClientSocketFactory clientSocketFactory = null;

            Registry registry = LocateRegistry.getRegistry();
            Registry registry1 = LocateRegistry.getRegistry(port);
            Registry registry2 = LocateRegistry.getRegistry(host);
            Registry registry3 = LocateRegistry.getRegistry(host, port);
            Registry registry4 = LocateRegistry.getRegistry(host, port, clientSocketFactory);

            RMIServerSocketFactory serverSocketFactory = null;
            Registry registry5 = LocateRegistry.createRegistry(port);
            Registry registry6 = LocateRegistry.createRegistry(port, clientSocketFactory, serverSocketFactory);
        }
    }

}

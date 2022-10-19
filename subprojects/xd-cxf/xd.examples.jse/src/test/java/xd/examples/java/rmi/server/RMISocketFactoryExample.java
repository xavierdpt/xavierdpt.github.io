package xd.examples.java.rmi.server;

import org.junit.Test;
import xd.ExampleUtils;
import xdtest.ToBeContinued;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMIFailureHandler;
import java.rmi.server.RMISocketFactory;

import static org.junit.Assert.assertNotNull;

@ToBeContinued
public class RMISocketFactoryExample {

    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            RMISocketFactory instance = ExampleUtils.makeInstance(RMISocketFactory.class);
            String host = null;
            int port = 0;
            Socket socket = instance.createSocket(host, port);
            ServerSocket serverSocket = instance.createServerSocket(port);
            RMISocketFactory socketFactory = null;
            RMISocketFactory.setSocketFactory(socketFactory);
            RMISocketFactory socketFactory1 = RMISocketFactory.getSocketFactory();
            RMISocketFactory defaultSocketFactory = RMISocketFactory.getDefaultSocketFactory();
            RMIFailureHandler fh = null;
            RMISocketFactory.setFailureHandler(fh);
            RMIFailureHandler failureHandler = RMISocketFactory.getFailureHandler();
        }
    }

    @Test
    public void defaultSocketFactory() {
        assertNotNull(RMISocketFactory.getDefaultSocketFactory());
    }

}

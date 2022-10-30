package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.rmi.server.RMIFailureHandler;

@Scaffolded
public class RMIFailureHandlerExample {

    public void scaffold() {
        if (ExampleUtils.skip()) {
            RMIFailureHandler instance = ExampleUtils.makeInstance(RMIFailureHandler.class);
            Exception exception = null;
            boolean failure = instance.failure(exception);
        }
    }

}

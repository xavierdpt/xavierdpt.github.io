package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.Scaffolded;
import net.xdexamples.ExampleUtils;

import java.lang.reflect.Method;
import java.rmi.server.RemoteObjectInvocationHandler;
import java.rmi.server.RemoteRef;

@Scaffolded
public class RemoteObjectInvocationHandlerExample {

    public void scaffold() throws Throwable {
        if (ExampleUtils.skip()) {
            RemoteObjectInvocationHandler instance = ExampleUtils.makeInstance(RemoteObjectInvocationHandler.class);

            RemoteRef ref = null;
            ExampleUtils.ignore(
                    new RemoteObjectInvocationHandler(ref)
            );

            Object proxy = null;
            Method methods = null;
            Object[] args = new Object[0];
            instance.invoke(proxy, methods, args);

        }
    }
}

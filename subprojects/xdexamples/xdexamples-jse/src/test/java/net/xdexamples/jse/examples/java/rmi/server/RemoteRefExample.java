package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.ObjectOutput;
import java.lang.reflect.Method;
import java.rmi.Remote;
import java.rmi.server.RemoteRef;

@Scaffolded
public class RemoteRefExample {

    public void scaffold() throws Exception {
        if (ExampleUtils.skip()) {
            RemoteRef instance = ExampleUtils.makeInstance(RemoteRef.class);

            Remote object = null;
            Method method = null;
            Object[] params = new Object[0];
            long opnum = 0;
            instance.invoke(object, method, params, opnum);
            ObjectOutput output = null;
            String refClass = instance.getRefClass(output);
            int i = instance.remoteHashCode();
            RemoteRef ref = null;
            boolean b = instance.remoteEquals(ref);
            String s = instance.remoteToString();
            String packagePrefix = instance.packagePrefix;

        }
    }
}

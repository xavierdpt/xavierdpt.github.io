package xd.examples.java.rmi.server;

import xd.ExampleUtils;
import xdtest.Scaffolded;

import java.net.MalformedURLException;
import java.rmi.server.RMIClassLoaderSpi;

@Scaffolded
public class RMIClassLoaderSpiExample {

    public void scaffold() throws MalformedURLException, ClassNotFoundException {
        if (ExampleUtils.skip()) {
            RMIClassLoaderSpi instance = ExampleUtils.makeInstance(RMIClassLoaderSpi.class);

            String codebase = null;
            String name = null;
            ClassLoader classLoader = null;
            instance.loadClass(codebase, name, classLoader);

            String[] interfaces = new String[0];
            instance.loadProxyClass(codebase, interfaces, classLoader);

            ClassLoader classLoader1 = instance.getClassLoader(codebase);

            Class<?> clazz = null;
            String classAnnotation = instance.getClassAnnotation(clazz);
        }
    }
}

package net.xdexamples.jse.examples.java.rmi.server;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.server.RMIClassLoader;
import java.rmi.server.RMIClassLoaderSpi;

@Scaffolded
public class RMIClassLoaderExample {

    public void scaffold() throws MalformedURLException, ClassNotFoundException {
        if (ExampleUtils.skip()) {
            RMIClassLoader instance = ExampleUtils.makeInstance(RMIClassLoader.class);

            URL codebaseURL = null;
            String name = null;
            String codebase = null;
            ClassLoader classLoader = null;
            Class<?> aClass1 = RMIClassLoader.loadClass(codebaseURL, name);
            Class<?> aClass2 = RMIClassLoader.loadClass(codebase, name);
            Class<?> aClass3 = RMIClassLoader.loadClass(codebase, name, classLoader);

            String[] interfaces = new String[0];
            Class<?> aClass = RMIClassLoader.loadProxyClass(codebase, interfaces, classLoader);

            ClassLoader classLoader1 = RMIClassLoader.getClassLoader(codebase);
            Class<?> clazz = null;
            String classAnnotation = RMIClassLoader.getClassAnnotation(clazz);

            RMIClassLoaderSpi defaultProviderInstance = RMIClassLoader.getDefaultProviderInstance();

        }
    }
}

package net.xdexamples.jse.examples.java.lang;

import net.xdexamples.ExampleUtils;
import net.xdexamples.Scaffolded;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.stream.Stream;


@Scaffolded
public class ClassLoaderExample {

    public void scaffold() throws ClassNotFoundException, IOException {
        if (ExampleUtils.skip()) {
            ClassLoader instance = ExampleUtils.makeInstance(ClassLoader.class);
            String name = instance.getName();
            Class<?> aClass = instance.loadClass(name);
            URL resource = instance.getResource(name);
            Enumeration<URL> resources = instance.getResources(name);
            Stream<URL> resources1 = instance.resources(name);
            boolean registeredAsParallelCapable = instance.isRegisteredAsParallelCapable();
            URL systemResource = ClassLoader.getSystemResource(name);
            Enumeration<URL> systemResources = ClassLoader.getSystemResources(name);
            InputStream resourceAsStream = instance.getResourceAsStream(name);
            InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(name);
            ClassLoader parent = instance.getParent();
            Module unnamedModule = instance.getUnnamedModule();
            ClassLoader platformClassLoader = ClassLoader.getPlatformClassLoader();
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            Package definedPackage = instance.getDefinedPackage(name);
            Package[] definedPackages = instance.getDefinedPackages();
            boolean assertionStatus = false;
            instance.setDefaultAssertionStatus(assertionStatus);
            instance.setPackageAssertionStatus(name, assertionStatus);
            instance.setClassAssertionStatus(name, assertionStatus);
            instance.clearAssertionStatus();
        }
    }

}

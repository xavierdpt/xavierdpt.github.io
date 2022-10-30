package net.xdexamples.jse.examples.java.util;

import net.xdexamples.support.internal.BaseExample;
import xd.helpers.dummies.Dummy;
import net.xdexamples.support.internal.Scaffolded;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Stream;

@Scaffolded
public class ServiceLoaderExample extends BaseExample<ServiceLoader<Dummy>> {

    @Override
    public void scaffold(ServiceLoader<Dummy> instance) throws Throwable {
        Iterator<Dummy> iterator = instance.iterator();
        Stream<ServiceLoader.Provider<Dummy>> stream = instance.stream();

        ModuleLayer layer = null;
        Class<Dummy> service = null;
        ClassLoader classLoader = null;
        ServiceLoader<Dummy> load = ServiceLoader.load(service);
        ServiceLoader<Dummy> load1 = ServiceLoader.load(service, classLoader);
        ServiceLoader<Dummy> load2 = ServiceLoader.load(layer, service);

        ServiceLoader<Dummy> dummies = ServiceLoader.loadInstalled(service);

        Optional<Dummy> first = instance.findFirst();

        instance.reload();

        String s = instance.toString();
    }
}

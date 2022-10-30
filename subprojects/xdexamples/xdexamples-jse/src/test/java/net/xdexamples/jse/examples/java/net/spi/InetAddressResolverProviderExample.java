package net.xdexamples.jse.examples.java.net.spi;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;

import static java.net.spi.InetAddressResolverProvider.*;

@ToBeContinued
public class InetAddressResolverProviderExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            Configuration configuration = null;
            InetAddressResolverProvider instance = ExampleUtils.makeInstance(InetAddressResolverProvider.class);
            InetAddressResolver inetAddressResolver = instance.get(configuration);
            String name = instance.name();
        }
    }

    @ToBeContinued
    public static class ConfigurationExample {
        public void scaffold() {
            if (ExampleUtils.skip()) {
                Configuration instance = ExampleUtils.makeInstance(Configuration.class);
                InetAddressResolver inetAddressResolver = instance.builtinResolver();
                String s = instance.lookupLocalHostName();
            }
        }
    }

}

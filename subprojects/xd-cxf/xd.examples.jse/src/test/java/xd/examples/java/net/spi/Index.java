package xd.examples.java.net.spi;

import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolverProvider;
import java.net.spi.URLStreamHandlerProvider;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(

                    InetAddressResolver.class,
                    InetAddressResolverExample.class,

                    InetAddressResolverProvider.class,
                    InetAddressResolverProviderExample.class,

                    URLStreamHandlerProvider.class,
                    URLStreamHandlerProviderExample.class

            ));
        }
    }
}

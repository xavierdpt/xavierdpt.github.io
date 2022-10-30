package net.xdexamples.jse.examples.java.net.spi;

import org.junit.Test;
import net.xdexamples.AllMethodsCovered;
import xdtest.ToBeContinued;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.spi.InetAddressResolver;
import java.net.spi.InetAddressResolver.LookupPolicy;
import java.util.stream.Stream;

import static net.xdexamples.ExampleUtils.ignore;
import static net.xdexamples.ExampleUtils.makeInstance;
import static net.xdexamples.ExampleUtils.skip;

@ToBeContinued
public class InetAddressResolverExample {

    public void scaffold() throws UnknownHostException {
        if (skip()) {
            String host = null;
            byte[] address = new byte[0];
            LookupPolicy lookupPolicy = null;
            InetAddressResolver instance = makeInstance(InetAddressResolver.class);
            Stream<InetAddress> inetAddressStream = instance.lookupByName(host, lookupPolicy);
            String s = instance.lookupByAddress(address);
        }
    }

    @AllMethodsCovered
    public static class LookupPolicyExample {
        public void scaffold() {
            if (skip()) {
                LookupPolicy instance = makeInstance(LookupPolicy.class);
                int characteristics = 0;
                LookupPolicy of = LookupPolicy.of(characteristics);
                int characteristics1 = instance.characteristics();
                int ipv4 = LookupPolicy.IPV4;
                int ipv6 = LookupPolicy.IPV6;
                int ipv4First = LookupPolicy.IPV4_FIRST;
                int ipv6First = LookupPolicy.IPV6_FIRST;
            }
        }

        @Test
        public void example() {

            int ipv4 = LookupPolicy.IPV4;
            int ipv6 = LookupPolicy.IPV6;
            int ipv4First = LookupPolicy.IPV4_FIRST;
            int ipv6First = LookupPolicy.IPV6_FIRST;

            // Request IPv4 addresses
            ignore(LookupPolicy.of(ipv4));

            // Request IPv6 address
            ignore(LookupPolicy.of(ipv6));

            // Request an IPv4 or IPv6 address
            ignore(LookupPolicy.of(ipv4 | ipv6));

            // Request an IPv4 or IPv6 address, prefer IPv4
            ignore(LookupPolicy.of(ipv4 | ipv6 | ipv4First));

            // Request an IPv4 or IPv6 address, prefer IPv6
            ignore(LookupPolicy.of(ipv4 | ipv6 | ipv6First));
        }
    }


}

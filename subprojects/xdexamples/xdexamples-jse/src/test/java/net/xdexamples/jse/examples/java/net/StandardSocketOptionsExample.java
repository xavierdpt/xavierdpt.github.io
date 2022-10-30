package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;

@ToBeContinued
public class StandardSocketOptionsExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            SocketOption<Boolean> soBroadcast = StandardSocketOptions.SO_BROADCAST;
            SocketOption<Boolean> soKeepalive = StandardSocketOptions.SO_KEEPALIVE;
            SocketOption<Integer> soSndbuf = StandardSocketOptions.SO_SNDBUF;
            SocketOption<Integer> soRcvbuf = StandardSocketOptions.SO_RCVBUF;
            SocketOption<Boolean> soReuseaddr = StandardSocketOptions.SO_REUSEADDR;
            SocketOption<Boolean> soReuseport = StandardSocketOptions.SO_REUSEPORT;
            SocketOption<Integer> soLinger = StandardSocketOptions.SO_LINGER;
            SocketOption<Integer> ipTos = StandardSocketOptions.IP_TOS;
            SocketOption<NetworkInterface> ipMulticastIf = StandardSocketOptions.IP_MULTICAST_IF;
            SocketOption<Integer> ipMulticastTtl = StandardSocketOptions.IP_MULTICAST_TTL;
            SocketOption<Boolean> ipMulticastLoop = StandardSocketOptions.IP_MULTICAST_LOOP;
            SocketOption<Boolean> tcpNodelay = StandardSocketOptions.TCP_NODELAY;
        }
    }

}

package net.xdexamples.jse.examples.java.net;

import net.xdexamples.ExampleUtils;
import xdtest.Interface;
import xdtest.ToBeContinued;

import java.net.SocketException;
import java.net.SocketOptions;

@Interface
@ToBeContinued
public class SocketOptionsExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            SocketOptions instance = ExampleUtils.makeInstance(SocketOptions.class);
            int id = 0;
            Object option = instance.getOption(id);
            instance.setOption(id, option);
            int tcpNodelay = SocketOptions.TCP_NODELAY;
            int soBindaddr = SocketOptions.SO_BINDADDR;
            int soReuseaddr = SocketOptions.SO_REUSEADDR;
            int soReuseport = SocketOptions.SO_REUSEPORT;
            int soBroadcast = SocketOptions.SO_BROADCAST;
            int ipMulticastIf = SocketOptions.IP_MULTICAST_IF;
            int ipMulticastIf2 = SocketOptions.IP_MULTICAST_IF2;
            int ipMulticastLoop = SocketOptions.IP_MULTICAST_LOOP;
            int ipTos = SocketOptions.IP_TOS;
            int soLinger = SocketOptions.SO_LINGER;
            int soTimeout = SocketOptions.SO_TIMEOUT;
            int soSndbuf = SocketOptions.SO_SNDBUF;
            int soRcvbuf = SocketOptions.SO_RCVBUF;
            int soKeepalive = SocketOptions.SO_KEEPALIVE;
            int soOobinline = SocketOptions.SO_OOBINLINE;
        }
    }

}

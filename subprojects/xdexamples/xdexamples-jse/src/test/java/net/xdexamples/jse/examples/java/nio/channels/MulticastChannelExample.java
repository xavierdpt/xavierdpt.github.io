package net.xdexamples.jse.examples.java.nio.channels;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.channels.MembershipKey;
import java.nio.channels.MulticastChannel;

@Scaffolded
public class MulticastChannelExample extends BaseExample<MulticastChannel> {

    @Override
    protected void scaffold(MulticastChannel instance) throws Throwable {
        instance.close();
        InetAddress groupInetAddress = null;
        NetworkInterface networkInterface = null;
        InetAddress sourceInetAddress = null;
        MembershipKey join = instance.join(groupInetAddress, networkInterface);
        MembershipKey join1 = instance.join(groupInetAddress, networkInterface, sourceInetAddress);
    }
}

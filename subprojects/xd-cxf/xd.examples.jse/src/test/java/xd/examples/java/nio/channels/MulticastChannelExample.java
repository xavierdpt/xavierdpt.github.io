package xd.examples.java.nio.channels;

import xd.ExampleUtils;
import xdtest.Interface;
import xdtest.Scaffolded;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.channels.MembershipKey;
import java.nio.channels.MulticastChannel;

@Scaffolded
@Interface
public class MulticastChannelExample {
    public void scaffold() throws IOException {
        if (ExampleUtils.skip()) {
            MulticastChannel instance = ExampleUtils.makeInstance(MulticastChannel.class);
            instance.close();
            InetAddress groupInetAddress = null;
            NetworkInterface networkInterface = null;
            InetAddress sourceInetAddress = null;
            MembershipKey join = instance.join(groupInetAddress, networkInterface);
            MembershipKey join1 = instance.join(groupInetAddress, networkInterface, sourceInetAddress);
        }
    }
}

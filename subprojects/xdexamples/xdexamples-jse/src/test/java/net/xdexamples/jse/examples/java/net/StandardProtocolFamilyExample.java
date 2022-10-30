package net.xdexamples.jse.examples.java.net;

import net.xdexamples.BaseExample;
import net.xdexamples.Scaffolded;

import java.net.StandardProtocolFamily;


@Scaffolded
public class StandardProtocolFamilyExample extends BaseExample<StandardProtocolFamily> {

    @Override
    protected void scaffold(StandardProtocolFamily instance) throws Throwable {
        StandardProtocolFamily inet = StandardProtocolFamily.INET;
        StandardProtocolFamily inet6 = StandardProtocolFamily.INET6;
        StandardProtocolFamily unix = StandardProtocolFamily.UNIX;
    }
}

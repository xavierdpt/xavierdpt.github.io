package net.xdexamples.jse.examples.java.net;

import net.xdexamples.support.internal.BaseExample;
import net.xdexamples.support.internal.Scaffolded;

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

package net.xdexamples.jse.examples.java.net;

import net.xdexamples.support.internal.BaseExample;

import java.net.Socket;



public class SocketImplExample extends BaseExample<Socket> {

        @Override
    protected void scaffold(Socket instance) throws Throwable {
        String s = instance.toString();
    }
}

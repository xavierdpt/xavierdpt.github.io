package net.xdexamples.jse.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import net.xdexamples.ExampleUtils;
import xdtest.ToBeContinued;

import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.URL;

@ToBeContinued
public class AuthenticatorExample {
    public void scaffold() {
        if (ExampleUtils.skip()) {
            Authenticator instance = ExampleUtils.makeInstance(Authenticator.class);
            Authenticator authenticator = Authenticator.getDefault();
            Authenticator.setDefault(authenticator);
            InetAddress address = null;
            int port = 0;
            String protocol = null;
            String prompt = null;
            String scheme = null;
            String host = null;
            URL url = null;
            RequestorType requestorType = null;
            Authenticator.requestPasswordAuthentication(address, port, protocol, prompt, scheme);
            Authenticator.requestPasswordAuthentication(host, address, port, protocol, prompt, scheme);
            Authenticator.requestPasswordAuthentication(host, address, port, protocol, prompt, scheme, url, requestorType);
            Authenticator.requestPasswordAuthentication(authenticator, host, address, port, protocol, prompt, scheme, url, requestorType);
            instance.requestPasswordAuthenticationInstance(host, address, port, protocol, prompt, scheme, url, requestorType);
        }
    }

    @Test
    public void example() {
        // No default authenticator
        Assert.assertNull(Authenticator.getDefault());
    }
}

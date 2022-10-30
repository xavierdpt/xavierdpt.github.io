package net.xdexamples.jse.examples.java.net;

import net.xdexamples.AllMethodsCovered;
import net.xdexamples.ExampleUtils;
import org.junit.Assert;
import org.junit.Test;

import java.net.PasswordAuthentication;
import java.net.SocketException;

@AllMethodsCovered
public class PasswordAuthenticationExample {

    public void scaffold() throws SocketException {
        if (ExampleUtils.skip()) {
            PasswordAuthentication instance = ExampleUtils.makeInstance(PasswordAuthentication.class);
            String userName = null;
            char[] password = new char[0];
            PasswordAuthentication passwordAuthentication = new PasswordAuthentication(userName, password);
            String userName1 = instance.getUserName();
            char[] password1 = instance.getPassword();
        }
    }

    @Test
    public void example() {
        // PasswordAuthentication simply holds a username and a password
        String userName = "john";
        String password = "hello";
        PasswordAuthentication authentication = new PasswordAuthentication(userName, password.toCharArray());
        Assert.assertEquals(userName, authentication.getUserName());
        Assert.assertEquals(password, new String(authentication.getPassword()));
    }
}

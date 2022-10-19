package xd.examples.java.net;

import org.junit.Assert;
import org.junit.Test;
import xd.ExampleUtils;
import xdtest.Done;

import java.net.PasswordAuthentication;
import java.net.SocketException;

@Done
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

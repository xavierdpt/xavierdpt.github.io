package net.xdexamples.jse.examples.java.lang;

import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import static org.junit.Assert.assertNull;

public class ClassExample_x {

    @Test
    public void example() throws NoSuchAlgorithmException, NoSuchProviderException {
        {
            // Most classes are not signed
            Class<?> clazz = Object.class;
            Object[] signers = clazz.getSigners();
            assertNull(signers);
        }
    }


}

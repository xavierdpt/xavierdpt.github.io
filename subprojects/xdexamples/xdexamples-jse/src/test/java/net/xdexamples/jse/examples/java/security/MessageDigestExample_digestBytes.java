package net.xdexamples.jse.examples.java.security;

import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static net.xdexamples.helpers.ExampleHelper.bytesToHex;

public class MessageDigestExample_digestBytes {

    @Test
    public void example() throws NoSuchAlgorithmException {

        // Obtain an instance of a digest, here we choose MD5
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        // Convert a string to byte for inputs
        byte[] bytes = "hello".getBytes(StandardCharsets.UTF_8);

        // Compute the digest
        byte[] result = messageDigest.digest(bytes);

        // Convert the bytes to an hexadecimal string
        String toHex = bytesToHex(result);

        // Check the result
        Assert.assertEquals("5D 41 40 2A BC 4B 2A 76 B9 71 9D 91 10 17 C5 92", toHex);
    }

}

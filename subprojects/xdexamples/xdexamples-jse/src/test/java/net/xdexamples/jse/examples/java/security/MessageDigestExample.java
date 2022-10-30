package net.xdexamples.jse.examples.java.security;

import net.xdexamples.BaseExample;
import net.xdexamples.Bundle;
import net.xdexamples.EBundle;
import net.xdexamples.support.Example;
import net.xdexamples.support.Examples;
import net.xdexamples.helpers.ExampleHelper;

import java.nio.ByteBuffer;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

@Bundle(EBundle.CRYPTO)
@Examples(
        @Example(
                value = MessageDigestExample_digestBytes.class,
                illustratedMethods = "getInstance,digest"
        )
)
public class MessageDigestExample extends BaseExample<MessageDigest> {

    @Override
    @SuppressWarnings("unused")
    protected void scaffold(MessageDigest instance) throws DigestException, CloneNotSupportedException, NoSuchAlgorithmException, NoSuchProviderException {
        {
            Object clone = instance.clone();
        }
        {
            byte[] digest = instance.digest();
        }
        {
            byte[] bytes = any();
            byte[] digest = instance.digest(bytes);
        }
        {
            byte[] bytes = any();
            int offset = any();
            int length = any();
            int digest = instance.digest(bytes, offset, length);
        }
        {
            String algorithm = instance.getAlgorithm();
        }
        {
            int digestLength = instance.getDigestLength();
        }
        {
            String algorithm = any();
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        }
        {
            String algorithm = any();
            String providerName = any();
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm, providerName);
        }
        {
            String algorithm = any();
            Provider provider = any();
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm, provider);
        }
        {
            Provider provider = instance.getProvider();
        }
        {

            byte[] bytes1 = any();
            byte[] bytes2 = any();
            boolean result = MessageDigest.isEqual(bytes1, bytes2);
        }
        {
            instance.reset();
        }
        {
            String string = instance.toString();
        }
        {
            byte b = any();
            instance.update(b);
        }
        {
            byte[] bytes = any();
            int offset = any();
            int length = any();
            instance.update(bytes, offset, length);
        }
        {
            byte[] bytes = any();
            instance.update(bytes);
        }
        {
            ByteBuffer byteBuffer = any();
            instance.update(byteBuffer);
        }
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        for (Provider provider : Security.getProviders()) {
            String providerName = provider.getName();
            for (Provider.Service service : provider.getServices()) {
                String type = service.getType();
                if ("MessageDigest".equals(type)) {
                    String algorithm = service.getAlgorithm();
                    MessageDigest messageDigest = MessageDigest.getInstance(algorithm, provider);
                    byte[] digest = messageDigest.digest(new byte[]{});
                    String digestStr = ExampleHelper.bytesToHex(digest);
                    System.out.println(providerName + "/" + algorithm + ": " + digestStr);
                }
            }
        }
    }


}

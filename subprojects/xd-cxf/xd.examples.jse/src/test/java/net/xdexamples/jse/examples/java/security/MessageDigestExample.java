package net.xdexamples.jse.examples.java.security;

import net.xdexamples.BaseExample;
import xdtest.TestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

public class MessageDigestExample extends BaseExample<MessageDigest> {

    @Override
    protected void scaffold(MessageDigest instance) throws Throwable {
/*
clone
digest
digest
digest
getAlgorithm
getDigestLength
getInstance
getInstance
getInstance
getProvider
isEqual
reset
toString
update
update
update
update
 */
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
                    String digestStr = TestUtils.bytesToHex(digest);
                    System.out.println(providerName + "/" + algorithm + ": " + digestStr);
                }
            }
        }
    }


}

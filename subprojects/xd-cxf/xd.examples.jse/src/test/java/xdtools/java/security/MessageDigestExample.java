package xdtools.java.security;

import xdtest.TestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;

public class MessageDigestExample {
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

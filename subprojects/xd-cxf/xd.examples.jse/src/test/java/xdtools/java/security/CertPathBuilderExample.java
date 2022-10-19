package xdtools.java.security;

import xdtest.TestUtils;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertificateEncodingException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.util.HashSet;

public class CertPathBuilderExample {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, CertPathBuilderException, CertificateEncodingException {
        for (Provider provider : Security.getProviders()) {
            String providerName = provider.getName();
            for (Provider.Service service : provider.getServices()) {
                String type = service.getType();
                if ("CertPathBuilder".equals(type)) {
                    String algorithm = service.getAlgorithm();
                    String key = providerName + "/" + algorithm;
                    System.out.println(key);
                    CertPathBuilder certPathBuilder = CertPathBuilder.getInstance(algorithm, provider);
                    HashSet<TrustAnchor> trustAnchors = new HashSet<>();
                    TrustAnchor trustAnchor = createTrustAnchor();
                    trustAnchors.add(trustAnchor);
                    X509CertSelector selector = new X509CertSelector();
                    PKIXBuilderParameters parameters = new PKIXBuilderParameters(trustAnchors, selector);
                    CertPathBuilderResult result = certPathBuilder.build(parameters);
                    CertPath certPath = result.getCertPath();
                    byte[] encoded = certPath.getEncoded();
                    System.out.println(TestUtils.bytesToHex(encoded));

                }
            }
        }
    }

    private static TrustAnchor createTrustAnchor() throws NoSuchAlgorithmException {
        // TODO
        KeyPairGenerator rsa = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = rsa.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        return new TrustAnchor("caName", publicKey, new byte[0]);
    }

}

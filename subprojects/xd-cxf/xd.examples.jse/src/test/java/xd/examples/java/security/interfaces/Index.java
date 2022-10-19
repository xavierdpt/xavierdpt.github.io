package xd.examples.java.security.interfaces;

import java.security.interfaces.DSAKey;
import java.security.interfaces.DSAKeyPairGenerator;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.EdECKey;
import java.security.interfaces.EdECPrivateKey;
import java.security.interfaces.EdECPublicKey;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.interfaces.XECKey;
import java.security.interfaces.XECPrivateKey;
import java.security.interfaces.XECPublicKey;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    DSAKey.class,
                    DSAKeyPairGenerator.class,
                    DSAParams.class,
                    DSAPrivateKey.class,
                    DSAPublicKey.class,
                    ECKey.class,
                    ECPrivateKey.class,
                    ECPublicKey.class,
                    EdECKey.class,
                    EdECPrivateKey.class,
                    EdECPublicKey.class,
                    RSAKey.class,
                    RSAMultiPrimePrivateCrtKey.class,
                    RSAPrivateCrtKey.class,
                    RSAPrivateKey.class,
                    RSAPublicKey.class,
                    XECKey.class,
                    XECPrivateKey.class,
                    XECPublicKey.class
            ));
        }
    }
}

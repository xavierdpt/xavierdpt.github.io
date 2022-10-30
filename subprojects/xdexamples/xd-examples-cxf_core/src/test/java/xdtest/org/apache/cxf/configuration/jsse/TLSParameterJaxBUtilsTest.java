package xdtest.org.apache.cxf.configuration.jsse;

import org.apache.cxf.configuration.jsse.TLSParameterJaxBUtils;
import org.apache.cxf.configuration.security.CertStoreType;
import org.apache.cxf.configuration.security.KeyManagersType;
import org.apache.cxf.configuration.security.KeyStoreType;
import org.apache.cxf.configuration.security.SecureRandomParameters;
import org.apache.cxf.configuration.security.TrustManagersType;
import org.junit.Before;
import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import static org.junit.Assert.assertEquals;

public class TLSParameterJaxBUtilsTest {


    @Test
    public void testSecureRandom() throws GeneralSecurityException {
        // Get a secure random algorithm and provider name
        SecureRandom aSecureRandom = SecureRandom.getInstanceStrong();
        String secureRandomAlgorithm = aSecureRandom.getAlgorithm();
        String secureRandomProvider = aSecureRandom.getProvider().getName();

        // Initialize secure random parameters
        SecureRandomParameters secureRandomParameters = new SecureRandomParameters();
        secureRandomParameters.setAlgorithm(secureRandomAlgorithm);
        secureRandomParameters.setProvider(secureRandomProvider);

        // Obtain a secure random
        SecureRandom secureRandom = TLSParameterJaxBUtils.getSecureRandom(secureRandomParameters);

        // Verify the algorithm and provider name
        assertEquals(secureRandomAlgorithm, secureRandom.getAlgorithm());
        assertEquals(secureRandomProvider, secureRandom.getProvider().getName());
    }

    @Test
    public void test() throws GeneralSecurityException, IOException {

        if (TestUtils.principle()) {

            KeyStoreType keyStoreType = new KeyStoreType();
            KeyStore keyStore = TLSParameterJaxBUtils.getKeyStore(keyStoreType);
            boolean trustStore = true;
            KeyStore keyStore1 = TLSParameterJaxBUtils.getKeyStore(keyStoreType, trustStore);

            CertStoreType certStoreType = new CertStoreType();
            KeyStore keyStore2 = TLSParameterJaxBUtils.getKeyStore(certStoreType);

            KeyManagersType keyManagersType = new KeyManagersType();
            KeyManager[] keyManagers = TLSParameterJaxBUtils.getKeyManagers(keyManagersType);

            KeyManager[] aliases = TLSParameterJaxBUtils.getKeyManagers(keyManagersType, "alias");

            TrustManagersType trustManagersType = new TrustManagersType();
            boolean enableRevocation = false;
            TrustManager[] trustManagers = TLSParameterJaxBUtils.getTrustManagers(trustManagersType, enableRevocation);
        }
    }
}

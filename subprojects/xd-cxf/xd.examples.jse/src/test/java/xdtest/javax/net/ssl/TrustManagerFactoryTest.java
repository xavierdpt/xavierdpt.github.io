package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

public class TrustManagerFactoryTest {
    @Test
    public void test() throws NoSuchAlgorithmException, NoSuchProviderException, KeyStoreException {
        if (TestUtils.scaffold()) {
            TrustManagerFactory instance = TestUtils.makeInstance(TrustManagerFactory.class);
            String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            String algorithm = instance.getAlgorithm();
            TrustManagerFactory instance1 = TrustManagerFactory.getInstance(algorithm);
            String providerName = null;
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(algorithm, providerName);
            Provider provider = null;
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(algorithm, provider);
            Provider provider1 = instance.getProvider();
            KeyStore keyStore = null;
            instance.init(keyStore);
            KeyStore managerFactoryParameters = null;
            instance.init(managerFactoryParameters);
            TrustManager[] trustManagers = instance.getTrustManagers();
        }
    }
}

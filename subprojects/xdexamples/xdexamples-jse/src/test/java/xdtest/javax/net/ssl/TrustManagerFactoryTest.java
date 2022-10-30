package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;

public class TrustManagerFactoryTest extends BaseExample<TrustManagerFactory> {

    @Override
    protected void scaffold(TrustManagerFactory instance) throws NoSuchAlgorithmException, NoSuchProviderException, KeyStoreException {
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

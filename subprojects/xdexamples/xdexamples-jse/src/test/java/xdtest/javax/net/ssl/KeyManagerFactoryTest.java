package xdtest.javax.net.ssl;

import net.xdexamples.support.internal.BaseExample;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.ManagerFactoryParameters;
import java.security.KeyStore;
import java.security.Provider;

public class KeyManagerFactoryTest extends BaseExample<KeyManagerFactory> {

    @Override
    protected void scaffold(KeyManagerFactory instance) throws Throwable {
        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        String algorithm = instance.getAlgorithm();
        KeyManagerFactory instance1 = KeyManagerFactory.getInstance(algorithm);
        String provider = null;
        KeyManagerFactory instance2 = KeyManagerFactory.getInstance(algorithm, provider);
        Provider provider1 = instance.getProvider();
        KeyStore keyStore = null;
        char[] password = new char[0];
        instance.init(keyStore, password);
        ManagerFactoryParameters parameters = null;
        instance.init(parameters);
        KeyManager[] keyManagers = instance.getKeyManagers();
    }
}

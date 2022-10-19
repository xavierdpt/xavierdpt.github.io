package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.ManagerFactoryParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.UnrecoverableKeyException;

public class KeyManagerFactoryTest {
    @Test
    public void test() throws NoSuchAlgorithmException, NoSuchProviderException, UnrecoverableKeyException, KeyStoreException, InvalidAlgorithmParameterException {
        if (TestUtils.scaffold()) {
            KeyManagerFactory instance = TestUtils.makeInstance(KeyManagerFactory.class);
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
}

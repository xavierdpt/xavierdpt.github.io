package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

public class KeyManagerFactorySpiTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            KeyManagerFactorySpi instance = new KeyManagerFactorySpi() {
                @Override
                protected void engineInit(KeyStore ks, char[] password) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {

                }

                @Override
                protected void engineInit(ManagerFactoryParameters spec) throws InvalidAlgorithmParameterException {

                }

                @Override
                protected KeyManager[] engineGetKeyManagers() {
                    return new KeyManager[0];
                }
            };
        }
    }
}

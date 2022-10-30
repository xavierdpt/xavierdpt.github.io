package xdtest.org.apache.cxf.configuration.jsse;

import org.apache.cxf.configuration.jsse.SSLUtils;
import org.apache.cxf.configuration.security.FiltersType;
import org.junit.Test;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Logger;


public class SSLUtilsTest {
    @Test
    public void test() throws NoSuchAlgorithmException, KeyManagementException {
        Logger log = Logger.getLogger("logger");
        KeyManager[] defaultKeyStoreManagers = SSLUtils.getDefaultKeyStoreManagers(log);
        TrustManager[] defaultTrustStoreManagers = SSLUtils.getDefaultTrustStoreManagers(log);

        KeyManagerFactory keyManagerFactory = null;
        KeyStore keyStore = null;
        InputStream inputStream = null;
        String keyStoreLocation = null;
        String keyStorePassword = null;
        KeyManager[] keyManagers = SSLUtils.loadKeyStore(keyManagerFactory, keyStore, inputStream, keyStoreLocation, keyStorePassword, log);

        String keystore = SSLUtils.getKeystore(keyStoreLocation, log);

        String keyStoreType = null;
        String keystoreType = SSLUtils.getKeystoreType(keyStoreType, log);

        String def = null;
        String keystoreType1 = SSLUtils.getKeystoreType(keyStoreType, log, def);

        String keyStoreProvider = null;
        String keystoreProvider = SSLUtils.getKeystoreProvider(keyStoreProvider, log);

        String keystorePassword = SSLUtils.getKeystorePassword(keyStorePassword, log);

        String keyPassword = null;
        String keyPassword1 = SSLUtils.getKeyPassword(keyPassword, log);

        String keyStoreAlgorithm = null;
        String keystoreAlgorithm = SSLUtils.getKeystoreAlgorithm(keyStoreAlgorithm, log);

        String trustStoreAlgorithm = null;
        String trustStoreAlgorithm1 = SSLUtils.getTrustStoreAlgorithm(trustStoreAlgorithm, log);

        String protocol = null;
        KeyManager[] keyStoreManagers = new KeyManager[0];
        TrustManager[] trustStoreManagers = new TrustManager[0];
        SSLContext sslContext = SSLUtils.getSSLContext(protocol, keyStoreManagers, trustStoreManagers);

        String[] supportedCipherSuites = SSLUtils.getSupportedCipherSuites(sslContext);

        String[] serverSupportedCipherSuites = SSLUtils.getServerSupportedCipherSuites(sslContext);

        List<String> cipherSuites = null;
        FiltersType filters = null;
        String[] defaultCipherSuites = new String[0];
        String[] ciphersuitesToInclude = SSLUtils.getCiphersuitesToInclude(cipherSuites, filters, defaultCipherSuites, supportedCipherSuites, log);

        boolean exclude = true;
        String[] filteredCiphersuites = SSLUtils.getFilteredCiphersuites(filters, supportedCipherSuites, log, exclude);

        String truststoreLocation = null;
        String truststore = SSLUtils.getTruststore(truststoreLocation, log);

        String truststoreType = null;
        String trustStoreType = SSLUtils.getTrustStoreType(truststoreType, log);

        String trustStoreType1 = SSLUtils.getTrustStoreType(truststoreType, log, def);

        String password = null;
        String truststorePassword = SSLUtils.getTruststorePassword(password, log);

        String provider = null;
        String truststoreProvider = SSLUtils.getTruststoreProvider(provider, log);


    }
}

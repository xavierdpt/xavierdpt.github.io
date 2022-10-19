package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;
import java.security.AlgorithmConstraints;
import java.util.Collection;
import java.util.List;

public class SSLParametersTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            SSLParameters instance = new SSLParameters();
            String[] cipherSuites = new String[0];
            SSLParameters sslParameters = new SSLParameters(cipherSuites);
            String[] protocols = new String[0];
            SSLParameters sslParameters1 = new SSLParameters(cipherSuites, protocols);

            String[] cipherSuites1 = instance.getCipherSuites();
            instance.setCipherSuites(cipherSuites1);

            String[] protocols1 = instance.getProtocols();
            instance.setProtocols(protocols1);

            boolean wantClientAuth = instance.getWantClientAuth();
            instance.setWantClientAuth(wantClientAuth);

            boolean needClientAuth = instance.getNeedClientAuth();
            instance.setNeedClientAuth(needClientAuth);

            AlgorithmConstraints algorithmConstraints = instance.getAlgorithmConstraints();
            instance.setAlgorithmConstraints(algorithmConstraints);

            String endpointIdentificationAlgorithm = instance.getEndpointIdentificationAlgorithm();
            instance.setEndpointIdentificationAlgorithm(endpointIdentificationAlgorithm);

            List<SNIServerName> serverNames = null;
            instance.setServerNames(serverNames);

            List<SNIServerName> serverNames1 = instance.getServerNames();

            Collection<SNIMatcher> matchers = null;
            instance.setSNIMatchers(matchers);

            Collection<SNIMatcher> sniMatchers = instance.getSNIMatchers();

            boolean honorOrder = false;
            instance.setUseCipherSuitesOrder(honorOrder);
            boolean useCipherSuitesOrder = instance.getUseCipherSuitesOrder();

            boolean enableRetransmission = false;
            instance.setEnableRetransmissions(enableRetransmission);
            boolean enableRetransmissions = instance.getEnableRetransmissions();

            int maximumPacketSize = 0;
            instance.setMaximumPacketSize(maximumPacketSize);
            int maximumPacketSize1 = instance.getMaximumPacketSize();

            String[] applicationProtocols = instance.getApplicationProtocols();
            instance.setApplicationProtocols(applicationProtocols);


        }
    }
}

package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.X509KeyManager;
import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class X509KeyManagerTest extends BaseExample<X509KeyManager> {

    @Override
    protected void scaffold(X509KeyManager instance) throws Throwable {
        String keyType = null;
        Principal[] issuers = new Principal[0];
        String[] clientAliases = instance.getClientAliases(keyType, issuers);
        Socket socket = null;
        String[] keyTypes = new String[0];
        String s = instance.chooseClientAlias(keyTypes, issuers, socket);
        String[] serverAliases = instance.getServerAliases(keyType, issuers);
        String s1 = instance.chooseServerAlias(keyType, issuers, socket);
        String alias = null;
        X509Certificate[] certificateChain = instance.getCertificateChain(alias);
        PrivateKey privateKey = instance.getPrivateKey(alias);
    }
}

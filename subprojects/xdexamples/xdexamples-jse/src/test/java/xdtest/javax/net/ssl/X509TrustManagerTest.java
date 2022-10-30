package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;

public class X509TrustManagerTest extends BaseExample<X509TrustManager> {

    @Override
    protected void scaffold(X509TrustManager instance) throws Throwable {
        X509Certificate[] chain = new X509Certificate[0];
        String authType = null;
        instance.checkServerTrusted(chain,authType);
        instance.checkClientTrusted(chain,authType);
        X509Certificate[] acceptedIssuers = instance.getAcceptedIssuers();
    }
}

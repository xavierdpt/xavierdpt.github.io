package xdtest.javax.net.ssl;

import net.xdexamples.support.internal.BaseExample;

import javax.net.ssl.CertPathTrustManagerParameters;
import java.security.cert.CertPathParameters;

public class CertPathTrustManagerParametersTest extends BaseExample<CertPathTrustManagerParameters> {

    @Override
    protected void scaffold(CertPathTrustManagerParameters instance) throws Throwable {
        CertPathParameters parameters = null;
        CertPathTrustManagerParameters instance2 = new CertPathTrustManagerParameters(parameters);
        CertPathParameters parameters1 = instance.getParameters();
    }
}

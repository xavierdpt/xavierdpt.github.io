package xdtools.java.security;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class CertificateFactoryExample {
    public static void main(String[] args) throws CertificateException {
        CertificateFactory factory = CertificateFactory.getInstance("X.509");
        InputStream inputStream = new ByteArrayInputStream(new byte[]{});
        factory.generateCertificate(inputStream);
    }
}

package xd;

import xdtest.java.security.ServicesDumper;
import xdtools.java.net.NetworkInterfaceDumper;
import xdtools.java.security.AlgorithmParameterGeneratorExample;
import xdtools.java.security.AlgorithmParametersExample;
import xdtools.java.security.CertPathBuilderExample;
import xdtools.java.security.CertificateFactoryExample;
import xdtools.java.security.MessageDigestExample;
import xdtools.java.security.ProviderDumper;

public class Index {
    public static void main(String[] args) {
        Class<?>[] classes = new Class<?>[]{
                ProviderDumper.class,
                ServicesDumper.class,
                NetworkInterfaceDumper.class,
                MessageDigestExample.class,
                AlgorithmParameterGeneratorExample.class,
                AlgorithmParametersExample.class,
                CertPathBuilderExample.class,
                CertificateFactoryExample.class
        };
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getName());
        }
    }
}

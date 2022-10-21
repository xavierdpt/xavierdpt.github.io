package xd;

import net.xdexamples.jse.examples.java.security.AlgorithmParameterGeneratorExample;
import xdtest.java.security.ServicesDumper;
import xdtools.java.net.NetworkInterfaceDumper;
import net.xdexamples.jse.examples.java.security.AlgorithmParametersExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathBuilderExample;
import net.xdexamples.jse.examples.java.security.MessageDigestExample;
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
                CertPathBuilderExample.class
        };
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getName());
        }
    }
}

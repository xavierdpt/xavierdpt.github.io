package net.xdexamples.jse.examples.java.security;

import net.xdexamples.BaseExample;
import net.xdexamples.helpers.ExampleHelper;
import xdtest.TestUtils;

import javax.crypto.spec.DHParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmParameterGeneratorExample extends BaseExample<AlgorithmParameterGenerator> {


    @Override
    protected void scaffold(AlgorithmParameterGenerator instance) throws Throwable {
/*
generateParameters
getAlgorithm
getInstance
getInstance
getInstance
getProvider
init
init
init
init
 */
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidParameterSpecException {
        for (Provider provider : Security.getProviders()) {
            String providerName = provider.getName();
            for (Provider.Service service : provider.getServices()) {
                String type = service.getType();
                if ("AlgorithmParameterGenerator".equals(type)) {
                    String algorithm = service.getAlgorithm();
                    AlgorithmParameterGenerator generator = AlgorithmParameterGenerator.getInstance(algorithm, provider);
                    AlgorithmParameters parameters = generator.generateParameters();
                    byte[] encoded = parameters.getEncoded();
                    System.out.println(providerName + "/" + algorithm);
                    System.out.println(ExampleHelper.bytesToHex(encoded));
                    AlgorithmParameterSpec spec = findParameterSpec(parameters);
                    if (DSAParameterSpec.class.equals(spec.getClass())) {
                        dumpDSAParameterSpec((DSAParameterSpec) spec);
                    }
                    if (DHParameterSpec.class.equals(spec.getClass())) {
                        dumpDHParameterSpec((DHParameterSpec) spec);
                    }
                }
            }
        }

    }

    private static void dumpDSAParameterSpec(DSAParameterSpec spec) {
        BigInteger g = spec.getG();
        BigInteger p = spec.getP();
        BigInteger q = spec.getQ();
        System.out.println("G: " + g);
        System.out.println("P: " + p);
        System.out.println("Q: " + q);
    }

    private static void dumpDHParameterSpec(DHParameterSpec spec) {
        BigInteger g = spec.getG();
        int l = spec.getL();
        BigInteger p = spec.getP();
        System.out.println("G: " + g);
        System.out.println("L: " + l);
        System.out.println("P: " + p);
    }

    private static AlgorithmParameterSpec findParameterSpec(AlgorithmParameters parameters) {
        List<Class<? extends AlgorithmParameterSpec>> classes = new ArrayList<>();
        classes.add(DSAParameterSpec.class);
        classes.add(DHParameterSpec.class);
        AlgorithmParameterSpec spec = null;
        for (Class<? extends AlgorithmParameterSpec> clazz : classes) {
            try {
                spec = parameters.getParameterSpec(clazz);
            } catch (InvalidParameterSpecException e) {
                // ignored
            }
        }
        if (spec == null) {
            try {
                parameters.getParameterSpec(classes.get(0));
            } catch (InvalidParameterSpecException e) {
                throw new RuntimeException(e);
            }
        }
        return spec;
    }


}

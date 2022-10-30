package xdtest.java.security;

import net.xdexamples.support.internal.BaseExample;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.SecureRandom;

public class AlgorithmParameterGeneratorTest extends BaseExample<AlgorithmParameterGenerator> {

    @Override
    protected void scaffold(AlgorithmParameterGenerator instance) throws Throwable {
        String algorithm = instance.getAlgorithm();
        AlgorithmParameterGenerator instance1 = AlgorithmParameterGenerator.getInstance(algorithm);
        Provider provider = null;
        AlgorithmParameterGenerator instance2 = AlgorithmParameterGenerator.getInstance(algorithm, provider);
        Provider providerName = null;
        AlgorithmParameterGenerator instance3 = AlgorithmParameterGenerator.getInstance(algorithm, providerName);
        int size = 0;
        instance.init(size);
        SecureRandom secureRandom = null;
        instance.init(size, secureRandom);
        int parameters = 0;
        instance.init(parameters);
        instance.init(parameters, secureRandom);
        AlgorithmParameters algorithmParameters = instance.generateParameters();
    }
}

package xdtest.java.security;

import org.junit.Test;
import xdtest.TestUtils;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;

public class AlgorithmParameterGeneratorTest {
    @Test
    public void test() throws NoSuchAlgorithmException {
        if (TestUtils.scaffold()) {
            AlgorithmParameterGenerator instance = TestUtils.makeInstance(AlgorithmParameterGenerator.class);
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
}

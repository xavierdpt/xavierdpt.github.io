package xdtest.java.security;

import org.junit.Test;
import xdtest.TestUtils;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

public class AlgorithmParametersTest {
    @Test
    public void test() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidParameterSpecException, IOException {
        if (TestUtils.scaffold()) {
            AlgorithmParameters instance = TestUtils.makeInstance(AlgorithmParameters.class);
            String algorithm = instance.getAlgorithm();
            AlgorithmParameters instance1 = AlgorithmParameters.getInstance(algorithm);
            Provider provider = null;
            AlgorithmParameters instance2 = AlgorithmParameters.getInstance(algorithm, provider);
            String providerName = null;
            AlgorithmParameters instance3 = AlgorithmParameters.getInstance(algorithm, providerName);
            Provider provider1 = instance.getProvider();
            AlgorithmParameterSpec parameters = null;
            instance.init(parameters);
            byte[] bytes = new byte[0];
            instance.init(bytes);
            String format = null;
            instance.init(bytes, format);
            Dummy parameterSpec = instance.getParameterSpec(Dummy.class);
            byte[] encoded = instance.getEncoded();
            byte[] encoded1 = instance.getEncoded(format);
            String s = instance.toString();
        }
    }

    public static interface Dummy extends AlgorithmParameterSpec {
    }
}

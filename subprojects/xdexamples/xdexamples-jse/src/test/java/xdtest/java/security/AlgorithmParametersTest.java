package xdtest.java.security;

import net.xdexamples.BaseExample;
import net.xdexamples.jse.examples.java.security.AlgorithmParametersExample;

import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;

public class AlgorithmParametersTest extends BaseExample<AlgorithmParameters> {

    @Override
    protected void scaffold(AlgorithmParameters instance) throws Throwable {
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
        AlgorithmParametersExample.DummyAlgorithmParameterSpec parameterSpec = instance.getParameterSpec(AlgorithmParametersExample.DummyAlgorithmParameterSpec.class);
        byte[] encoded = instance.getEncoded();
        byte[] encoded1 = instance.getEncoded(format);
        String s = instance.toString();
    }

}

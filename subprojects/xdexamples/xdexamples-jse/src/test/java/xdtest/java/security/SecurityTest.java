package xdtest.java.security;

import net.xdexamples.support.internal.BaseExample;
import xdtest.SeeAlso;
import xdtools.java.security.ProviderDumper;

import java.security.Provider;
import java.security.Security;
import java.util.Map;
import java.util.Set;

@SeeAlso({ProviderDumper.class})
public class SecurityTest extends BaseExample<Security> {

    @Override
    protected void scaffold(Security instance) throws Throwable {
        String algorithmName = null;
        String propertyName = null;
        String algorithmProperty = Security.getAlgorithmProperty(algorithmName, propertyName);
        Provider provider = null;
        int position = 0;
        int i = Security.insertProviderAt(provider, position);
        int i1 = Security.addProvider(provider);
        String providerName = null;
        Security.removeProvider(providerName);
        String filterStr = null;
        Provider provider1 = Security.getProvider(filterStr);
        Provider[] providers1 = Security.getProviders(filterStr);
        Map<String, String> filter = null;
        Provider[] providers2 = Security.getProviders(filter);
        String key = null;
        Security.getProperty(key);
        String value = null;
        Security.setProperty(key, value);
        String serviceName = null;
        Set<String> algorithms = Security.getAlgorithms(serviceName);

    }
}

package xdtest.javax.net.ssl;

import net.xdexamples.support.internal.BaseExample;

import javax.net.ssl.KeyStoreBuilderParameters;
import java.security.KeyStore;
import java.util.List;

public class KeyStoreBuilderParametersTest extends BaseExample<KeyStoreBuilderParameters> {

    @Override
    protected void scaffold(KeyStoreBuilderParameters instance) throws Throwable {
        KeyStore.Builder builder = null;
        KeyStoreBuilderParameters instance2 = new KeyStoreBuilderParameters(builder);
        KeyStore.Builder parameters = null;
        KeyStoreBuilderParameters keyStoreBuilderParameters = new KeyStoreBuilderParameters(parameters);
        List<KeyStore.Builder> parameters1 = instance.getParameters();
    }
}

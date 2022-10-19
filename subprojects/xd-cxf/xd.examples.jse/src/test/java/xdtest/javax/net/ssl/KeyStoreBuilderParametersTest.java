package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.KeyStoreBuilderParameters;
import java.security.KeyStore;
import java.util.List;

public class KeyStoreBuilderParametersTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            KeyStore.Builder builder = null;
            KeyStoreBuilderParameters instance = new KeyStoreBuilderParameters(builder);
            KeyStore.Builder parameters = null;
            KeyStoreBuilderParameters keyStoreBuilderParameters = new KeyStoreBuilderParameters(parameters);
            List<KeyStore.Builder> parameters1 = instance.getParameters();
        }
    }
}

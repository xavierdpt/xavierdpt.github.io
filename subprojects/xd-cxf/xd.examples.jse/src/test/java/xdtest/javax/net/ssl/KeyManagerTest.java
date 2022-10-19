package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.KeyManager;

public class KeyManagerTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            KeyManager instance = new KeyManager() {
            };
        }
    }
}

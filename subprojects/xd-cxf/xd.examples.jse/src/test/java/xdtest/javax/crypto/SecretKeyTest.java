package xdtest.javax.crypto;

import org.junit.Test;
import xdtest.TestUtils;

import javax.crypto.SecretKey;

public class SecretKeyTest {
    @Test public void test() {
        if (TestUtils.scaffold()) {
            SecretKey instance = TestUtils.makeInstance(SecretKey.class);
        }
    }
}

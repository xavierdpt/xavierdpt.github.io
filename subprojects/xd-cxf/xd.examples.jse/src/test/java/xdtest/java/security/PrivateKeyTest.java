package xdtest.java.security;

import org.junit.Test;
import xdtest.TestUtils;

import java.security.PrivateKey;

public class PrivateKeyTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            PrivateKey instance = TestUtils.makeInstance(PrivateKey.class);
        }
    }
}

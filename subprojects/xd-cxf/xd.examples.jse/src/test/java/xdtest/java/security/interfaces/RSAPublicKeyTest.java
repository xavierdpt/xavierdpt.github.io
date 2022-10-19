package xdtest.java.security.interfaces;

import org.junit.Test;
import xdtest.TestUtils;

import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;

public class RSAPublicKeyTest {
    @Test public void test() {
        if (TestUtils.scaffold()) {
            RSAPublicKey instance = TestUtils.makeInstance(RSAPublicKey.class);
            BigInteger publicExponent = instance.getPublicExponent();
        }
    }
}

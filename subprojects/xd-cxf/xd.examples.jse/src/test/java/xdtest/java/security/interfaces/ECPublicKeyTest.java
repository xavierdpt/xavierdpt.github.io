package xdtest.java.security.interfaces;

import org.junit.Test;
import xdtest.TestUtils;

import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

public class ECPublicKeyTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            ECPublicKey instance = TestUtils.makeInstance(ECPublicKey.class);
            ECPoint w = instance.getW();
        }
    }
}

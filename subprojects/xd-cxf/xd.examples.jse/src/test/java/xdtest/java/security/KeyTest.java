package xdtest.java.security;

import org.junit.Test;
import xdtest.TestUtils;

import java.security.Key;

public class KeyTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            Key instance = TestUtils.makeInstance(Key.class);
            String algorithm = instance.getAlgorithm();
            String format = instance.getFormat();
            byte[] encoded = instance.getEncoded();
        }
    }
}

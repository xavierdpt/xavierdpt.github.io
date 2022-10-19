package xdtest.java.security;

import org.junit.Test;
import xdtest.TestUtils;

import java.security.PublicKey;

public class PublicKeyTest {
    @Test public void test(){
        if (TestUtils.scaffold()) {
            PublicKey instance = TestUtils.makeInstance(PublicKey.class);
        }
    }
}

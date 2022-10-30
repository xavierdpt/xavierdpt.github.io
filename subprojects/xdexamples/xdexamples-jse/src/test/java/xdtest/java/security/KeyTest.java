package xdtest.java.security;

import net.xdexamples.support.internal.BaseExample;

import java.security.Key;

public class KeyTest extends BaseExample<Key> {

    @Override
    protected void scaffold(Key instance) throws Throwable {
        String algorithm = instance.getAlgorithm();
        String format = instance.getFormat();
        byte[] encoded = instance.getEncoded();
    }
}

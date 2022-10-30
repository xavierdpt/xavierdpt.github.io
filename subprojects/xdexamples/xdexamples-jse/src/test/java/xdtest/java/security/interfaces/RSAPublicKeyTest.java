package xdtest.java.security.interfaces;

import net.xdexamples.support.internal.BaseExample;

import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;

public class RSAPublicKeyTest extends BaseExample<RSAPublicKey> {

    @Override
    protected void scaffold(RSAPublicKey instance) throws Throwable {
        BigInteger publicExponent = instance.getPublicExponent();
    }
}

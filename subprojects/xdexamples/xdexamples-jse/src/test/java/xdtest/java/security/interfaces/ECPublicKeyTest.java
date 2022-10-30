package xdtest.java.security.interfaces;

import net.xdexamples.support.internal.BaseExample;

import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

public class ECPublicKeyTest extends BaseExample<ECPublicKey> {

    @Override
    protected void scaffold(ECPublicKey instance) throws Throwable {
        ECPoint w = instance.getW();
    }
}

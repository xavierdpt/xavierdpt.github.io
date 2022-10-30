package xdtest.java.security;

import net.xdexamples.support.internal.BaseExample;

import java.security.CryptoPrimitive;

public class CryptoPrimitiveTest extends BaseExample<CryptoPrimitive> {

    @Override
    protected void scaffold(CryptoPrimitive instance) throws Throwable {
        CryptoPrimitive messageDigest = CryptoPrimitive.MESSAGE_DIGEST;
        CryptoPrimitive secureRandom = CryptoPrimitive.SECURE_RANDOM;
        CryptoPrimitive blockCipher = CryptoPrimitive.BLOCK_CIPHER;
        CryptoPrimitive streamCipher = CryptoPrimitive.STREAM_CIPHER;
        CryptoPrimitive mac = CryptoPrimitive.MAC;
        CryptoPrimitive keyWrap = CryptoPrimitive.KEY_WRAP;
        CryptoPrimitive publicKeyEncryption = CryptoPrimitive.PUBLIC_KEY_ENCRYPTION;
        CryptoPrimitive signature = CryptoPrimitive.SIGNATURE;
        CryptoPrimitive keyEncapsulation = CryptoPrimitive.KEY_ENCAPSULATION;
        CryptoPrimitive keyAgreement = CryptoPrimitive.KEY_AGREEMENT;
    }
}

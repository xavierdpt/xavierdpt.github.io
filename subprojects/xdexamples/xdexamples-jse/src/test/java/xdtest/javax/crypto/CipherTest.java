package xdtest.javax.crypto;

import net.xdexamples.BaseExample;

import javax.crypto.Cipher;
import javax.crypto.ExemptionMechanism;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.spec.AlgorithmParameterSpec;

public class CipherTest extends BaseExample<Cipher> {

    @Override
    protected void scaffold(Cipher instance) throws Throwable {
        int encryptMode = Cipher.ENCRYPT_MODE;
        int decryptMode = Cipher.DECRYPT_MODE;
        int wrapMode = Cipher.WRAP_MODE;
        int unwrapMode = Cipher.UNWRAP_MODE;
        int publicKey = Cipher.PUBLIC_KEY;
        int privateKey = Cipher.PRIVATE_KEY;
        int secretKey = Cipher.SECRET_KEY;
        Provider provider = instance.getProvider();
        String transformation = "";
        Cipher instance1 = Cipher.getInstance(transformation);
        String providerName = "";
        Cipher.getInstance(transformation, providerName);
        Cipher.getInstance(transformation, provider);

        String algorithm = instance.getAlgorithm();
        int blockSize = instance.getBlockSize();
        int length = 0;
        int outputSize = instance.getOutputSize(length);
        byte[] iv = instance.getIV();
        AlgorithmParameters parameters = instance.getParameters();
        ExemptionMechanism exemptionMechanism = instance.getExemptionMechanism();
        int opmode = 0;
        Key key = null;
        instance.init(opmode, key);
        SecureRandom random = null;
        instance.init(opmode, key, random);
        AlgorithmParameterSpec paramsSpec = null;
        instance.init(opmode, key, paramsSpec);
        instance.init(opmode, key, paramsSpec, random);
        AlgorithmParameters params = null;
        instance.init(opmode, key, params);
        instance.init(opmode, key, params, random);
        Certificate certificate = null;
        instance.init(opmode, certificate);
        instance.init(opmode, certificate, random);
        byte[] input = new byte[0];
        byte[] update = instance.update(input);
        int inputOffset = 0;
        int inputLen = 0;
        byte[] update1 = instance.update(input, inputOffset, inputLen);
        byte[] output = new byte[0];
        int update2 = instance.update(input, inputOffset, inputLen, output);
        int outputOffset = 0;
        int update3 = instance.update(input, inputOffset, inputLen, output, outputOffset);
        ByteBuffer inputBuffer = null;
        ByteBuffer outputBuffer = null;
        int update4 = instance.update(inputBuffer, outputBuffer);
        byte[] bytes = instance.doFinal();
        int i = instance.doFinal(output, outputOffset);
        byte[] bytes1 = instance.doFinal(input);
        byte[] bytes2 = instance.doFinal(input, inputOffset, inputLen);
        int i1 = instance.doFinal(input, inputOffset, inputLen, output);
        int i2 = instance.doFinal(input, inputOffset, inputLen, output, outputOffset);
        instance.doFinal(inputBuffer, outputBuffer);
        byte[] wrap = instance.wrap(key);
        byte[] wrappedKey = new byte[0];
        String wrappedKeyAlgorithm = null;
        int wrappedKeyType = 0;
        instance.unwrap(wrappedKey, wrappedKeyAlgorithm, wrappedKeyType);
        int maxAllowedKeyLength = Cipher.getMaxAllowedKeyLength(transformation);
        AlgorithmParameterSpec maxAllowedParameterSpec = Cipher.getMaxAllowedParameterSpec(transformation);
        byte[] src = new byte[0];
        instance.updateAAD(src);
        int offset = 0;
        instance.updateAAD(src,offset,length);
        ByteBuffer srcBuffer = null;
        instance.updateAAD(srcBuffer);
        String s = instance.toString();
    }
}

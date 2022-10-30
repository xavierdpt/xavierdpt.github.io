package xdtest.java.security;

import net.xdexamples.BaseExample;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.Provider;

public class MessageDigestTest extends BaseExample<MessageDigest> {

    @Override
    protected void scaffold(MessageDigest instance) throws Throwable {
        String algorithm = null;
        MessageDigest instance1 = MessageDigest.getInstance(algorithm);
        String providerName = null;
        MessageDigest instance2 = MessageDigest.getInstance(algorithm, providerName);
        Provider provider = null;
        MessageDigest instance3 = MessageDigest.getInstance(algorithm, provider);
        Provider provider1 = instance.getProvider();
        byte input = 0;
        instance.update(input);

        byte[] inputBytes = new byte[0];
        instance.update(inputBytes);
        int offset = 0;
        int length = 0;
        instance.update(inputBytes,offset,length);
        ByteBuffer byteBuffer = null;
        instance.update(byteBuffer);
        byte[] digest = instance.digest();
        byte[] bytes = new byte[0];
        int digest1 = instance.digest(bytes, offset, length);
        instance.digest(bytes);
        String s = instance.toString();
        instance.reset();
        String algorithm1 = instance.getAlgorithm();
        int digestLength = instance.getDigestLength();
        Object clone = instance.clone();
    }
}

package xd.examples;

import net.xdexamples.helpers.ExampleHelper;
import xd.XDUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;

public class CipherExamples {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        for (Provider provider : Security.getProviders()) {
            String providerName = provider.getName();
            for (Provider.Service service : provider.getServices()) {
                String type = service.getType();
                if ("Cipher".equals(type)) {
                    String algorithm = service.getAlgorithm();
                    String disp = providerName + "/" + algorithm;
                    switch (disp) {
                        case "SunJCE/PBEWithMD5AndDES": {
                        }
                        case "SunJCE/AES/GCM/NoPadding": {

                        }
                        case "SunJCE/PBEWithSHA1AndRC2_128": {

                        }
                        case "SunJCE/AES_192/ECB/NoPadding": {

                        }
                        case "SunJCE/AES_128/KW/NoPadding": {

                        }
                        case "SunJCE/PBEWithSHA1AndRC2_40": {

                        }
                        case "SunJCE/PBEWithSHA1AndRC4_128": {

                        }
                        case "SunJCE/DESedeWrap": {

                        }
                        case "SunJCE/AES_256/KW/NoPadding": {

                        }
                        case "SunJCE/AES/KW/NoPadding": {

                        }
                        case "SunJCE/PBEWithSHA1AndDESede": {

                        }
                        case "SunJCE/PBEWithSHA1AndRC4_40": {

                        }
                        case "SunJCE/AES_192/KWP/NoPadding": {

                        }
                        case "SunJCE/PBEWithHmacSHA224AndAES_128": {

                        }
                        case "SunJCE/AES": {
                            Cipher cipher = Cipher.getInstance(algorithm, provider);
                            DummyKey key = new DummyKey() {};
                            cipher.init(Cipher.ENCRYPT_MODE, key);
                            byte[] plain = "Hello world".getBytes(StandardCharsets.UTF_8);
                            byte[] encrypted = cipher.doFinal(plain);
                            AlgorithmParameters parameters = cipher.getParameters();
                            cipher.init(Cipher.DECRYPT_MODE, key, parameters);
                            byte[] decrypted = cipher.doFinal(encrypted);
                            System.out.println(ExampleHelper.bytesToHex(encrypted));
                            System.out.println(ExampleHelper.bytesToHex(plain));
                            System.out.println(ExampleHelper.bytesToHex(decrypted));
                        }
                        case "SunJCE/AES_192/OFB/NoPadding": {

                        }
                        case "SunJCE/AES_192/CFB/NoPadding": {

                        }
                        case "SunJCE/AES_192/KW/NoPadding": {

                        }
                        case "SunJCE/AES_192/GCM/NoPadding": {

                        }
                        case "SunJCE/AES_192/CBC/NoPadding": {

                        }
                        case "SunJCE/AES_128/KW/PKCS5Padding": {

                        }
                        case "SunJCE/DESede": {

                        }
                        case "SunJCE/AES_256/KW/PKCS5Padding": {

                        }
                        case "SunJCE/AES_128/ECB/NoPadding": {

                        }
                        case "SunJCE/AES_256/ECB/NoPadding": {

                        }
                        case "SunJCE/ChaCha20-Poly1305": {

                        }
                        case "SunJCE/AES/KW/PKCS5Padding": {

                        }
                        case "SunJCE/ARCFOUR": {

                        }
                        case "SunJCE/AES_256/GCM/NoPadding": {

                        }
                        case "SunJCE/RC2": {

                        }
                        case "SunJCE/RSA": {

                        }
                        case "SunJCE/AES_128/CFB/NoPadding": {

                        }
                        case "SunJCE/AES_128/KWP/NoPadding": {

                        }
                        case "SunJCE/AES_128/OFB/NoPadding": {

                        }
                        case "SunJCE/AES_256/KWP/NoPadding": {

                        }
                        case "SunJCE/ChaCha20": {

                        }
                        case "SunJCE/PBEWithHmacSHA224AndAES_256": {

                        }
                        case "SunJCE/DES": {

                        }
                        case "SunJCE/AES_256/CBC/NoPadding": {

                        }
                        case "SunJCE/PBEWithHmacSHA256AndAES_256": {

                        }
                        case "SunJCE/PBEWithHmacSHA256AndAES_128": {

                        }
                        case "SunJCE/AES/KWP/NoPadding": {

                        }
                        case "SunJCE/AES_192/KW/PKCS5Padding": {

                        }
                        case "SunJCE/AES_256/CFB/NoPadding": {

                        }
                        case "SunJCE/PBEWithHmacSHA512AndAES_128": {

                        }
                        case "SunJCE/PBEWithHmacSHA1AndAES_128": {

                        }
                        case "SunJCE/PBEWithHmacSHA512AndAES_256": {

                        }
                        case "SunJCE/AES_128/CBC/NoPadding": {

                        }
                        case "SunJCE/AES_256/OFB/NoPadding": {

                        }
                        case "SunJCE/PBEWithHmacSHA1AndAES_256": {

                        }
                        case "SunJCE/PBEWithHmacSHA384AndAES_256": {

                        }
                        case "SunJCE/AES_128/GCM/NoPadding": {

                        }
                        case "SunJCE/PBEWithHmacSHA384AndAES_128": {

                        }
                        case "SunJCE/Blowfish": {

                        }
                        case "SunJCE/PBEWithMD5AndTripleDES": {
                        }
                        case "SunMSCAPI/RSA/ECB/PKCS1Padding": {
                        }
                        case "SunMSCAPI/RSA": {

                        }
                        default: {
                            System.out.println(disp);
                        }
                    }
                }
            }
        }

    }

    public static class DummyKey implements Key {

        @Override
        public String getAlgorithm() {
            return "";
        }

        @Override
        public String getFormat() {
            return "";
        }

        @Override
        public byte[] getEncoded() {
            return new byte[0];
        }
    }

}

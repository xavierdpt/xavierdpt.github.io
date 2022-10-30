package net.xdexamples.jse.index.java.security.spec;

import net.xdexamples.support.internal.ExampleIndex;
import net.xdexamples.jse.examples.java.security.spec.AlgorithmParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.DSAGenParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.DSAParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.DSAPrivateKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.DSAPublicKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.ECFieldExample;
import net.xdexamples.jse.examples.java.security.spec.ECFieldF2mExample;
import net.xdexamples.jse.examples.java.security.spec.ECFieldFpExample;
import net.xdexamples.jse.examples.java.security.spec.ECGenParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.ECParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.ECPointExample;
import net.xdexamples.jse.examples.java.security.spec.ECPrivateKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.ECPublicKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.EdDSAParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.EdECPointExample;
import net.xdexamples.jse.examples.java.security.spec.EdECPrivateKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.EdECPublicKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.EllipticCurveExample;
import net.xdexamples.jse.examples.java.security.spec.EncodedKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.KeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.MGF1ParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.NamedParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.PKCS8EncodedKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.PSSParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.RSAKeyGenParameterSpecExample;
import net.xdexamples.jse.examples.java.security.spec.RSAMultiPrimePrivateCrtKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.RSAOtherPrimeInfoExample;
import net.xdexamples.jse.examples.java.security.spec.RSAPrivateCrtKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.RSAPrivateKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.RSAPublicKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.X509EncodedKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.XECPrivateKeySpecExample;
import net.xdexamples.jse.examples.java.security.spec.XECPublicKeySpecExample;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAGenParameterSpec;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.DSAPublicKeySpec;
import java.security.spec.ECField;
import java.security.spec.ECFieldF2m;
import java.security.spec.ECFieldFp;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EdDSAParameterSpec;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPrivateKeySpec;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.EllipticCurve;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.NamedParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;
import java.security.spec.RSAOtherPrimeInfo;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.security.spec.XECPrivateKeySpec;
import java.security.spec.XECPublicKeySpec;

@ExampleIndex({

        AlgorithmParameterSpec.class,
        AlgorithmParameterSpecExample.class,

        DSAGenParameterSpec.class,
        DSAGenParameterSpecExample.class,

        DSAParameterSpec.class,
        DSAParameterSpecExample.class,

        DSAPrivateKeySpec.class,
        DSAPrivateKeySpecExample.class,

        DSAPublicKeySpec.class,
        DSAPublicKeySpecExample.class,

        ECField.class,
        ECFieldExample.class,

        ECFieldF2m.class,
        ECFieldF2mExample.class,

        ECFieldFp.class,
        ECFieldFpExample.class,

        ECGenParameterSpec.class,
        ECGenParameterSpecExample.class,

        ECParameterSpec.class,
        ECParameterSpecExample.class,

        ECPoint.class,
        ECPointExample.class,

        ECPrivateKeySpec.class,
        ECPrivateKeySpecExample.class,

        ECPublicKeySpec.class,
        ECPublicKeySpecExample.class,

        EdDSAParameterSpec.class,
        EdDSAParameterSpecExample.class,

        EdECPoint.class,
        EdECPointExample.class,

        EdECPrivateKeySpec.class,
        EdECPrivateKeySpecExample.class,

        EdECPublicKeySpec.class,
        EdECPublicKeySpecExample.class,

        EllipticCurve.class,
        EllipticCurveExample.class,

        EncodedKeySpec.class,
        EncodedKeySpecExample.class,

        InvalidKeySpecException.class,

        InvalidParameterSpecException.class,

        KeySpec.class,
        KeySpecExample.class,

        MGF1ParameterSpec.class,
        MGF1ParameterSpecExample.class,

        NamedParameterSpec.class,
        NamedParameterSpecExample.class,

        PKCS8EncodedKeySpec.class,
        PKCS8EncodedKeySpecExample.class,

        PSSParameterSpec.class,
        PSSParameterSpecExample.class,

        RSAKeyGenParameterSpec.class,
        RSAKeyGenParameterSpecExample.class,

        RSAMultiPrimePrivateCrtKeySpec.class,
        RSAMultiPrimePrivateCrtKeySpecExample.class,

        RSAOtherPrimeInfo.class,
        RSAOtherPrimeInfoExample.class,

        RSAPrivateCrtKeySpec.class,
        RSAPrivateCrtKeySpecExample.class,

        RSAPrivateKeySpec.class,
        RSAPrivateKeySpecExample.class,

        RSAPublicKeySpec.class,
        RSAPublicKeySpecExample.class,

        X509EncodedKeySpec.class,
        X509EncodedKeySpecExample.class,

        XECPrivateKeySpec.class,
        XECPrivateKeySpecExample.class,

        XECPublicKeySpec.class,
        XECPublicKeySpecExample.class
})
public class Index {

}

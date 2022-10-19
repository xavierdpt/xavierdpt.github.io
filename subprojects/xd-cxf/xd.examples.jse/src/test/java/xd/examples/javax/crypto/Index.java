package xd.examples.javax.crypto;

import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.CipherSpi;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.ExemptionMechanism;
import javax.crypto.ExemptionMechanismException;
import javax.crypto.ExemptionMechanismSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.KeyGenerator;
import javax.crypto.KeyGeneratorSpi;
import javax.crypto.Mac;
import javax.crypto.MacSpi;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.NullCipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.SecretKeyFactorySpi;
import javax.crypto.ShortBufferException;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    AEADBadTagException.class,
                    BadPaddingException.class,
                    Cipher.class,
                    CipherInputStream.class,
                    CipherOutputStream.class,
                    CipherSpi.class,
                    EncryptedPrivateKeyInfo.class,
                    ExemptionMechanism.class,
                    ExemptionMechanismException.class,
                    ExemptionMechanismSpi.class,
                    IllegalBlockSizeException.class,
                    KeyAgreement.class,
                    KeyAgreementSpi.class,
                    KeyGenerator.class,
                    KeyGeneratorSpi.class,
                    Mac.class,
                    MacSpi.class,
                    NoSuchPaddingException.class,
                    NullCipher.class,
                    SealedObject.class,
                    SecretKey.class,
                    SecretKeyFactory.class,
                    SecretKeyFactorySpi.class,
                    ShortBufferException.class

            ));
        }
    }
}

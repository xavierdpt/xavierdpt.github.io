package xd.examples.javax.crypto.spec;

import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.DHGenParameterSpec;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import javax.crypto.spec.DHPublicKeySpec;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    ChaCha20ParameterSpec.class,
                    DESedeKeySpec.class,
                    DESKeySpec.class,
                    DHGenParameterSpec.class,
                    DHParameterSpec.class,
                    DHPrivateKeySpec.class,
                    DHPublicKeySpec.class,
                    GCMParameterSpec.class,
                    IvParameterSpec.class,
                    OAEPParameterSpec.class,
                    PBEKeySpec.class,
                    PBEParameterSpec.class,
                    PSource.class,
                    RC2ParameterSpec.class,
                    RC5ParameterSpec.class,
                    SecretKeySpec.class,
                    SecretKeySpec.class
            ));
        }
    }

}

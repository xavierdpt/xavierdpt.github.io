package xd.examples.java.security;

import java.security.AlgorithmConstraints;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameterGeneratorSpi;
import java.security.AlgorithmParameters;
import java.security.AlgorithmParametersSpi;
import java.security.AllPermission;
import java.security.AuthProvider;
import java.security.BasicPermission;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.CryptoPrimitive;
import java.security.DigestException;
import java.security.DigestOutputStream;
import java.security.DomainLoadStoreParameter;
import java.security.DrbgParameters;
import java.security.GeneralSecurityException;
import java.security.Guard;
import java.security.GuardedObject;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyFactorySpi;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyPairGeneratorSpi;
import java.security.KeyRep;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.MessageDigest;
import java.security.MessageDigestSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PKCS12Attribute;
import java.security.Permission;
import java.security.Permissions;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureClassLoader;
import java.security.SecureRandom;
import java.security.SecureRandomParameters;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.security.SecurityPermission;
import java.security.Signature;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.SignedObject;
import java.security.Timestamp;
import java.security.URIParameter;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.UnresolvedPermission;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    AlgorithmConstraints.class,
                    AlgorithmParameterGenerator.class,
                    AlgorithmParameterGeneratorSpi.class,
                    AlgorithmParameters.class,
                    AlgorithmParametersSpi.class,
                    AllPermission.class,
                    AuthProvider.class,
                    BasicPermission.class,
                    CodeSigner.class,
                    CodeSource.class,
                    CryptoPrimitive.class,
                    DigestException.class,
                    DigestOutputStream.class,
                    DomainLoadStoreParameter.class,
                    DrbgParameters.class,
                    GeneralSecurityException.class,
                    Guard.class,
                    GuardedObject.class,
                    InvalidAlgorithmParameterException.class,
                    InvalidKeyException.class,
                    InvalidParameterException.class,
                    Key.class,
                    KeyException.class,
                    KeyFactory.class,
                    KeyFactorySpi.class,
                    KeyManagementException.class,
                    KeyPair.class,
                    KeyPairGenerator.class,
                    KeyPairGeneratorSpi.class,
                    KeyRep.class,
                    KeyStore.class,
                    KeyStoreException.class,
                    KeyStoreSpi.class,
                    MessageDigest.class,
                    MessageDigestSpi.class,
                    NoSuchAlgorithmException.class,
                    NoSuchProviderException.class,
                    Permission.class,
                    Permissions.class,
                    PKCS12Attribute.class,
                    Principal.class,
                    PrivateKey.class,
                    PrivilegedAction.class,
                    PrivilegedActionException.class,
                    PrivilegedExceptionAction.class,
                    ProtectionDomain.class,
                    Provider.class,
                    ProviderException.class,
                    PublicKey.class,
                    SecureClassLoader.class,
                    SecureRandom.class,
                    SecureRandomParameters.class,
                    SecureRandomSpi.class,
                    Security.class,
                    SecurityPermission.class,
                    Signature.class,
                    SignatureException.class,
                    SignatureSpi.class,
                    SignedObject.class,
                    Timestamp.class,
                    UnrecoverableEntryException.class,
                    UnrecoverableKeyException.class,
                    UnresolvedPermission.class,
                    URIParameter.class
            ));
        }
    }
}

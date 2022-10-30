package net.xdexamples.jse.index.java.security;

import net.xdexamples.support.ExampleIndex;
import net.xdexamples.jse.examples.java.security.AlgorithmConstraintsExample;
import net.xdexamples.jse.examples.java.security.AlgorithmParameterGeneratorExample;
import net.xdexamples.jse.examples.java.security.AlgorithmParameterGeneratorSpiExample;
import net.xdexamples.jse.examples.java.security.AlgorithmParametersExample;
import net.xdexamples.jse.examples.java.security.AlgorithmParametersSpiExample;
import net.xdexamples.jse.examples.java.security.AllPermissionExample;
import net.xdexamples.jse.examples.java.security.AuthProviderExample;
import net.xdexamples.jse.examples.java.security.BasicPermissionExample;
import net.xdexamples.jse.examples.java.security.CodeSignerExample;
import net.xdexamples.jse.examples.java.security.CodeSourceExample;
import net.xdexamples.jse.examples.java.security.CryptoPrimitiveExample;
import net.xdexamples.jse.examples.java.security.DigestOutputStreamExample;
import net.xdexamples.jse.examples.java.security.DomainLoadStoreParameterExample;
import net.xdexamples.jse.examples.java.security.DrbgParametersExample;
import net.xdexamples.jse.examples.java.security.GuardExample;
import net.xdexamples.jse.examples.java.security.GuardedObjectExample;
import net.xdexamples.jse.examples.java.security.KeyExample;
import net.xdexamples.jse.examples.java.security.KeyFactoryExample;
import net.xdexamples.jse.examples.java.security.KeyFactorySpiExample;
import net.xdexamples.jse.examples.java.security.KeyPairExample;
import net.xdexamples.jse.examples.java.security.KeyPairGeneratorExample;
import net.xdexamples.jse.examples.java.security.KeyPairGeneratorSpiExample;
import net.xdexamples.jse.examples.java.security.KeyRepExample;
import net.xdexamples.jse.examples.java.security.KeyStoreExample;
import net.xdexamples.jse.examples.java.security.KeyStoreSpiExample;
import net.xdexamples.jse.examples.java.security.MessageDigestExample;
import net.xdexamples.jse.examples.java.security.MessageDigestSpiExample;
import net.xdexamples.jse.examples.java.security.PKCS12AttributeExample;
import net.xdexamples.jse.examples.java.security.PermissionExample;
import net.xdexamples.jse.examples.java.security.PermissionsExample;
import net.xdexamples.jse.examples.java.security.PrincipalExample;
import net.xdexamples.jse.examples.java.security.PrivateKeyExample;
import net.xdexamples.jse.examples.java.security.PrivilegedActionExample;
import net.xdexamples.jse.examples.java.security.PrivilegedExceptionActionExample;
import net.xdexamples.jse.examples.java.security.ProtectionDomainExample;
import net.xdexamples.jse.examples.java.security.ProviderExample;
import net.xdexamples.jse.examples.java.security.PublicKeyExample;
import net.xdexamples.jse.examples.java.security.SecureClassLoaderExample;
import net.xdexamples.jse.examples.java.security.SecureRandomExample;
import net.xdexamples.jse.examples.java.security.SecureRandomParametersExample;
import net.xdexamples.jse.examples.java.security.SecureRandomSpiExample;
import net.xdexamples.jse.examples.java.security.SecurityExample;
import net.xdexamples.jse.examples.java.security.SecurityPermissionExample;
import net.xdexamples.jse.examples.java.security.SignatureExample;
import net.xdexamples.jse.examples.java.security.SignatureSpiExample;
import net.xdexamples.jse.examples.java.security.SignedObjectExample;
import net.xdexamples.jse.examples.java.security.TimestampExample;
import net.xdexamples.jse.examples.java.security.URIParameterExample;
import net.xdexamples.jse.examples.java.security.UnresolvedPermissionExample;

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

@ExampleIndex({

        AlgorithmConstraints.class,
        AlgorithmConstraintsExample.class,

        AlgorithmParameterGenerator.class,
        AlgorithmParameterGeneratorExample.class,

        AlgorithmParameterGeneratorSpi.class,
        AlgorithmParameterGeneratorSpiExample.class,

        AlgorithmParameters.class,
        AlgorithmParametersExample.class,

        AlgorithmParametersSpi.class,
        AlgorithmParametersSpiExample.class,

        AllPermission.class,
        AllPermissionExample.class,

        AuthProvider.class,
        AuthProviderExample.class,

        BasicPermission.class,
        BasicPermissionExample.class,

        CodeSigner.class,
        CodeSignerExample.class,

        CodeSource.class,
        CodeSourceExample.class,

        CryptoPrimitive.class,
        CryptoPrimitiveExample.class,

        DigestException.class,

        DigestOutputStream.class,
        DigestOutputStreamExample.class,

        DomainLoadStoreParameter.class,
        DomainLoadStoreParameterExample.class,

        DrbgParameters.class,
        DrbgParametersExample.class,

        GeneralSecurityException.class,

        Guard.class,
        GuardExample.class,

        GuardedObject.class,
        GuardedObjectExample.class,

        InvalidAlgorithmParameterException.class,

        InvalidKeyException.class,

        InvalidParameterException.class,

        Key.class,
        KeyExample.class,

        KeyException.class,

        KeyFactory.class,
        KeyFactoryExample.class,

        KeyFactorySpi.class,
        KeyFactorySpiExample.class,

        KeyManagementException.class,

        KeyPair.class,
        KeyPairExample.class,

        KeyPairGenerator.class,
        KeyPairGeneratorExample.class,

        KeyPairGeneratorSpi.class,
        KeyPairGeneratorSpiExample.class,

        KeyRep.class,
        KeyRepExample.class,

        KeyStore.class,
        KeyStoreExample.class,

        KeyStoreException.class,

        KeyStoreSpi.class,
        KeyStoreSpiExample.class,

        MessageDigest.class,
        MessageDigestExample.class,

        MessageDigestSpi.class,
        MessageDigestSpiExample.class,

        NoSuchAlgorithmException.class,

        NoSuchProviderException.class,

        Permission.class,
        PermissionExample.class,

        Permissions.class,
        PermissionsExample.class,

        PKCS12Attribute.class,
        PKCS12AttributeExample.class,

        Principal.class,
        PrincipalExample.class,

        PrivateKey.class,
        PrivateKeyExample.class,

        PrivilegedAction.class,
        PrivilegedActionExample.class,

        PrivilegedActionException.class,

        PrivilegedExceptionAction.class,
        PrivilegedExceptionActionExample.class,

        ProtectionDomain.class,
        ProtectionDomainExample.class,

        Provider.class,
        ProviderExample.class,

        ProviderException.class,

        PublicKey.class,
        PublicKeyExample.class,

        SecureClassLoader.class,
        SecureClassLoaderExample.class,

        SecureRandom.class,
        SecureRandomExample.class,

        SecureRandomParameters.class,
        SecureRandomParametersExample.class,

        SecureRandomSpi.class,
        SecureRandomSpiExample.class,

        Security.class,
        SecurityExample.class,

        SecurityPermission.class,
        SecurityPermissionExample.class,

        Signature.class,
        SignatureExample.class,

        SignatureException.class,

        SignatureSpi.class,
        SignatureSpiExample.class,

        SignedObject.class,
        SignedObjectExample.class,

        Timestamp.class,
        TimestampExample.class,

        UnrecoverableEntryException.class,

        UnrecoverableKeyException.class,

        UnresolvedPermission.class,
        UnresolvedPermissionExample.class,

        URIParameter.class,
        URIParameterExample.class
})
public class Index {

}

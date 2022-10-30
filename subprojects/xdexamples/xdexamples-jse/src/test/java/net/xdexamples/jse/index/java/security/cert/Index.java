package net.xdexamples.jse.index.java.security.cert;

import net.xdexamples.support.ExampleIndex;
import net.xdexamples.jse.examples.java.security.cert.CRLExample;
import net.xdexamples.jse.examples.java.security.cert.CRLReasonExample;
import net.xdexamples.jse.examples.java.security.cert.CRLSelectorExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathBuilderResultExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathBuilderSpiExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathCheckerExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathParametersExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathValidatorExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathValidatorResultExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathValidatorSpiExample;
import net.xdexamples.jse.examples.java.security.cert.CertSelectorExample;
import net.xdexamples.jse.examples.java.security.cert.CertStoreExample;
import net.xdexamples.jse.examples.java.security.cert.CertStoreParametersExample;
import net.xdexamples.jse.examples.java.security.cert.CertStoreSpiExample;
import net.xdexamples.jse.examples.java.security.cert.CertificateExample;
import net.xdexamples.jse.examples.java.security.cert.CertificateFactoryExample;
import net.xdexamples.jse.examples.java.security.cert.CertificateFactorySpiExample;
import net.xdexamples.jse.examples.java.security.cert.CollectionCertStoreParametersExample;
import net.xdexamples.jse.examples.java.security.cert.ExtensionExample;
import net.xdexamples.jse.examples.java.security.cert.LDAPCertStoreParametersExample;
import net.xdexamples.jse.examples.java.security.cert.PKIXBuilderParametersExample;
import net.xdexamples.jse.examples.java.security.cert.PKIXCertPathBuilderResultExample;
import net.xdexamples.jse.examples.java.security.cert.PKIXCertPathCheckerExample;
import net.xdexamples.jse.examples.java.security.cert.PKIXCertPathValidatorResultExample;
import net.xdexamples.jse.examples.java.security.cert.PKIXParametersExample;
import net.xdexamples.jse.examples.java.security.cert.PKIXReasonExample;
import net.xdexamples.jse.examples.java.security.cert.PKIXRevocationCheckerExample;
import net.xdexamples.jse.examples.java.security.cert.PolicyNodeExample;
import net.xdexamples.jse.examples.java.security.cert.PolicyQualifierInfoExample;
import net.xdexamples.jse.examples.java.security.cert.TrustAnchorExample;
import net.xdexamples.jse.examples.java.security.cert.URICertStoreParametersExample;
import net.xdexamples.jse.examples.java.security.cert.X509CRLEntryExample;
import net.xdexamples.jse.examples.java.security.cert.X509CRLExample;
import net.xdexamples.jse.examples.java.security.cert.X509CRLSelectorExample;
import net.xdexamples.jse.examples.java.security.cert.X509CertSelectorExample;
import net.xdexamples.jse.examples.java.security.cert.X509CertificateExample;
import net.xdexamples.jse.examples.java.security.cert.X509ExtensionExample;
import net.xdexamples.jse.examples.java.security.cert.CertPathBuilderExample;

import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CRLReason;
import java.security.cert.CRLSelector;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertPathBuilderSpi;
import java.security.cert.CertPathChecker;
import java.security.cert.CertPathParameters;
import java.security.cert.CertPathValidator;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertPathValidatorResult;
import java.security.cert.CertPathValidatorSpi;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.Extension;
import java.security.cert.LDAPCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXCertPathValidatorResult;
import java.security.cert.PKIXParameters;
import java.security.cert.PKIXReason;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.PolicyNode;
import java.security.cert.PolicyQualifierInfo;
import java.security.cert.TrustAnchor;
import java.security.cert.URICertStoreParameters;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509CRLSelector;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.security.cert.X509Extension;

@ExampleIndex({

        Certificate.class,
        CertificateExample.class,

        CertificateEncodingException.class,

        CertificateException.class,

        CertificateExpiredException.class,

        CertificateFactory.class,
        CertificateFactoryExample.class,

        CertificateFactorySpi.class,
        CertificateFactorySpiExample.class,

        CertificateNotYetValidException.class,

        CertificateParsingException.class,

        CertificateRevokedException.class,

        CertPath.class,
        CertPathExample.class,

        CertPathBuilder.class,
        CertPathBuilderExample.class,

        CertPathBuilderException.class,

        CertPathBuilderResult.class,
        CertPathBuilderResultExample.class,

        CertPathBuilderSpi.class,
        CertPathBuilderSpiExample.class,

        CertPathChecker.class,
        CertPathCheckerExample.class,

        CertPathParameters.class,
        CertPathParametersExample.class,

        CertPathValidator.class,
        CertPathValidatorExample.class,

        CertPathValidatorException.class,

        CertPathValidatorResult.class,
        CertPathValidatorResultExample.class,

        CertPathValidatorSpi.class,
        CertPathValidatorSpiExample.class,

        CertSelector.class,
        CertSelectorExample.class,

        CertStore.class,
        CertStoreExample.class,

        CertStoreException.class,

        CertStoreParameters.class,
        CertStoreParametersExample.class,

        CertStoreSpi.class,
        CertStoreSpiExample.class,

        CollectionCertStoreParameters.class,
        CollectionCertStoreParametersExample.class,

        CRL.class,
        CRLExample.class,

        CRLException.class,

        CRLReason.class,
        CRLReasonExample.class,

        CRLSelector.class,
        CRLSelectorExample.class,

        Extension.class,
        ExtensionExample.class,

        LDAPCertStoreParameters.class,
        LDAPCertStoreParametersExample.class,

        PKIXBuilderParameters.class,
        PKIXBuilderParametersExample.class,

        PKIXCertPathBuilderResult.class,
        PKIXCertPathBuilderResultExample.class,

        PKIXCertPathChecker.class,
        PKIXCertPathCheckerExample.class,

        PKIXCertPathValidatorResult.class,
        PKIXCertPathValidatorResultExample.class,

        PKIXParameters.class,
        PKIXParametersExample.class,

        PKIXReason.class,
        PKIXReasonExample.class,

        PKIXRevocationChecker.class,
        PKIXRevocationCheckerExample.class,

        PolicyNode.class,
        PolicyNodeExample.class,

        PolicyQualifierInfo.class,
        PolicyQualifierInfoExample.class,

        TrustAnchor.class,
        TrustAnchorExample.class,

        URICertStoreParameters.class,
        URICertStoreParametersExample.class,

        X509Certificate.class,
        X509CertificateExample.class,

        X509CertSelector.class,
        X509CertSelectorExample.class,

        X509CRL.class,
        X509CRLExample.class,

        X509CRLEntry.class,
        X509CRLEntryExample.class,

        X509CRLSelector.class,
        X509CRLSelectorExample.class,

        X509Extension.class,
        X509ExtensionExample.class
})
public class Index {

}

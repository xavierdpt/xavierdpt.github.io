package xd.examples.java.security.cert;

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

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    Certificate.class,
                    CertificateEncodingException.class,
                    CertificateException.class,
                    CertificateExpiredException.class,
                    CertificateFactory.class,
                    CertificateFactorySpi.class,
                    CertificateNotYetValidException.class,
                    CertificateParsingException.class,
                    CertificateRevokedException.class,
                    CertPath.class,
                    CertPathBuilder.class,
                    CertPathBuilderException.class,
                    CertPathBuilderResult.class,
                    CertPathBuilderSpi.class,
                    CertPathChecker.class,
                    CertPathParameters.class,
                    CertPathValidator.class,
                    CertPathValidatorException.class,
                    CertPathValidatorResult.class,
                    CertPathValidatorSpi.class,
                    CertSelector.class,
                    CertStore.class,
                    CertStoreException.class,
                    CertStoreParameters.class,
                    CertStoreSpi.class,
                    CollectionCertStoreParameters.class,
                    CRL.class,
                    CRLException.class,
                    CRLReason.class,
                    CRLSelector.class,
                    Extension.class,
                    LDAPCertStoreParameters.class,
                    PKIXBuilderParameters.class,
                    PKIXCertPathBuilderResult.class,
                    PKIXCertPathChecker.class,
                    PKIXCertPathValidatorResult.class,
                    PKIXParameters.class,
                    PKIXReason.class,
                    PKIXRevocationChecker.class,
                    PolicyNode.class,
                    PolicyQualifierInfo.class,
                    TrustAnchor.class,
                    URICertStoreParameters.class,
                    X509Certificate.class,
                    X509CertSelector.class,
                    X509CRL.class,
                    X509CRLEntry.class,
                    X509CRLSelector.class,
                    X509Extension.class
            ));
        }
    }
}

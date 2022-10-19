package xd.examples.javax.naming.ldap;

import xdtest.ExampleIndex;

import javax.naming.ldap.BasicControl;
import javax.naming.ldap.Control;
import javax.naming.ldap.ControlFactory;
import javax.naming.ldap.ExtendedRequest;
import javax.naming.ldap.ExtendedResponse;
import javax.naming.ldap.HasControls;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.LdapReferralException;
import javax.naming.ldap.ManageReferralControl;
import javax.naming.ldap.PagedResultsControl;
import javax.naming.ldap.PagedResultsResponseControl;
import javax.naming.ldap.Rdn;
import javax.naming.ldap.SortControl;
import javax.naming.ldap.SortKey;
import javax.naming.ldap.SortResponseControl;
import javax.naming.ldap.StartTlsRequest;
import javax.naming.ldap.StartTlsResponse;
import javax.naming.ldap.UnsolicitedNotification;
import javax.naming.ldap.UnsolicitedNotificationEvent;
import javax.naming.ldap.UnsolicitedNotificationListener;

@ExampleIndex({
        BasicControl.class,
        Control.class,
        ControlFactory.class,
        ExtendedRequest.class,
        ExtendedResponse.class,
        HasControls.class,
        InitialLdapContext.class,
        LdapContext.class,
        LdapName.class,
        LdapReferralException.class,
        ManageReferralControl.class,
        PagedResultsControl.class,
        PagedResultsResponseControl.class,
        Rdn.class,
        SortControl.class,
        SortKey.class,
        SortResponseControl.class,
        StartTlsRequest.class,
        StartTlsResponse.class,
        UnsolicitedNotification.class,
        UnsolicitedNotificationEvent.class,
        UnsolicitedNotificationListener.class,
})
public class Index {
}

package xd.examples.javax.security.auth.login;

import javax.security.auth.login.AccountException;
import javax.security.auth.login.AccountExpiredException;
import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.ConfigurationSpi;
import javax.security.auth.login.CredentialException;
import javax.security.auth.login.CredentialExpiredException;
import javax.security.auth.login.CredentialNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    AccountException.class,
                    AccountExpiredException.class,
                    AccountLockedException.class,
                    AccountNotFoundException.class,
                    AppConfigurationEntry.class,
                    Configuration.class,
                    ConfigurationSpi.class,
                    CredentialException.class,
                    CredentialExpiredException.class,
                    CredentialNotFoundException.class,
                    FailedLoginException.class,
                    LoginContext.class,
                    LoginException.class
                    ));
        }
    }
}

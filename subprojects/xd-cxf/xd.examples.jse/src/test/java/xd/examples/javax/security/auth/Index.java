package xd.examples.javax.security.auth;

import javax.security.auth.AuthPermission;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.PrivateCredentialPermission;
import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;
import javax.security.auth.Subject;

import static java.util.Arrays.asList;
import static xd.ExampleUtils.ignore;
import static xd.ExampleUtils.skip;

public class Index {
    public void index() {
        if (skip()) {
            ignore(asList(
                    AuthPermission.class,
                    Destroyable.class,
                    DestroyFailedException.class,
                    PrivateCredentialPermission.class,
                    Refreshable.class,
                    RefreshFailedException.class,
                    Subject.class

            ));
        }
    }
}

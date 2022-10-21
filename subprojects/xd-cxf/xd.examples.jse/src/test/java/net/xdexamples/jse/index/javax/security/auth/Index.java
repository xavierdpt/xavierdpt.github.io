package net.xdexamples.jse.index.javax.security.auth;

import net.xdexamples.ExampleIndex;
import net.xdexamples.jse.examples.javax.security.auth.AuthPermissionExample;
import net.xdexamples.jse.examples.javax.security.auth.DestroyableExample;
import net.xdexamples.jse.examples.javax.security.auth.PrivateCredentialPermissionExample;
import net.xdexamples.jse.examples.javax.security.auth.RefreshableExample;
import net.xdexamples.jse.examples.javax.security.auth.SubjectExample;

import javax.security.auth.AuthPermission;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import javax.security.auth.PrivateCredentialPermission;
import javax.security.auth.RefreshFailedException;
import javax.security.auth.Refreshable;
import javax.security.auth.Subject;

@ExampleIndex({
        AuthPermission.class,
        AuthPermissionExample.class,

        Destroyable.class,
        DestroyableExample.class,

        DestroyFailedException.class,

        PrivateCredentialPermission.class,
        PrivateCredentialPermissionExample.class,

        Refreshable.class,
        RefreshableExample.class,

        RefreshFailedException.class,

        Subject.class,
        SubjectExample.class
})
public class Index {

}

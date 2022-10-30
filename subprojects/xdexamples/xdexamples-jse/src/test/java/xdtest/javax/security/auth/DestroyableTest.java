package xdtest.javax.security.auth;

import net.xdexamples.BaseExample;

import javax.security.auth.Destroyable;

public class DestroyableTest extends BaseExample<Destroyable> {

    @Override
    protected void scaffold(Destroyable instance) throws Throwable {
        instance.destroy();
        instance.isDestroyed();
    }
}

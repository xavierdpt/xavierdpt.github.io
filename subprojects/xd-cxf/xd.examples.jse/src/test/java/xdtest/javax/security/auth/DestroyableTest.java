package xdtest.javax.security.auth;

import org.junit.Test;
import xdtest.TestUtils;

import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;

public class DestroyableTest {
    @Test
    public void test() throws DestroyFailedException {
        if (TestUtils.scaffold()) {
            Destroyable destroyable = TestUtils.makeInstance(Destroyable.class);
            destroyable.destroy();
            destroyable.isDestroyed();
        }
    }
}

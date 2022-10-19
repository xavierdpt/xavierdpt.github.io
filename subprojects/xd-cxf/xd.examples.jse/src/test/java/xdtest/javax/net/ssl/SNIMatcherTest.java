package xdtest.javax.net.ssl;

import org.junit.Test;
import xdtest.TestUtils;

import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;

public class SNIMatcherTest {
    @Test
    public void test() {
        if (TestUtils.scaffold()) {
            int type = 0;
            SNIMatcher instance = new SNIMatcher(type) {
                @Override
                public boolean matches(SNIServerName serverName) {
                    return false;
                }
            };
            int type1 = instance.getType();
            SNIServerName serverName = null;
            instance.matches(serverName);
        }
    }
}

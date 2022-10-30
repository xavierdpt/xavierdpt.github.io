package xdtest.javax.net.ssl;

import net.xdexamples.BaseExample;

import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;

public class SNIMatcherTest extends BaseExample<SNIMatcher> {

    @Override
    protected void scaffold(SNIMatcher instance) throws Throwable {
        int type1 = instance.getType();
        SNIServerName serverName = null;
        instance.matches(serverName);
    }
}

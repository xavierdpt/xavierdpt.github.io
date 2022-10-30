package xdtest.org.apache.cxf.bus.extension;

import org.apache.cxf.bus.extension.ExtensionException;
import org.apache.cxf.common.i18n.Message;
import org.junit.Test;

public class ExtensionExceptionTest {
    @Test
    public void test() {
        Message msg = null;
        ExtensionException instance = new ExtensionException(msg);
        Throwable cause = null;
        ExtensionException extensionException = new ExtensionException(msg, cause);
        ExtensionException extensionException1 = new ExtensionException(cause);
    }
}

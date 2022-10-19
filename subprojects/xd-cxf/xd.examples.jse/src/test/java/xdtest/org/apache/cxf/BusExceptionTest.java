package xdtest.org.apache.cxf;

import org.apache.cxf.BusException;
import org.apache.cxf.common.i18n.Message;
import org.junit.Test;

public class BusExceptionTest {
    @Test
    public void test() {
        Message msg = null;
        Throwable cause = null;
        BusException busException = new BusException(msg, cause);
        BusException busException1 = new BusException(msg);
        BusException busException2 = new BusException(cause);


    }
}

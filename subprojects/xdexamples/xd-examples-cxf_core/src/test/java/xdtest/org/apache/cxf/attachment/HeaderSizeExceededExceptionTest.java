package xdtest.org.apache.cxf.attachment;

import org.apache.cxf.attachment.HeaderSizeExceededException;
import org.junit.Test;

public class HeaderSizeExceededExceptionTest {
    @Test
    public void test() {
        HeaderSizeExceededException instance = new HeaderSizeExceededException();
        String message = null;
        HeaderSizeExceededException headerSizeExceededException = new HeaderSizeExceededException(message);
        Throwable cause = null;
        HeaderSizeExceededException headerSizeExceededException1 = new HeaderSizeExceededException(message, cause);
        HeaderSizeExceededException headerSizeExceededException2 = new HeaderSizeExceededException(cause);
    }
}

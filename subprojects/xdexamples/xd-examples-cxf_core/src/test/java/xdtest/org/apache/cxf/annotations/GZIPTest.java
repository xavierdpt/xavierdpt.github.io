package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.GZIP;

public class GZIPTest {

    @GZIP(threshold = 1, force = true)
    public static class Dummy {

    }
}

package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.UseNio;

public class UseNioTest {

    public static class Dummy {
        @UseNio
        public static void foo() {

        }
    }
}

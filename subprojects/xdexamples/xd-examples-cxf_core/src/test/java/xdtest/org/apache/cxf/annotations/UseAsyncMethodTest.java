package xdtest.org.apache.cxf.annotations;

import org.apache.cxf.annotations.UseAsyncMethod;

public class UseAsyncMethodTest {

    public static class Dummy {
        @UseAsyncMethod(always = true)
        public static void foo() {

        }
    }
}
